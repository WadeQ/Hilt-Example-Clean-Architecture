package com.wadektech.hilt.data.repository

import androidx.paging.DataSource
import com.wadektech.hilt.domain.models.Posts
import com.wadektech.hilt.data.local.models.LocalCacheMapper
import com.wadektech.hilt.data.local.room.PostsDao
import com.wadektech.hilt.data.remote.ApiService
import com.wadektech.hilt.data.remote.model.NetworkMapper
import com.wadektech.hilt.domain.repository.IPostsRepository
import kotlinx.coroutines.*
import timber.log.Timber
import javax.inject.Inject

class PostsRepositoryImpl @Inject constructor(
    private val postsDao: PostsDao,
    private val apiService: ApiService,
    private val networkMapper: NetworkMapper,
    private val localCacheMapper: LocalCacheMapper
) : IPostsRepository
{

    override suspend fun getAllPostsFromRemote()  {
        return withContext(Dispatchers.IO){
            try {
                val postsList = apiService.getAllPostsAsync().await()
                val fetchedPosts = networkMapper.mapFromEntityList(postsList)
                Timber.d("Results are ${fetchedPosts.size}")
                postsDao.saveAllPosts(localCacheMapper.mapToEntityList(fetchedPosts))
            } catch (e : Exception){
                Timber.d("Failure due to ${e.message}")
            }
        }
    }

    override fun getAllPostsFromLocal() : DataSource.Factory<Int, Posts> {
        val cachedPosts = postsDao.getAllPosts()
        return localCacheMapper.mapFromEntityList(cachedPosts)
    }
}












