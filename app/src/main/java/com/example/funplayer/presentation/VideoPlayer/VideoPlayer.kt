package com.example.funplayer.presentation.VideoPlayer

import android.app.Activity
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.annotation.OptIn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.media3.common.util.UnstableApi
import androidx.media3.ui.PlayerView
import kotlinx.coroutines.delay


@OptIn(UnstableApi::class)
@Composable
fun VideoPlayer(
    viewModel: VideoPlayerViewModel = hiltViewModel()
){

    val activity = LocalContext.current as Activity
    val configuration = LocalConfiguration.current

    val player by viewModel.playerState.collectAsState()

    viewModel.liveData.observe(LocalLifecycleOwner.current){
        viewModel.initializePlayer(activity, it)
    }

    DisposableEffect(Unit) {
        onDispose {
            viewModel.savePlayerState()
            viewModel.releasePlayer()
        }
    }

    var isControlVisible by remember { mutableStateOf(false) } //there is error if spamming
    var isControlContacted by remember { mutableStateOf(false) }

    var isCanControl by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(3000)
        isCanControl = true
    }

    LaunchedEffect(isControlContacted) {
        delay(5000)
        isControlVisible = false
    }

    Surface(
//        modifier = if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) Modifier.fillMaxSize() else Modifier.height(200.dp),
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {
        AndroidView(
            modifier = Modifier.fillMaxWidth(),
            factory = { context ->
                PlayerView(context).apply {
                    this.player = player
                    this.useController = false
                    this.setOnClickListener { if (isCanControl) isControlVisible = !isControlVisible }
                }
            },
            update = { playerView ->
                playerView.player = player
            }
        )

        PlayerNavigation(
            player = player,
            isVisible = isControlVisible,
            contact = { isControlContacted = !isControlContacted }
        )

    }


    if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
        BackHandler { activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED }
    }

}