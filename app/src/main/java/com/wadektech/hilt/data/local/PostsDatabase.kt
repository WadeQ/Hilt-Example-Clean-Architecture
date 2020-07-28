package com.wadektech.hilt.data.local

import androidx.room.Database
import com.wadektech.hilt.data.Posts

@Database(entities = [Posts::class], version = 1, exportSchema = false)
abstract class PostsDatabase {
    abstract fun postsDao() : PostsDao

    companion object{
       val DATABASE_NAME = "ROOM_DB"
    }
}