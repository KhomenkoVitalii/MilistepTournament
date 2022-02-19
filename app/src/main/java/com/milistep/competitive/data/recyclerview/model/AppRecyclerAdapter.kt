package com.milistep.competitive.data.recyclerview.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.milistep.competitive.R
import com.milistep.competitive.data.db.model.Hangout

class AppRecyclerAdapter() : RecyclerView.Adapter<AppRecyclerAdapter.ViewHolder>() {

    private var hangoutList = emptyList<Hangout>()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(hangout: Hangout){
            itemView.findViewById<TextView>(R.id.item_label).text = hangout.label
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_hangouts, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var currentItem = hangoutList[position]
        holder.bind(currentItem)

        holder.itemView.findViewById<ImageView>(R.id.item_icon).setOnClickListener {
            holder.itemView.findNavController().navigate(R.id.action_listFragment_to_hangoutFragment)
        }
    }

    override fun getItemCount(): Int = hangoutList.size

    fun setData(hangout: List<Hangout>){
        this.hangoutList = hangout
        notifyDataSetChanged()
    }
}