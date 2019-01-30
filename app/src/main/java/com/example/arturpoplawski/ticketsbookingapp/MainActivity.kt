package com.example.arturpoplawski.ticketsbookingapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity(),LocationSelection {


    override fun onLocationSelected(location: String) {
        createFragment(SearchFragment())
    }

    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById(R.id.bottom_nav) as BottomNavigationView
        bottomNav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        if (intent.getStringExtra("mt")!=null){
            if (intent.getStringExtra("mt").equals("yes")) createFragment(MyTicketsFragment())
        } else {
            val fragment = HomeFragment()
            fragment.setLocationSelection(this)
            createFragment(fragment)
        }


    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId){
            R.id.nav_home -> {
                val fragment = HomeFragment()
                fragment.setLocationSelection(this)
                createFragment(fragment)
                item.setChecked(true)
            }
            R.id.nav_search -> {
                createFragment(SearchFragment())
                item.setChecked(true)
            }
            R.id.nav_user -> {
                createFragment(UserFragment())
                item.setChecked(true)
            }
        }
        false
    }

    fun createFragment(fragment : Fragment){
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


}


