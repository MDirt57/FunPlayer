package com.example.funplayer.data.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.example.funplayer.domain.VideoListItem
import com.example.funplayer.domain.remote.VideoRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class VideoRepositoryImpl @Inject constructor(
    private val service: VideoApi
): VideoRepository {


    override fun getVideos(): LiveData<List<VideoListItem>> {

        val call = service.getVideos("refs/heads/main/video_data.json")

        val retrofitVideoDataLiveData = MutableLiveData<List<RetrofitVideoData>>()

        call.enqueue(object: Callback<RetrofitResponse> {

            override fun onResponse(p0: Call<RetrofitResponse>, p1: Response<RetrofitResponse>) {
                val body = p1.body()
                Log.d("retrofit", "Body is: $body")
            }

            override fun onFailure(p0: Call<RetrofitResponse>, p1: Throwable) {
                Log.e("retrofit", "failure while getting data: $p1")
            }


        })

//        return listOf<VideoListItem>()

        return MediatorLiveData<List<VideoListItem>>().apply {
            addSource(retrofitVideoDataLiveData){
                value = listOf<VideoListItem>()
            }
        }
    }


}