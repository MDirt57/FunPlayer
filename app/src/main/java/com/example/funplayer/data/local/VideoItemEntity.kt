package com.example.funplayer.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "video_cache")
data class VideoItemEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val source: String,
    val preview: String,
    val isFavourite: Boolean
)