package com.example.funplayer.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.funplayer.data.CacheTiming
import com.example.funplayer.domain.VideoListItem
import com.example.funplayer.domain.local.LocalVideoRepository
import com.example.funplayer.domain.local.usecases.AddItemsUsecase
import com.example.funplayer.domain.local.usecases.ClearAllUsecase
import com.example.funplayer.domain.local.usecases.GetAllItemsUsecase
import com.example.funplayer.domain.remote.RemoteVideoRepository
import com.example.funplayer.domain.remote.usecases.GetVideosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val remoteRepository: RemoteVideoRepository,
    private val localRepository: LocalVideoRepository,
    private val cacheTimer: CacheTiming
) : ViewModel() {

    private val getVideosUseCase: GetVideosUseCase = GetVideosUseCase(remoteRepository)
    private val getAllItemsUsecase: GetAllItemsUsecase = GetAllItemsUsecase(localRepository)
    private val clearAllUsecase: ClearAllUsecase = ClearAllUsecase(localRepository)
    private val addItemsUsecase: AddItemsUsecase = AddItemsUsecase(localRepository)

    val liveData: LiveData<List<VideoListItem>>
        get() = getAllItemsUsecase.getAllItems()

    init {
        viewModelScope.launch {

            cacheTimer.getData.collect{
                withContext(Dispatchers.IO){
                    getVideosUseCase.getVideos().collect{ requestList ->
                        clearAllUsecase.clearAll()
                        addItemsUsecase.addItems(requestList)
                        Log.d("timing", "RequestList: $requestList")
                    }
                }

                cacheTimer.saveData(System.currentTimeMillis() / 60000)
                Log.d("timing", "VIEW MODEL SCOPE")
            }
        }
    }



}