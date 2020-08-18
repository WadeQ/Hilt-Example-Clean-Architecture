package com.wadektech.hilt.ui.viewmodels

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.wadektech.hilt.data.domainModel.Posts
import com.wadektech.hilt.data.repository.PostsRepository
import com.wadektech.hilt.utils.NetworkStatus
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class PostsViewModel
@ViewModelInject
constructor(
    private val postsRepository: PostsRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var _postsPagedList: LiveData<PagedList<Posts>>

    init {
        getAllPostsFromRemote()
        val factory : DataSource.Factory<Int, Posts> = postsRepository.getAllPostsFromLocal()
        val pagedListBuilder: LivePagedListBuilder<Int, Posts> = LivePagedListBuilder<Int, Posts>(factory,
            25)
        _postsPagedList = pagedListBuilder.build()
    }

    fun getAllPosts() : LiveData<PagedList<Posts>>{
       return _postsPagedList
    }

    private fun getAllPostsFromRemote() = viewModelScope.launch {
       postsRepository.getAllPostsFromRemote()
    }
}












