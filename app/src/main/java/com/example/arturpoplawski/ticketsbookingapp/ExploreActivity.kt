package com.example.arturpoplawski.ticketsbookingapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class ExploreActivity : AppCompatActivity() {

    val pics: IntArray = intArrayOf(R.mipmap.berlin, R.mipmap.bratislava, R.mipmap.budapest, R.mipmap.krakow, R.mipmap.newcastle)

    //val sliderAdapter = SliderAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explore)
    }
}
