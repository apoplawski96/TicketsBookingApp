package com.example.arturpoplawski.ticketsbookingapp

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class LoginActivity : AppCompatActivity() {

    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val signUpTextView = findViewById(R.id.sign_up_text) as TextView
        val signInButton = findViewById(R.id.sign_in_button) as Button
        val editText = findViewById(R.id.editText) as EditText
        val editText2 = findViewById(R.id.editText2) as EditText

        fun String.toColor(): Int = Color.parseColor(this)

        signUpTextView.setOnClickListener {

            val intent = Intent(this, RegisterActivity::class.java).apply {
                //putExtra("asdasd", "asda")
            }
            startActivity(intent)

        }

        signInButton.setOnClickListener{

            /*if (editText.text.isEmpty()){
                editText.setText("You cannot leave empty fields!")
            } else if (editText2.text.isEmpty()){
                editText2.setText("You cannot leave empty fields!")
            }*/

            val intent = Intent(this, MainActivity::class.java).apply {
                //putExtra("asdasd", "asda")
            }
            startActivity(intent)

        }

    }


}
