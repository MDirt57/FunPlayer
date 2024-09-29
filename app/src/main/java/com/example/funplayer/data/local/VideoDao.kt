package com.example.funplayer.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface VideoDao {

    @Query("SELECT * FROM video_cache")
    fun getAllItems(): LiveData<List<VideoItemEntity>>

    @Query("SELECT * FROM video_cache WHERE id = :id")
    fun getItem(id: Int): LiveData<VideoItemEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addItems(items: List<VideoItemEntity>)

    @Query("DELETE FROM video_cache")
    suspend fun clearAll()

}