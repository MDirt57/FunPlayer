package com.example.funplayer.di

import android.content.Context
import androidx.room.Room
import com.example.funplayer.data.local.LocalDatabase
import com.example.funplayer.data.local.VideoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RoomModule{


    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): LocalDatabase{
        return Room.databaseBuilder(
            context.applicationContext,
            LocalDatabase::class.java,
            "cache"
        ).build()
    }

    @Provides
    @Singleton
    fun provideDao(database: LocalDatabase): VideoDao{
        return database.videoDao()
    }


}