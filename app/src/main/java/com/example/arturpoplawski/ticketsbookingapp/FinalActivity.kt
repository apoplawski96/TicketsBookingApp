package com.example.arturpoplawski.ticketsbookingapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class FinalActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        val goToMyTickets = findViewById(R.id.textView41) as TextView
        goToMyTickets.setOnClickListener({
            val intent = Intent(this, MainActivity::class.java).apply {
                val mt = "yes"
                putExtra("mt", mt)
            }
            startActivity(intent)
        })

    }
}
