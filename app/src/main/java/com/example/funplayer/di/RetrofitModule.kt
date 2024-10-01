package com.example.funplayer.di

import com.example.funplayer.data.remote.VideoApi
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule{

    @Provides
    @Singleton
    fun provideRetrofitClient(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/MDirt57/FunPlayer/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitService(retrofit: Retrofit): VideoApi {
        return retrofit.create(VideoApi::class.java)
    }

}
