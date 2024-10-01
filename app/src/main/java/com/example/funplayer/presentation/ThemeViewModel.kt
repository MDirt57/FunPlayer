package com.example.funplayer.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.funplayer.data.CacheData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ThemeViewModel @Inject constructor(
    private val cacheData: CacheData
): ViewModel() {


    fun getTheme(): Flow<Boolean?> {
        return cacheData.getTheme
    }

    fun switchTheme(onDark: Boolean?){

        viewModelScope.launch {
            cacheData.saveTheme(onDark)
        }

    }


}