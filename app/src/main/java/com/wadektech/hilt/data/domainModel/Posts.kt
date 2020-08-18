package com.wadektech.hilt.data.domainModel

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@Entity(tableName = "posts_db")
@JsonClass(generateAdapter = true)
data class Posts (
    val body: String,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val title: String,
    val userId: Int
)