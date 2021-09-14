package com.wadektech.hilt.utils

import java.lang.Exception

sealed class PostsDataState<out R> {
    data class Success<out T>(val data : T) : PostsDataState<T>()
    data class Error(val exception: Exception) : PostsDataState<Nothing>()
    object Loading : PostsDataState<Nothing>()
}