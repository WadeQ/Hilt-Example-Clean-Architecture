package com.wadektech.hilt.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass


data class Posts (
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)