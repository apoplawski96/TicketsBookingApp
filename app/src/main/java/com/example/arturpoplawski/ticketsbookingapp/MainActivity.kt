package com.example.arturpoplawski.ticketsbookingapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var listView : ListView
    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val whereToGo = ""
        val bottomNav = findViewById(R.id.bottom_nav) as BottomNavigationView
        bottomNav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        if (intent.getStringExtra("mt")!=null){
            if (intent.getStringExtra("mt").equals("yes")) createFragment(MyTicketsFragment())
        } else{
            createFragment(HomeFragment())
        }



        /*listView?.onItemClickListener = object : AdapterView.OnItemClickListener {

            override fun onItemClick(parent: AdapterView<*>, view: View,
                                     position: Int, id: Long) {

                // value of item that is clicked
                val itemValue = listView.getItemAtPosition(position) as UserProfileItem

                createFragment(HomeFragment())

                // Toast the values
                Toast.makeText(applicationContext,
                    "Position :${position}\nItem Value : ${itemValue.name}", Toast.LENGTH_LONG)
                    .show()
            }
        }*/

    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId){
            R.id.nav_home -> {
                createFragment(HomeFragment())
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
