package com.example.funplayer.domain.remote

import androidx.lifecycle.LiveData
import com.example.funplayer.domain.VideoListItem

interface VideoRepository {

    fun getVideos(): LiveData<List<VideoListItem>>

}