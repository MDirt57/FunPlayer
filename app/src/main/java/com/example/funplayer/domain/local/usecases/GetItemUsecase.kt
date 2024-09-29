package com.example.funplayer.domain.local.usecases

import androidx.lifecycle.LiveData
import com.example.funplayer.domain.VideoListItem
import com.example.funplayer.domain.local.LocalVideoRepository

class GetItemUsecase(
    private val repository: LocalVideoRepository
) {
    fun getItem(id: Int): LiveData<VideoListItem>{
        return repository.getItem(id)
    }
}