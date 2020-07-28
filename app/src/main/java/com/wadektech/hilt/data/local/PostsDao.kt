package com.wadektech.hilt.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.wadektech.hilt.data.Posts
import java.util.concurrent.Flow

@Dao
interface PostsDao {
    @Query("SELECT * FROM posts_db ORDER BY id ASC")
    suspend fun getAllPosts(): List<Posts>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAllPosts(posts: List<Posts>)
}