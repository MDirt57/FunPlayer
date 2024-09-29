package com.example.funplayer.data.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.funplayer.domain.VideoListItem
import com.example.funplayer.domain.local.LocalVideoRepository
import javax.inject.Inject


class LocalVideoRepositoryImpl @Inject constructor(
    private val videoDao: VideoDao
): LocalVideoRepository {

    override fun getAllItems(): LiveData<List<VideoListItem>> {
        return MediatorLiveData<List<VideoListItem>>().apply {
            addSource(videoDao.getAllItems()){
                value = it.map {RoomDataMapper.entityToItem(it)}
            }
        }
    }

    override fun getItem(id: Int): LiveData<VideoListItem> {
        return MediatorLiveData<VideoListItem>().apply {
            addSource(videoDao.getItem(id)){
                value = RoomDataMapper.entityToItem(it)
            }
        }
    }

    override suspend fun addItems(items: List<VideoListItem>) {
        videoDao.addItems(
            items.map{ RoomDataMapper.itemToEntity(it) }
        )
    }

    override suspend fun clearAll() {
        videoDao.clearAll()
    }


}