package com.example.mysystemtest.prasention.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mysystemtest.prasention.view.viewHolder.BannerViewHolder
import com.example.mysystemtest.prasention.view.viewHolder.HorizontalItemViewHolder
import com.example.mysystemtest.domain.model.Item
import com.example.mysystemtest.R
import com.example.mysystemtest.prasention.view.viewHolder.SplitItemViewHolder
import com.example.mysystemtest.prasention.view.viewHolder.ViewTypeMapper.Companion.VIEW_TYPE_HORIZONTAL
import com.example.mysystemtest.prasention.view.viewHolder.ViewTypeMapper.Companion.VIEW_TYPE_SPLIT
import com.example.mysystemtest.prasention.view.viewHolder.ViewTypeMapper.Companion.VIEW_TYPE_VERTICAL


class HorizontalAdapterNewX(private var items: List<Item>, var viewType: Any?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    fun updateItems(newItems: List<Item>) {
        this.items = newItems
        notifyDataSetChanged()  // This triggers RecyclerView to update all items. You can use DiffUtil for better performance.
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        return when (viewType) {
            VIEW_TYPE_HORIZONTAL -> VIEW_TYPE_HORIZONTAL
            VIEW_TYPE_VERTICAL -> VIEW_TYPE_VERTICAL
            VIEW_TYPE_SPLIT -> VIEW_TYPE_SPLIT
            else -> VIEW_TYPE_VERTICAL
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            VIEW_TYPE_HORIZONTAL -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_horizontal_scroll, parent, false)
                return HorizontalItemViewHolder(view)
            }
            VIEW_TYPE_VERTICAL -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_banner, parent, false)
                return BannerViewHolder(view)
            }
            else -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_view_split, parent, false)
                return SplitItemViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HorizontalItemViewHolder -> {
                holder.bind(items[position])
            }

            is BannerViewHolder -> {
                holder.bind(items[position])
            }

            is SplitItemViewHolder -> {
                holder.bind(items[position])
            }
        }
    }
}




