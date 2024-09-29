package com.example.funplayer.data.remote

import com.example.funplayer.domain.VideoListItem

object RetrofitDataMapper {

    fun retrofitVideoDataToVideoListItem(
        retrofitItemList: List<RetrofitVideoData>
    ): List<VideoListItem>{
        return retrofitItemList.map { it ->
            VideoListItem(
                title = it.title ?: "",
                source = (it.sources[0] ?: "").replace("http", "https"),
                preview = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/" + it.thumb
            )
        }
    }


}