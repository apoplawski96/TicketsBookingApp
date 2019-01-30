package com.example.arturpoplawski.ticketsbookingapp

import android.graphics.Point
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageSwitcher
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.squareup.picasso.Picasso

class HomeFragment: Fragment() {

    lateinit var adapter: HorizontalCustomAdapter
    var ticketsList = ArrayList<Ticket>()
    val TAG = "RECYCLERVIEW"
    val display = activity?.windowManager?.defaultDisplay
    var size = Point()
    var width = size.x
    var height = size.y
    lateinit var location : LocationSelection
    lateinit var homeFragmentListener : HomeFragment.HomeFragmentListener

    interface HomeFragmentListener{
        fun onInputSent(input : CharSequence)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)
        val recyclerView = rootView.findViewById(R.id.horizontal_recycler_view) as RecyclerView

        display?.getSize(size)
        width = size.x
        height = size.y

        //Picasso.get().load(R.mipmap.busonstop).resize(width, height).centerCrop().into(homeFragmentBackground)
        recyclerView.layoutManager = LinearLayoutManager(MainActivity(), LinearLayout.HORIZONTAL, false)
        populateListWithFakeStuff()
        adapter = HorizontalCustomAdapter(ticketsList,location)
        Log.d(TAG, "Trying to attach adapter to a recyclerView");
        recyclerView.adapter = adapter
        adapter.refresh()


        return rootView
    }

    fun setLocationSelection(locationSelection: LocationSelection){
        location = locationSelection
    }



    fun populateListWithFakeStuff(){

        ticketsList.add(Ticket("Barcelona", R.mipmap.barcelona2))
        ticketsList.add(Ticket("Berlin", R.mipmap.berlin))
        ticketsList.add(Ticket("Bratislava", R.mipmap.bratislava))
        ticketsList.add(Ticket("Krakow", R.mipmap.krakow))
        ticketsList.add(Ticket("Newcastle", R.mipmap.newcastle))

    }


}