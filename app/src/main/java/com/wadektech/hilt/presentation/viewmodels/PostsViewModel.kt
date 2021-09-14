package com.wadektech.hilt.presentation.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.wadektech.hilt.domain.models.Posts
import com.wadektech.hilt.data.repository.PostsRepositoryImpl
import com.wadektech.hilt.domain.repository.IPostsRepository
import kotlinx.coroutines.launch

class PostsViewModel
@ViewModelInject
constructor(
    private val repository: IPostsRepository
) : ViewModel() {

    private lateinit var _postsPagedList: LiveData<PagedList<Posts>>

    init {
        getAllPostsFromRemote()
        initPagination()
    }

    private fun initPagination() {
        val factory : DataSource.Factory<Int, Posts> = repository.getAllPostsFromLocal()
        val pagedListBuilder: LivePagedListBuilder<Int, Posts> = LivePagedListBuilder<Int, Posts>(factory,
            25)
        _postsPagedList = pagedListBuilder.build()
    }

    fun getAllPosts() : LiveData<PagedList<Posts>>{
       return _postsPagedList
    }

    private fun getAllPostsFromRemote() = viewModelScope.launch {
       repository.getAllPostsFromRemote()
    }
}












