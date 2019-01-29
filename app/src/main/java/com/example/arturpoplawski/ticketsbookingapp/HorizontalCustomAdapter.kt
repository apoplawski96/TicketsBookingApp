package com.example.arturpoplawski.ticketsbookingapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class HorizontalCustomAdapter (val ticketsList : ArrayList<Ticket>) : RecyclerView.Adapter<HorizontalCustomAdapter.ViewHolder> () {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context).inflate(R.layout.discount_item, parent, false)
        return ViewHolder(layoutInflater)
    }

    override fun getItemCount(): Int {
        return ticketsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ticket : Ticket = ticketsList[position]

        holder?.ticketDestination?.text = ticket.destination
        loadImageInBackground(ticket, holder)

        holder?.backgroundImage.setOnClickListener {

        }
    }

    class ViewHolder(itemView: View)  : RecyclerView.ViewHolder (itemView){
        val ticketDestination = itemView.findViewById(R.id.item_name) as TextView
        val backgroundImage = itemView.findViewById(R.id.background_image) as ImageView
    }

    fun refresh(){
        notifyDataSetChanged()
    }

    fun loadImageInBackground(item : Ticket,  holder : ViewHolder){
        var loadImage = Picasso.get().load(item.imageResourceDir).resize(152,180).centerCrop()
        loadImage.into(holder?.backgroundImage)
    }

}