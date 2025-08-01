package com.example.wikipedia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.example.wikipedia.data.ItemPost
import com.example.wikipedia.databinding.ItemExploreBinding
import com.example.wikipedia.databinding.ItemTrendBinding
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

class TrendAdapter(val data: ArrayList<ItemPost>) :
    RecyclerView.Adapter<TrendAdapter.TrendViewHolder>() {
    lateinit var binding: ItemTrendBinding

    inner class TrendViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

        fun bimdViews(itemPost: ItemPost) {

            binding.txtTrendTitle.text = itemPost.txtTitle
            binding.txtTrendSubtitle.text = itemPost.txtSubtitle
            binding.txtTrendInsight.text = itemPost.insight
            binding.numberTop.text = (adapterPosition + 1).toString()

            val requestOptions = RequestOptions()
                .transform(CenterCrop(), RoundedCornersTransformation(24, 0))

            val glide = Glide
                .with(itemView.context)
                .load(itemPost.imgUrl)
                .apply(requestOptions)
                .into(binding.imgTrend)



        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):TrendViewHolder {
        binding = ItemTrendBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return TrendViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: TrendViewHolder, position: Int) {

        holder.bimdViews(data[position])

    }
}