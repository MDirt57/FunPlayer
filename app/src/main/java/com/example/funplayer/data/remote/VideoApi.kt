package com.example.funplayer.data.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface VideoApi{

    @GET("{key}")
    fun getVideos(@Path ("key") key: String): Call<RetrofitResponse>

}