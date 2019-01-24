package com.example.arturpoplawski.ticketsbookingapp

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.reycyler_view.*
import java.util.*

class SearchFragment: Fragment() {

    lateinit var adapter: CustomAdapter
    var ticketsList = ArrayList<Ticket>()
    var mFragmentStack = Stack<Fragment>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_search, container, false)


        val mFragmentManager : FragmentManager? = fragmentManager
        val buttonSearch = rootView.findViewById(R.id.buttonSearch) as Button
        val datePickerEditText = rootView.findViewById(R.id.datePickerEditText) as EditText
        val timePickerEditText = rootView.findViewById(R.id.timePickerEditText) as EditText
        val switch = rootView.findViewById(R.id.imageView3) as ImageView
        val from = rootView.findViewById (R.id.editText3) as EditText
        val to = rootView.findViewById (R.id.editText4) as EditText


        //Calendar
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)

        switch.setOnClickListener({
            val temp = from.text
            from.setText(to.text)
            to.setText(temp)
        })

        buttonSearch.setOnClickListener({

            switchFragment(mFragmentManager, SearchQueryFragment())

            /*mFragmentStack = Stack()
            val transaction = mFragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_container, SearchQueryFragment())
            (mFragmentStack as Stack<Fragment>).push(SearchQueryFragment())
            transaction?.commitAllowingStateLoss()*/
        })

        datePickerEditText.setOnClickListener({

            val dpd = DatePickerDialog(activity, DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->

                // Display Selected date in textbox
                datePickerEditText.setText("" + mDay + "/" + mMonth + "/" + mYear)
            }, year, month, day)

            dpd.show()

        })

        timePickerEditText.setOnClickListener({

            val tpd = TimePickerDialog(activity, TimePickerDialog.OnTimeSetListener{ view, mHour, mMinute ->

                timePickerEditText.setText("" + mHour + ":" + mMinute)

            }, hour, minute, false)

            tpd.show()

        })

       //RecyclerView Stuff
        /*recycler_view_id.layoutManager = LinearLayoutManager(MainActivity(), LinearLayout.VERTICAL, false)
        adapter = CustomAdapter(ticketsList)
        recycler_view_id.adapter = adapter
        adapter.refresh()*/

        return rootView
    }

    fun switchFragment(mFragmentManager : FragmentManager?, destinationFragment : Fragment){
        mFragmentStack = Stack()
        val transaction = mFragmentManager?.beginTransaction()
        transaction?.replace(R.id.fragment_container, destinationFragment)
        (mFragmentStack as Stack<Fragment>).push(SearchQueryFragment())
        transaction?.commitAllowingStateLoss()
    }

}