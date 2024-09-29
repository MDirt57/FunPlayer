package com.example.funplayer.domain.local

import androidx.lifecycle.LiveData
import com.example.funplayer.domain.VideoListItem

interface LocalVideoRepository {

    fun getAllItems(): LiveData<List<VideoListItem>>

    suspend fun getItem(id: Int): VideoListItem

    suspend fun addItems(items: List<VideoListItem>)

    suspend fun clearAll()


}