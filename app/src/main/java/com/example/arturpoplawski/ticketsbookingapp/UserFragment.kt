package com.example.arturpoplawski.ticketsbookingapp

import android.media.Image
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import java.util.*

class UserFragment: Fragment() {

    var mFragmentStack = Stack<Fragment>()
    val fragmentsHelper : FragmentsHelper = FragmentsHelper()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_user, container, false)

        //
        var cameHereFromUserProfile : Boolean = true

        //Views declarations
        val myTicketsTextView = rootView.findViewById(R.id.myTickets) as TextView
        val myTicketsImageView = rootView.findViewById(R.id.optionImage) as ImageView

        //Fragments stuff
        val mFragmentManager : FragmentManager? = fragmentManager
        var bundle : Bundle = Bundle()

        myTicketsTextView.setOnClickListener {
            bundle.putBoolean("cameHereFromProfile", cameHereFromUserProfile)
            var destinationFragment = MyTicketsFragment()
            destinationFragment.setArguments(bundle)
            fragmentsHelper.switchFragment(mFragmentManager, destinationFragment, mFragmentStack)
        }

        myTicketsImageView.setOnClickListener {
            bundle.putBoolean("cameHereFromProfile", cameHereFromUserProfile)
            var destinationFragment = MyTicketsFragment()
            destinationFragment.setArguments(bundle)
            fragmentsHelper.switchFragment(mFragmentManager, destinationFragment, mFragmentStack)
        }

        return rootView
    }

    companion object {
        fun newInstance(cameHereFromUserProfile : Boolean): UserFragment {
            val fragment = UserFragment()
            val args = Bundle()
            args.putBoolean(true.toString(), cameHereFromUserProfile)
            fragment.setArguments(args)
            return fragment
        }
    }

}