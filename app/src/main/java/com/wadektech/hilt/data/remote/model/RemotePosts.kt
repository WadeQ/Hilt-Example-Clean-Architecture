package com.wadektech.hilt.data.remote.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RemotePosts(
    @Json(name = "body")
    val body: String,
    @PrimaryKey(autoGenerate = false)
    @Json(name = "id")
    val id: Int,
    @Json(name = "title")
    val title: String,
    @Json(name = "userId")
    val userId: Int
)