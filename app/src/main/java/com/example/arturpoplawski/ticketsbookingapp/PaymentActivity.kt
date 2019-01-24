package com.example.arturpoplawski.ticketsbookingapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.*
import kotlin.concurrent.schedule


class PaymentActivity : AppCompatActivity() {

    val context : Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        val procPay = findViewById(R.id.procPayment) as TextView

        //procPay.setText("Proceeding payment...")

        //Thread.sleep(5_000)

        Timer().schedule(3000){
            val intent = Intent(context, FinalActivity::class.java).apply {
                //putExtra("asdasd", "asda")
            }
            startActivity(intent)
        }

        /*this@PaymentActivity.runOnUiThread({
            Timer().schedule(1000){
                val intent = Intent(this, RegisterActivity::class.java).apply {
                //putExtra("asdasd", "asda")
            }
                startActivity(intent)
            }
        })*/

    }
}
