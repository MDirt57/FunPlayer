package com.example.funplayer.domain.remote.usecases

import androidx.lifecycle.LiveData
import com.example.funplayer.data.remote.VideoApi
import com.example.funplayer.domain.VideoListItem
import com.example.funplayer.domain.remote.VideoRepository


class GetVideosUseCase(
    private val repository: VideoRepository
){

    fun getVideos(): LiveData<List<VideoListItem>>{
        return repository.getVideos()
    }

}