package com.example.arturpoplawski.ticketsbookingapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment

class LogRegHolder : AppCompatActivity() {

    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_reg_holder)

        createFragment(LoginFragment())


    }

    fun createFragment(fragment : Fragment){
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_container_2, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
