package com.example.funplayer.presentation.VideoPlayer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.funplayer.domain.VideoListItem
import com.example.funplayer.domain.local.LocalVideoRepository
import com.example.funplayer.domain.local.usecases.GetItemUsecase
import com.example.funplayer.presentation.CurrentVideo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VideoPlayerViewModel @Inject constructor(
    private val localRepository: LocalVideoRepository
): ViewModel(){

    private val getItemUsecase = GetItemUsecase(localRepository)

    val liveData: LiveData<VideoListItem>
        get() = getItemUsecase.getItem(CurrentVideo.videoId)

}