package com.example.funplayer.presentation.VideoPlayer

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.media3.exoplayer.ExoPlayer

@Composable
fun PlayerNavigation(
    player: ExoPlayer?,
    isVisible: Boolean,
    contact: () -> Unit,
    modifier: Modifier = Modifier
) {

    val title = player?.currentMediaItem?.localConfiguration?.tag as String?

    AnimatedVisibility(
        modifier = modifier.fillMaxSize(),
        visible = isVisible,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = title ?: "",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 16.dp)
            )

            Box{
                Column {
                    CenterNavigation(player)
                    BottomNavigation(player, contact)
                }
            }

        }
    }

}
