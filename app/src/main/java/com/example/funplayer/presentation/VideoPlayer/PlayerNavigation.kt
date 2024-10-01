package com.example.funplayer.presentation.VideoPlayer

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.media3.exoplayer.ExoPlayer

@Composable
fun PlayerNavigation(
    player: ExoPlayer?,
    isVisible: Boolean,
    contact: () -> Unit,
    modifier: Modifier = Modifier
) {

    AnimatedVisibility(
        modifier = modifier.fillMaxSize(),
        visible = isVisible,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceAround
        ) {
            CenterNavigation(player)
            BottomNavigation(player, contact)
        }
    }

}
