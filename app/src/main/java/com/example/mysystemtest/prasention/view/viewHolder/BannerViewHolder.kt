package com.example.mysystemtest.prasention.view.viewHolder

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mysystemtest.domain.model.Item
import com.example.mysystemtest.R


class BannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val bannerImage: ImageView = itemView.findViewById(R.id.bannerImage)

    fun bind(item: Item) {
        Glide.with(itemView.context).load(item.image).into(bannerImage)
    }
}
