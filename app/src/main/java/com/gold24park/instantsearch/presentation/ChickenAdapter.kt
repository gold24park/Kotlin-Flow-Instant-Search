package com.gold24park.instantsearch.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gold24park.instantsearch.R
import kotlinx.android.synthetic.main.item_chicken.view.*

class ChickenAdapter : RecyclerView.Adapter<ChickenAdapter.ViewHolder>() {

    private var list = mutableListOf<String>()

    fun submitList(list: List<String>) {
        this.list = list.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChickenAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chicken, null, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(text: String) {
            itemView.tv_name.text = text
        }
    }

}