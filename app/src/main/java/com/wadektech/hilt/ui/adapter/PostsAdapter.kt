package com.wadektech.hilt.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.wadektech.hilt.data.domainModel.Posts
import com.wadektech.hilt.databinding.PostsListItemBinding

class PostsAdapter : PagedListAdapter<Posts, PostsAdapter.ViewHolder>(PostsDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val posts = getItem(position)
        if (posts != null){
            holder.bind(posts)
        }
    }

    class ViewHolder private constructor(private val binding: PostsListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(posts: Posts){
            binding.post = posts
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = PostsListItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    class PostsDiffUtil : DiffUtil.ItemCallback<Posts>(){
        override fun areItemsTheSame(oldItem: Posts, newItem: Posts): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Posts, newItem: Posts): Boolean {
            return oldItem.id == newItem.id
        }
    }
}