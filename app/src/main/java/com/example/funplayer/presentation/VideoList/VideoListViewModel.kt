package com.example.funplayer.presentation.VideoList

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.funplayer.data.CacheData
import com.example.funplayer.domain.VideoListItem
import com.example.funplayer.domain.local.LocalVideoRepository
import com.example.funplayer.domain.local.usecases.AddItemsUsecase
import com.example.funplayer.domain.local.usecases.ClearAllUsecase
import com.example.funplayer.domain.local.usecases.GetAllItemsUsecase
import com.example.funplayer.domain.remote.RemoteVideoRepository
import com.example.funplayer.domain.remote.usecases.GetVideosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class VideoListViewModel @Inject constructor(
    private val remoteRepository: RemoteVideoRepository,
    private val localRepository: LocalVideoRepository,
    private val cacheData: CacheData
) : ViewModel() {

    private val getVideosUseCase: GetVideosUseCase = GetVideosUseCase(remoteRepository)
    private val getAllItemsUsecase: GetAllItemsUsecase = GetAllItemsUsecase(localRepository)
    private val clearAllUsecase: ClearAllUsecase = ClearAllUsecase(localRepository)
    private val addItemsUsecase: AddItemsUsecase = AddItemsUsecase(localRepository)

    val liveData: LiveData<List<VideoListItem>>
        get() = getAllItemsUsecase.getAllItems()

    init {
        viewModelScope.launch {

            cacheData.getTiming.collect{
                withContext(Dispatchers.IO){
                    getVideosUseCase.getVideos().collect{ requestList ->
                        clearAllUsecase.clearAll()
                        addItemsUsecase.addItems(requestList)
                        Log.d("timing", "RequestList: $requestList")
                    }
                }

                cacheData.saveTiming(System.currentTimeMillis() / 60000)
                Log.d("timing", "VIEW MODEL SCOPE")
            }
        }
    }


    fun getTheme(): Flow<Boolean?>{
        return cacheData.getTheme
    }

    fun switchTheme(onDark: Boolean?){

        viewModelScope.launch {
            cacheData.saveTheme(onDark)
        }

    }


}