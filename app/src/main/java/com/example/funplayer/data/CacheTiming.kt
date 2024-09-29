package com.example.funplayer.data

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class CacheTiming @Inject constructor(@ApplicationContext private val context: Context) {

    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("cacheTiming")
        val LAST_MODIFIED = longPreferencesKey("lastDateModified")
    }

    val getData: Flow<Long?> = context.dataStore.data
        .map { preferences ->
            preferences[LAST_MODIFIED] ?: 0L
        }.filter {
            System.currentTimeMillis() / 60000 - it > 5L  // if cache older than 5 minutes
        }.onEach {
            Log.d("timing", it.toString())
        }

    suspend fun saveData(time: Long){
        context.dataStore.edit { preferences ->
            preferences[LAST_MODIFIED] = time
        }
    }

}