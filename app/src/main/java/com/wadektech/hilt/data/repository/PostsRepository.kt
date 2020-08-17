package com.wadektech.hilt.data.repository

import android.annotation.SuppressLint
import androidx.paging.DataSource
import com.wadektech.hilt.data.domainModel.Posts
import com.wadektech.hilt.data.local.LocalCacheMapper
import com.wadektech.hilt.data.local.LocalPosts
import com.wadektech.hilt.data.local.PostsDao
import com.wadektech.hilt.data.remote.ApiService
import com.wadektech.hilt.data.remote.NetworkMapper
import com.wadektech.hilt.utils.NetworkStatus
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber

class PostsRepository

constructor(
    private val postsDao: PostsDao,
    private val apiService: ApiService,
    private val networkMapper: NetworkMapper,
    private val localCacheMapper: LocalCacheMapper
)
{

    suspend fun getAllPostsFromRemote()  {
        try {
            val posts = apiService.getAllPostsAsync().await()
            val postsList = networkMapper.mapFromEntityList(posts)
            Timber.d("Results are ${postsList.size}")
            postsDao.saveAllPosts(localCacheMapper.mapToEntityList(postsList))
        } catch (e : Exception){
            Timber.d("Failure due to ${e.message}")
        }
    }

    suspend fun getAllPostsFromLocal() : DataSource.Factory<Int, Posts> {
        val cachedPosts = postsDao.getAllPosts()
        return localCacheMapper.mapFromEntityList(cachedPosts)
    }
}












