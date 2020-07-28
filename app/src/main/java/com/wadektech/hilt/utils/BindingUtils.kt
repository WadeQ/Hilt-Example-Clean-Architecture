package com.wadektech.hilt.utils

import androidx.databinding.BindingAdapter
import androidx.paging.PagedList
import androidx.recyclerview.widget.RecyclerView
import com.wadektech.hilt.data.domainModel.Posts
import com.wadektech.hilt.ui.adapter.PostsAdapter
import timber.log.Timber



@BindingAdapter("postsBindingAdapter")
fun bindConcertsAdapter(recyclerView: RecyclerView, posts: PagedList<Posts>?){
    val adapter = recyclerView.adapter as PostsAdapter
    Timber.d("binding adapter list size is: ${posts?.size}")
    adapter.submitList(posts)
}