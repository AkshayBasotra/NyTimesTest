package com.test.xebia.nytimes.newsList.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.test.xebia.nytimes.databinding.NewsRowBinding
import com.test.xebia.nytimes.newsList.data.NewsModel

class NewsAdapter : ListAdapter<NewsModel, NewsAdapter.MyViewHolder>(
    DiffCallback()
) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            NewsRowBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val newsModel = getItem(position)
        holder.apply {
            bind(item = newsModel)
        }
    }

    class MyViewHolder(private val binding: NewsRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind( item: NewsModel) {
            binding.apply {
                newsmodel = item
                imageUrl = item.media?.get(0)?.media_metadata?.get(0)?.url ?: ""
                executePendingBindings()
            }
        }
    }
}

private class DiffCallback : DiffUtil.ItemCallback<NewsModel>() {

    override fun areItemsTheSame(oldItem: NewsModel, newItem: NewsModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: NewsModel, newItem: NewsModel): Boolean {
        return oldItem == newItem
    }
}