package com.example.arturpoplawski.ticketsbookingapp

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import java.util.*

class FragmentsHelper {

    //**Switching fragment from another fragment**
    /*
    You have to declare following variables inside your class:

    var mFragmentStack = Stack<Fragment>()
    val mFragmentManager : FragmentManager? = fragmentManager

     */
    fun switchFragment(mFragmentManager : FragmentManager?, mDestinationFragment : Fragment, mFragmentStack : Stack<Fragment>){
        val transaction = mFragmentManager?.beginTransaction()
        transaction?.replace(R.id.fragment_container, mDestinationFragment)
        (mFragmentStack).push(mDestinationFragment)
        transaction?.commitAllowingStateLoss()
    }

}