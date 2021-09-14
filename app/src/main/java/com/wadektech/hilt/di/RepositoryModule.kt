package com.wadektech.hilt.di

import com.wadektech.hilt.data.local.models.LocalCacheMapper
import com.wadektech.hilt.data.local.room.PostsDao
import com.wadektech.hilt.data.remote.ApiService
import com.wadektech.hilt.data.remote.model.NetworkMapper
import com.wadektech.hilt.data.repository.PostsRepositoryImpl
import com.wadektech.hilt.domain.repository.IPostsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providePostsRepository(
        postsDao: PostsDao,
        apiService: ApiService,
        localCacheMapper: LocalCacheMapper,
        networkMapper: NetworkMapper
    ) = PostsRepositoryImpl(
        postsDao,
        apiService,
        networkMapper,
        localCacheMapper
    ) as IPostsRepository

}