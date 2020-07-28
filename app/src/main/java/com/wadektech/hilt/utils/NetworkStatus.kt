package com.wadektech.hilt.utils

import java.lang.Exception

sealed class NetworkStatus<out R> {
    data class SUCCESS<out T>(val data : T) : NetworkStatus<T>()

    data class ERROR(val exception: Exception) : NetworkStatus<Nothing>()

    object Loading : NetworkStatus<Nothing>()
}