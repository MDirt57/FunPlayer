package com.example.funplayer.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.funplayer.domain.VideoListItem
import com.example.funplayer.domain.remote.VideoRepository
import com.example.funplayer.domain.remote.usecases.GetVideosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val repository: VideoRepository
) : ViewModel() {

    val getVideosUseCase: GetVideosUseCase = GetVideosUseCase(repository)

    val liveData: LiveData<List<VideoListItem>>
        get() = getVideosUseCase.getVideos()

//    private val _liveData = MutableLiveData<List<VideoListItem>>()
//    val liveData: LiveData<List<VideoListItem>>
//        get() = _liveData
//
//    fun getVideos(){
//        viewModelScope.launch {
//            _liveData.value = getVideosUseCase.getVideos().value
//        }
//    }


}