package com.example.screendesign

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

fun getDummyUrl(): List<String> {

    return listOf("https://picsum.photos/id/237/200/300",
                            "https://picsum.photos/seed/picsum/200/300",
                            "https://picsum.photos/200/300?grayscale",
                            "https://picsum.photos/200/300/?blur")
}

class ViewPagerAdapter(private var imageUrlList: List<String>) : RecyclerView.Adapter<ViewPagerAdapter.Pager2ViewHolder>() {
    inner class Pager2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun onBind(imgUrl: String) {
            val imageId = itemView.findViewById<AppCompatImageView>(R.id.ivDescImage)
            Glide.with(itemView.context)
                .load(imgUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageId)

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewPagerAdapter.Pager2ViewHolder {
        return Pager2ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_image_vp, parent, false))
    }

    override fun onBindViewHolder(holder: ViewPagerAdapter.Pager2ViewHolder, position: Int) {
        val imgUrl = imageUrlList[position]
        holder.onBind(imgUrl)
    }

    override fun getItemCount(): Int {
        return imageUrlList.size
    }
}