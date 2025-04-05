package com.example.mysystemtest.prasention.view.viewHolder

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mysystemtest.domain.model.Item
import com.example.mysystemtest.R
import com.example.mysystemtest.prasention.view.viewHolder.ViewTypeMapper.Companion.VIEW_TYPE_HORIZONTAL
import com.example.mysystemtest.prasention.view.viewHolder.ViewTypeMapper.Companion.VIEW_TYPE_SPLIT
import com.example.mysystemtest.prasention.view.viewHolder.ViewTypeMapper.Companion.VIEW_TYPE_VERTICAL
import com.example.mysystemtest.prasention.view.adapter.HorizontalAdapterNewX


class BaseViewHolder(itemView: View, viewPool: RecyclerView.RecycledViewPool, viewType: Int) : RecyclerView.ViewHolder(itemView) {
    private val recyclerView: RecyclerView = itemView.findViewById(R.id.recyclerView)
    private val itemTitle: TextView = itemView.findViewById(R.id.bannerTitle)
    private val viewType = viewType

    init {
        recyclerView.setRecycledViewPool(viewPool)
        if (viewType == VIEW_TYPE_HORIZONTAL) {
            recyclerView.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
            itemTitle.text = "Horizontal"
        } else if (viewType == VIEW_TYPE_VERTICAL) {
            recyclerView.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.VERTICAL, false)
            itemTitle.text = "Vertical"
        } else if (viewType == VIEW_TYPE_SPLIT) {
            recyclerView.layoutManager = GridLayoutManager(itemView.context, 2, LinearLayoutManager.VERTICAL, false)
            itemTitle.text = "Split Banner"
        }
        recyclerView.setHasFixedSize(true)  // Optional for better performance

    }


    fun bind(items: List<Item>) {
        recyclerView.adapter = HorizontalAdapterNewX(items, viewType)
        // Reset layout params to ensure correct height (if needed)
        itemView.layoutParams = itemView.layoutParams.apply {
            height = ViewGroup.LayoutParams.WRAP_CONTENT // Ensure height is reset
        }

    }
}