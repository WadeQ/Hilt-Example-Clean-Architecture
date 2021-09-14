package com.wadektech.hilt.domain.repository

import androidx.paging.DataSource
import com.wadektech.hilt.domain.models.Posts


interface IPostsRepository {

    suspend fun getAllPostsFromRemote()

    fun getAllPostsFromLocal() : DataSource.Factory<Int, Posts>
}