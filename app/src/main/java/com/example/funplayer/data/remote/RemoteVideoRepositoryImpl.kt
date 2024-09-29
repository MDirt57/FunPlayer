package com.example.funplayer.data.remote

import android.util.Log
import com.example.funplayer.domain.VideoListItem
import com.example.funplayer.domain.remote.RemoteVideoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class RemoteVideoRepositoryImpl @Inject constructor(
    private val service: VideoApi
): RemoteVideoRepository {


    override suspend fun getVideos(): Flow<List<VideoListItem>> = flow {

        val call = service.getVideos("refs/heads/main/video_data.json")

        var retrofitVideoDataLiveData = emptyList<RetrofitVideoData>()

        val response = call.execute()
        if (response.isSuccessful){
            retrofitVideoDataLiveData = response.body()?.categories?.get(0)?.videos ?: emptyList()
            emit(RetrofitDataMapper.retrofitVideoDataToVideoListItem(retrofitVideoDataLiveData))
            Log.d("retrofit", "Data: $retrofitVideoDataLiveData")
        } else{
            Log.e("retrofit", "failure while getting data: ${response.errorBody()}")
        }

    }


}