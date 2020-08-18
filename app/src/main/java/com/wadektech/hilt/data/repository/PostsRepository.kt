package com.wadektech.hilt.data.repository

import androidx.paging.DataSource
import com.wadektech.hilt.data.domainModel.Posts
import com.wadektech.hilt.data.local.LocalCacheMapper
import com.wadektech.hilt.data.local.PostsDao
import com.wadektech.hilt.data.remote.ApiService
import com.wadektech.hilt.data.remote.NetworkMapper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber

class PostsRepository

constructor(
    private val postsDao: PostsDao,
    private val apiService: ApiService,
    private val networkMapper: NetworkMapper,
    private val localCacheMapper: LocalCacheMapper
)
{
    private var job = Job()
    private val _coroutineScope = CoroutineScope(job + Dispatchers.IO)

    fun getAllPostsFromRemote()  {
        _coroutineScope.launch {
            try {
                val postsList = apiService.getAllPostsAsync()
                val posts = postsList.await()
                val fetchedPosts = networkMapper.mapFromEntityList(posts)
                Timber.d("Results are ${fetchedPosts.size}")
                postsDao.saveAllPosts(localCacheMapper.mapToEntityList(fetchedPosts))
            } catch (e : Exception){
                Timber.d("Failure due to ${e.message}")
            }
        }
    }

    fun getAllPostsFromLocal() : DataSource.Factory<Int, Posts> {
        val cachedPosts = postsDao.getAllPosts()
        return localCacheMapper.mapFromEntityList(cachedPosts)
    }
}












