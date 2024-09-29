package com.example.funplayer.domain

data class VideoListItem(
    val title: String,
    val source: String = "",
    val preview: String = "",
    val isFavourite: Boolean = false,
    val id: Int = -1
)
