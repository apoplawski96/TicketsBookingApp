package com.example.arturpoplawski.ticketsbookingapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import com.ramotion.foldingcell.FoldingCell
import kotlinx.android.synthetic.main.reycyler_view.*
import java.util.*

class SearchQueryFragment: Fragment() {

    lateinit var adapter: CustomAdapter
    var ticketsList = ArrayList<Ticket>()
    val TAG = "RECYCLERVIEW"
    var mFragmentStack = Stack<Fragment>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_search_query, container, false)

       //RecyclerView stuff
        val mFragmentManager : FragmentManager? = fragmentManager
        val recyclerView = rootView.findViewById(R.id.recycler_view_id) as? RecyclerView

        //Fragments stuff
        var bundle : Bundle? = this.getArguments()

        recyclerView?.layoutManager = LinearLayoutManager(MainActivity(), LinearLayout.VERTICAL, false)
        populateListWithFakeStuff()
        adapter = CustomAdapter(ticketsList)
        Log.d(TAG, "Trying to attach adapter to a recyclerView");
        recyclerView?.adapter = adapter
        adapter.refresh()

        return rootView
    }

    fun populateListWithFakeStuff(){

        var i = 0

        while (i<9){
            ticketsList.add(Ticket("Madrid, Spain", R.mipmap.bus_desert))
            i++
        }
    }

    fun switchFragment(mFragmentManager : FragmentManager?, destinationFragment : Fragment){
        mFragmentStack = Stack()
        val transaction = mFragmentManager?.beginTransaction()
        transaction?.replace(R.id.fragment_container, destinationFragment)
        (mFragmentStack as Stack<Fragment>).push(destinationFragment)
        transaction?.commitAllowingStateLoss()
    }

}