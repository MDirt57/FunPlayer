package com.example.funplayer.presentation.VideoPlayer

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
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

    if ((player?.duration ?: 0) < 0){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator(
                modifier = Modifier.scale(2f),
                color = Color.White
            )
        }
    }


    AnimatedVisibility(
        modifier = modifier.fillMaxSize(),
        visible = isVisible,
        enter = fadeIn(),
        exit = fadeOut()
    ) {

        Column(
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = title ?: "",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 16.dp, top = 64.dp)
            )

            Box(
                modifier = Modifier.padding(bottom = 16.dp)
            ){
                Column {
                    CenterNavigation(player)
                    Spacer(modifier = Modifier.height(8.dp))
                    BottomNavigation(player, contact)
                }
            }

        }


    }

}
