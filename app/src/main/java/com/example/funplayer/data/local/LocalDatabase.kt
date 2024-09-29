package com.example.funplayer.data.local

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [VideoItemEntity::class], version = 1)
abstract class LocalDatabase: RoomDatabase() {

   abstract fun videoDao(): VideoDao

}