package com.example.arturpoplawski.ticketsbookingapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.Button
import android.widget.TextView

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val signUpTextView = findViewById(R.id.sign_in_text) as TextView
        val signUpButton = findViewById(R.id.sign_up_button) as Button

        signUpTextView.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java).apply {
                //putExtra("asdasd", "asda")
            }
            startActivity(intent)
        }

        signUpButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java).apply {
                //putExtra("asdasd", "asda")
            }
            startActivity(intent)
        }

    }


}
