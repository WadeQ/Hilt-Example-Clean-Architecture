package com.wadektech.hilt.data.remote

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    fun getAllPostsAsync(): Deferred<List<RemotePosts>>
}