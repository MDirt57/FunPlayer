package com.example.funplayer.domain.local.usecases

import com.example.funplayer.domain.VideoListItem
import com.example.funplayer.domain.local.LocalVideoRepository

class AddItemsUsecase(
    private val repository: LocalVideoRepository
) {
    suspend fun addItems(items: List<VideoListItem>){
        repository.addItems(items)
    }
}