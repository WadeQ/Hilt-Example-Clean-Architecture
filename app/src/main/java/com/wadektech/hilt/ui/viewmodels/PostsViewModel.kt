package com.wadektech.hilt.ui.viewmodels

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.paging.DataSource
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

    private val _status : MutableLiveData<NetworkStatus<DataSource.Factory<Int,Posts>>> = MutableLiveData()
    val status : MutableLiveData<NetworkStatus<DataSource.Factory<Int, Posts>>>
        get() = _status

    init {

    }

    sealed class MainStateEvent {
        object GetPostsFromRemoteEvent : MainStateEvent()
    }

    @ExperimentalCoroutinesApi
    fun setStateEvent(mainStateEvent: MainStateEvent){
        viewModelScope.launch {
            when(mainStateEvent){
                is MainStateEvent.GetPostsFromRemoteEvent -> {
                    postsRepository.getAllPostsFromRemote()
                        .onEach {status ->
                            _status.value = status
                        }
                        .launchIn(viewModelScope)
                }
            }
        }
    }

}












