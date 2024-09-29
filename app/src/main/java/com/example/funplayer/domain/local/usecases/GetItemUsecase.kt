package com.example.funplayer.domain.local.usecases

import com.example.funplayer.domain.VideoListItem
import com.example.funplayer.domain.local.LocalVideoRepository

class GetItemUsecase(
    private val repository: LocalVideoRepository
) {
    suspend fun getItem(id: Int): VideoListItem{
        return repository.getItem(id)
    }
}