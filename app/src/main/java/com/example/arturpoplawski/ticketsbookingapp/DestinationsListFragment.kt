package com.example.arturpoplawski.ticketsbookingapp

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.Toast
import android.widget.AdapterView.OnItemClickListener
import java.util.*

class DestinationsListFragment : Fragment() {

    lateinit var listView : ListView
    var destinationsArrayList = ArrayList<UserProfileItem>()
    val TAG = "LISTVIEW"
    val manager = this.fragmentManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_destinations_list, container, false)

        //ListView stuff
        listView = rootView.findViewById(R.id.destinationsList) as ListView
        populateDestinationsList()
        listView.adapter = ListViewCustomAdapter(activity?.applicationContext, destinationsArrayList)

        listView.onItemClickListener = object : AdapterView.OnItemClickListener {

            override fun onItemClick(parent: AdapterView<*>, view: View,
                                     position: Int, id: Long) {

                // value of item that is clicked
                val itemValue = listView.getItemAtPosition(position) as UserProfileItem

                createFragment(UserFragment())

                // Toast the values
                Toast.makeText(activity,
                    "Position :${position}\nItem Value : ${itemValue.name}", Toast.LENGTH_LONG)
                    .show()
            }
        }

        return rootView
    }

    fun createFragment(fragment : Fragment) {
        val transaction = manager?.beginTransaction()
        transaction?.replace(R.id.fragment_container, fragment)
        transaction?.addToBackStack(null)
        transaction?.commit()
    }

    fun populateDestinationsList(){
        destinationsArrayList.add(UserProfileItem("Athens", R.mipmap.athens_big))
        destinationsArrayList.add(UserProfileItem("Barcelona", R.mipmap.barcelona2))
        destinationsArrayList.add(UserProfileItem("Berlin", R.mipmap.berlin_big))
        destinationsArrayList.add(UserProfileItem("Budapest", R.mipmap.budapest_big))
        destinationsArrayList.add(UserProfileItem("Lisbon", R.mipmap.lisbon_big))
        destinationsArrayList.add(UserProfileItem("London", R.mipmap.london_big))
        destinationsArrayList.add(UserProfileItem("Madrid", R.mipmap.madrid_big))
        destinationsArrayList.add(UserProfileItem("Warsaw", R.mipmap.warsaw_big))

    }

}
