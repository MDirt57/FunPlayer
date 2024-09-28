package com.example.funplayer.data.remote



data class RetrofitResponse(
    var categories: List<RetrofitVideoList>
)

data class RetrofitVideoList(
    var name: String? = null,
    var videos: List<RetrofitVideoData>
)

data class RetrofitVideoData(
    var title: String?,
    var sources: List<String?>,
    var thumb: String?
)