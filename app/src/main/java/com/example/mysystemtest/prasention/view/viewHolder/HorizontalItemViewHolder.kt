package com.example.mysystemtest.prasention.view.viewHolder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mysystemtest.domain.model.Item
import com.example.mysystemtest.R

class HorizontalItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val itemImage: ImageView = itemView.findViewById(R.id.itemImage)
    private val itemTitle: TextView = itemView.findViewById(R.id.itemTitle)
    private val itemPrice: TextView = itemView.findViewById(R.id.itemPrice)
    private val itemSubTitle: TextView = itemView.findViewById(R.id.itemSubTitle)

    fun bind(item: Item) {
        itemTitle.text = item.title
        Glide.with(itemView.context).load(item.image).into(itemImage)
    }
}
