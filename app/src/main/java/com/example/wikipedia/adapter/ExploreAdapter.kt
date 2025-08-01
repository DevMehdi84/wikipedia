package com.example.wikipedia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wikipedia.data.ItemPost
import com.example.wikipedia.databinding.ItemExploreBinding

class ExploreAdapter(val data: ArrayList<ItemPost>) :
    RecyclerView.Adapter<ExploreAdapter.ExploreViewHolder>() {
    lateinit var binding: ItemExploreBinding

    inner class ExploreViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

        fun bimdViews(itemPost: ItemPost) {

            val glide = Glide
                .with(itemView.context)
                .load(itemPost.imgUrl)
                .into(binding.imgExplore)

            binding.txtExploreTitle.text = itemPost.txtTitle
            binding.txtExploreSubtitle.text = itemPost.txtSubtitle
            binding.txtExploreDetail.text = itemPost.txtDetail


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreViewHolder {
        binding = ItemExploreBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ExploreViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ExploreViewHolder, position: Int) {

        holder.bimdViews(data[position])

    }
}