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
    var userProfileItems : ArrayList<UserProfileItem> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_user, container, false)

        //
        var cameHereFromUserProfile : Boolean = true

        //Views declarations
        val myTicketsTextView = rootView.findViewById(R.id.myTickets) as TextView
        val settingsTextView = rootView.findViewById(R.id.optionName2) as TextView
        val contactTextView = rootView.findViewById(R.id.optionName3) as TextView
        val logoutTextView = rootView.findViewById(R.id.logoutName) as TextView
        val myTicketsImageView = rootView.findViewById(R.id.optionImage) as ImageView
        val settingsImageView = rootView.findViewById(R.id.optionImage2) as ImageView
        val contactImageView = rootView.findViewById(R.id.optionImage3) as ImageView
        val logoutImageView = rootView.findViewById(R.id.logoutImage) as ImageView
        val muTicketsFragmgentObj = MyTicketsFragment() as Fragment

        //Fragments stuff
        val mFragmentManager : FragmentManager? = fragmentManager
        var bundle : Bundle = Bundle()

        myTicketsTextView.setOnClickListener({
            bundle.putBoolean("cameHereFromProfile", cameHereFromUserProfile)
            var destinationFragment = MyTicketsFragment()
            destinationFragment.setArguments(bundle)
            switchFragment(mFragmentManager, destinationFragment)
        })

        myTicketsImageView.setOnClickListener({
            bundle.putBoolean("cameHereFromProfile", cameHereFromUserProfile)
            var destinationFragment = MyTicketsFragment()
            destinationFragment.setArguments(bundle)
            switchFragment(mFragmentManager, destinationFragment)
        })

        return rootView
    }

    fun populateUserProfileItemsArray(){
        userProfileItems.add(UserProfileItem("MyTickets", R.drawable.ic_home_black_24dp))
        userProfileItems.add(UserProfileItem("Settings", R.drawable.ic_home_black_24dp))
        userProfileItems.add(UserProfileItem("Contact", R.drawable.ic_home_black_24dp))
    }

    fun switchFragment(mFragmentManager : FragmentManager?, destinationFragment : Fragment){
        mFragmentStack = Stack()
        val transaction = mFragmentManager?.beginTransaction()
        transaction?.replace(R.id.fragment_container, destinationFragment)
        (mFragmentStack as Stack<Fragment>).push(SearchQueryFragment())
        transaction?.commitAllowingStateLoss()
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