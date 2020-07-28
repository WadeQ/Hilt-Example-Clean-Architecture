package com.wadektech.hilt.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wadektech.hilt.data.domainModel.Posts

@Database(entities = [Posts::class], version = 1, exportSchema = false)
abstract class PostsDatabase : RoomDatabase(){
    abstract fun postsDao() : PostsDao

    companion object{
       const val DATABASE_NAME : String = "ROOM_DB"
    }
}