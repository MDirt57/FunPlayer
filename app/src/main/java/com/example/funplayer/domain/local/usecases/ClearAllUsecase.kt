package com.example.funplayer.domain.local.usecases

import com.example.funplayer.domain.local.LocalVideoRepository

class ClearAllUsecase(
    private val repository: LocalVideoRepository
) {
    suspend fun clearAll(){
        repository.clearAll()
    }
}