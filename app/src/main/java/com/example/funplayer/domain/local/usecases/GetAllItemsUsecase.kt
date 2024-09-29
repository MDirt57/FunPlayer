package com.example.funplayer.domain.local.usecases

import androidx.lifecycle.LiveData
import com.example.funplayer.domain.VideoListItem
import com.example.funplayer.domain.local.LocalVideoRepository

class GetAllItemsUsecase(
    private val repository: LocalVideoRepository
) {
    fun getAllItems(): LiveData<List<VideoListItem>>{
        return repository.getAllItems()
    }
}