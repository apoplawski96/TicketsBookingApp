package com.example.arturpoplawski.ticketsbookingapp

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment

import com.ramotion.foldingcell.FoldingCell

class CustomAdapter (val ticketsList : ArrayList<Ticket>) : RecyclerView.Adapter<CustomAdapter.ViewHolder> () {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context).inflate(R.layout.folding_cell, parent, false)
        return ViewHolder(layoutInflater)
    }

    override fun getItemCount(): Int {
        return ticketsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ticket : Ticket = ticketsList[position]

        holder?.ticketDestination?.text = ticket.destination
        holder?.fc.setOnClickListener {
            holder?.fc.toggle(false)
        }


        holder?.bt.setOnClickListener {

            val intent = Intent(it.context, PaymentActivity::class.java).apply {
                //putExtra("asdasd", "asda")
            }
            it.context.startActivity(intent)
        }
    }

    class ViewHolder(itemView: View)  : RecyclerView.ViewHolder (itemView){
        val fc = itemView.findViewById(R.id.folding_cell) as FoldingCell
        val bt = itemView.findViewById(R.id.buyTicketButton) as Button

        val ticketDestination = itemView.findViewById(R.id.cityAndCountryDestination2) as TextView
    }

    fun refresh(){
        notifyDataSetChanged()
    }

}