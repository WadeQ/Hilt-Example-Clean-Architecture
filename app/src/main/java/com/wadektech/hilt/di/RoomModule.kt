package com.wadektech.hilt.di

import android.content.Context
import androidx.room.Room
import com.wadektech.hilt.data.local.room.PostsDao
import com.wadektech.hilt.data.local.room.PostsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@InstallIn(ApplicationComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun providePostsDatabase(@ApplicationContext context: Context) : PostsDatabase {
        return Room.databaseBuilder(
            context,
            PostsDatabase::class.java,
            PostsDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun providePostsDao(postsDatabase: PostsDatabase) : PostsDao {
        return postsDatabase.postsDao()
    }
}