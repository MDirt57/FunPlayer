package com.example.funplayer.domain.remote

import com.example.funplayer.domain.VideoListItem
import kotlinx.coroutines.flow.Flow


interface RemoteVideoRepository {

    suspend fun getVideos(): Flow<List<VideoListItem>>

}