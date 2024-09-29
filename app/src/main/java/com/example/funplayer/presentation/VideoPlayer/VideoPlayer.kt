package com.example.funplayer.presentation.VideoPlayer

import android.util.Log
import androidx.compose.runtime.*
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.saveable.rememberSaveableStateHolder
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.example.funplayer.domain.VideoListItem
import kotlinx.coroutines.coroutineScope


@Composable
fun VideoPlayer(
    viewModel: VideoPlayerViewModel = hiltViewModel()
){

    val context = LocalContext.current

    val exoPlayer = ExoPlayer.Builder(context).build()


    viewModel.liveData.observe(LocalLifecycleOwner.current){

        exoPlayer.setMediaItem(MediaItem.fromUri(it.source))
        exoPlayer.prepare()

    }

    DisposableEffect(Unit) {
        onDispose {
            exoPlayer.release()
        }
    }

    AndroidView(
        factory = {
            PlayerView(it).apply {
                player = exoPlayer
            }
        }
    )


}