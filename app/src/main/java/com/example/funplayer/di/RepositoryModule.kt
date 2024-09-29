package com.example.funplayer.di

import com.example.funplayer.data.local.LocalVideoRepositoryImpl
import com.example.funplayer.data.remote.RemoteVideoRepositoryImpl
import com.example.funplayer.domain.local.LocalVideoRepository
import com.example.funplayer.domain.remote.RemoteVideoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRemoteVideoRepository(remoteVideoRepositoryImpl: RemoteVideoRepositoryImpl): RemoteVideoRepository

    @Binds
    @Singleton
    abstract fun bindLocalVideoRepository(localVideoRepository: LocalVideoRepositoryImpl): LocalVideoRepository

}