package com.wadektech.hilt.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.wadektech.hilt.domain.models.Posts
import com.wadektech.hilt.presentation.adapter.PostsAdapter
import timber.log.Timber

@BindingAdapter("postsBindingAdapter")
fun bindPostsAdapter(recyclerView: RecyclerView, posts: List<Posts>?){
    val adapter = recyclerView.adapter as PostsAdapter
    Timber.d("binding adapter list size is: ${posts?.size}")
    adapter.submitList(posts)
}