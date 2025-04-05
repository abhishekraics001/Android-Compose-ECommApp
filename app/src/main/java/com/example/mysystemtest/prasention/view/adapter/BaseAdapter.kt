package com.example.mysystemtest.prasention.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mysystemtest.prasention.view.viewHolder.BannerViewHolder
import com.example.mysystemtest.prasention.view.viewHolder.BaseViewHolder
import com.example.mysystemtest.R
import com.example.mysystemtest.domain.model.DashboardModel
import com.example.mysystemtest.prasention.view.viewHolder.ViewTypeMapper.Companion.VIEW_TYPE_BANNER
import com.example.mysystemtest.prasention.view.viewHolder.ViewTypeMapper.Companion.VIEW_TYPE_HORIZONTAL
import com.example.mysystemtest.prasention.view.viewHolder.ViewTypeMapper.Companion.VIEW_TYPE_SPLIT
import com.example.mysystemtest.prasention.view.viewHolder.ViewTypeMapper.Companion.VIEW_TYPE_VERTICAL

class SectionAdapterNew(private val sections: List<DashboardModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val viewPool = RecyclerView.RecycledViewPool()



    override fun getItemCount(): Int = sections.size

    override fun getItemViewType(position: Int): Int {
        return when (sections[position].sectionType) {
            "banner" -> VIEW_TYPE_BANNER
            "horizontalFreeScroll" -> VIEW_TYPE_HORIZONTAL
            "verticalFreeScroll" -> VIEW_TYPE_VERTICAL
            "splitBanner" -> VIEW_TYPE_SPLIT
            else -> throw IllegalArgumentException("Unknown section type")
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_BANNER -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_banner, parent, false)
                BannerViewHolder(view)
            }
            else -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.recycleview_itemslist, parent, false)
                BaseViewHolder(view, viewPool, viewType)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is BannerViewHolder -> holder.bind(sections[position].items[0])
            is BaseViewHolder -> holder.bind(sections[position].items)
        }
    }


}




