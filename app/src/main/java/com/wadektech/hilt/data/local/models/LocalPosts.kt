package com.wadektech.hilt.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@Entity(tableName = "posts_db")
@JsonClass(generateAdapter = true)
data class LocalPosts(
    val body: String,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val title: String,
    val userId: Int
)