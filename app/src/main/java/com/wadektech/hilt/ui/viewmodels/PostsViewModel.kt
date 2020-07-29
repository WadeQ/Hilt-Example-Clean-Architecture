package com.wadektech.hilt.ui.viewmodels

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.wadektech.hilt.data.repository.PostsRepository

class PostsViewModel
@ViewModelInject
constructor(
    private val postsRepository: PostsRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

}