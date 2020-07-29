package com.wadektech.hilt.di

import com.wadektech.hilt.data.local.LocalCacheMapper
import com.wadektech.hilt.data.local.PostsDao
import com.wadektech.hilt.data.remote.ApiService
import com.wadektech.hilt.data.remote.NetworkMapper
import com.wadektech.hilt.data.repository.PostsRepository
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
    ) : PostsRepository {
        return PostsRepository(postsDao,apiService,networkMapper,localCacheMapper)
    }
}