package com.example.funplayer.presentation.VideoPlayer

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.media3.common.MediaItem
import androidx.media3.common.MediaMetadata
import androidx.media3.exoplayer.ExoPlayer
import com.example.funplayer.domain.VideoListItem
import com.example.funplayer.domain.local.LocalVideoRepository
import com.example.funplayer.domain.local.usecases.GetAllItemsUsecase
import com.example.funplayer.presentation.CurrentVideo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VideoPlayerViewModel @Inject constructor(
    private val localRepository: LocalVideoRepository
): ViewModel(){

    private val getAllItemsUsecase = GetAllItemsUsecase(localRepository)

    private val _playerState = MutableStateFlow<ExoPlayer?>(null)
    val playerState: StateFlow<ExoPlayer?> = _playerState

    val liveData: LiveData<List<VideoListItem>>
        get() = getAllItemsUsecase.getAllItems()

    private var currentPosition: Long = 0L

    fun initializePlayer(context: Context, videoItems: List<VideoListItem>) {
        if (_playerState.value == null) {
            viewModelScope.launch {
                val exoPlayer = ExoPlayer.Builder(context).build().also {

                    val playlist = mutableListOf<MediaItem>()
                    for (index in videoItems.indices) {

                        val mediaItem = MediaItem.Builder()
                            .setUri(videoItems[index].source)
                            .setMediaId(index.toString())
                            .setTag(videoItems[index].title)
                            .build()

                        playlist.add(mediaItem)
                    }

                    it.setMediaItems(playlist)
                    it.seekTo(CurrentVideo.videoOrder, currentPosition)

                    it.prepare()
                    it.playWhenReady = true
                }
                _playerState.value = exoPlayer
            }
        }
    }

    fun getCurrentVideoTitle(videoItems: List<VideoListItem>): String{
        var title = ""
        playerState.value?.let {
            title = videoItems[it.currentMediaItemIndex].title
        }
        return title
    }

    fun savePlayerState() {
        _playerState.value?.let {
            currentPosition = it.currentPosition
        }
    }

    fun releasePlayer() {
        _playerState.value?.release()
        _playerState.value = null
    }

}