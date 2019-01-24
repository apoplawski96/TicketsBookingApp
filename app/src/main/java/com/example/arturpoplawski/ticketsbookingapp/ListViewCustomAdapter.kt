package com.example.arturpoplawski.ticketsbookingapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class ListViewCustomAdapter (var context : Context?, var userProfileItems : ArrayList <UserProfileItem>) : BaseAdapter() {

    class ViewHolder(row: View?){
        var optionName : TextView
        var optionImage : ImageView

        init {
            this.optionImage = row?.findViewById(R.id.optionImage) as ImageView
            this.optionName = row?.findViewById(R.id.optionName) as TextView
        }

    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View?
        var viewHolder: ViewHolder

        if (convertView == null){
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.destination_item, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        var userProfileItem : UserProfileItem = getItem(position) as UserProfileItem
        viewHolder.optionName.text = userProfileItem.name
        loadImageInBackground(userProfileItem, viewHolder)


        return view as View
    }

    fun loadImageInBackground(item : UserProfileItem,  holder : ListViewCustomAdapter.ViewHolder){
        var loadImage = Picasso.get().load(item.image).resize(395,150).centerCrop()
        loadImage.into(holder?.optionImage)
    }

    override fun getItem(position: Int): Any {
        return userProfileItems.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return userProfileItems.count()
    }
}