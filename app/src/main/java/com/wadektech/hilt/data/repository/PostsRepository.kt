package com.wadektech.hilt.data.repository

import com.wadektech.hilt.data.domainModel.Posts
import com.wadektech.hilt.data.local.LocalCacheMapper
import com.wadektech.hilt.data.local.LocalPosts
import com.wadektech.hilt.data.local.PostsDao
import com.wadektech.hilt.data.remote.ApiService
import com.wadektech.hilt.data.remote.NetworkMapper
import com.wadektech.hilt.utils.NetworkStatus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PostsRepository
constructor(
    private val postsDao: PostsDao,
    private val apiService: ApiService,
    private val networkMapper: NetworkMapper,
    private val localCacheMapper: LocalCacheMapper
){

    suspend fun getAllPostsFromRemote() : Flow<NetworkStatus<List<Posts>>> = flow {
        emit(NetworkStatus.Loading)
        try {
            val posts = apiService.getAllPostsAsync()
            val postsList = networkMapper.mapFromEntityList(posts)
            postsDao.saveAllPosts(localCacheMapper.mapToEntityList(postsList))
            val cachedPosts = postsDao.getAllPosts()
            emit(NetworkStatus.SUCCESS(localCacheMapper.mapFromEntityList(cachedPosts)))
        } catch (e : Exception){
            emit(NetworkStatus.ERROR(e))
        }
    }

}












