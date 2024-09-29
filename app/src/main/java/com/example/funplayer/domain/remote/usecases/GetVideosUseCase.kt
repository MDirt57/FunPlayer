package com.example.funplayer.domain.remote.usecases

import com.example.funplayer.domain.VideoListItem
import com.example.funplayer.domain.remote.RemoteVideoRepository
import kotlinx.coroutines.flow.Flow


class GetVideosUseCase(
    private val repository: RemoteVideoRepository
){

    suspend fun getVideos(): Flow<List<VideoListItem>>{
        return repository.getVideos()
    }

}