package com.wadektech.hilt.data.remote

import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getAllPostsAsync(): List<RemotePosts>
}