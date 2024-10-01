package com.example.funplayer.presentation.VideoPlayer

import android.graphics.drawable.Icon
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.media3.exoplayer.ExoPlayer
import com.example.funplayer.R
import com.example.funplayer.presentation.VideoPlayer.components.StyledIconButton


@Composable
fun CenterNavigation(
    player: ExoPlayer?,
    modifier: Modifier = Modifier
){

    var isPlaying by remember { mutableStateOf(player?.isPlaying == true) }
    val buttonScale = 1.5f

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {

        StyledIconButton(
            onClick = { player?.seekToPrevious(); player?.playWhenReady = true },
            scale = buttonScale
        ) {
            Icon(painter = painterResource(R.drawable.baseline_skip_previous_24), contentDescription = "previous video")
        }

        StyledIconButton(
            onClick = { if (isPlaying) player?.pause() else player?.play(); isPlaying = !isPlaying },
            scale = buttonScale
        ) {
            Icon(painter = painterResource( if (isPlaying) R.drawable.baseline_pause_24 else R.drawable.baseline_play_arrow_24), contentDescription = "play_pause")
        }

        StyledIconButton(
            onClick = { player?.seekToNext(); player?.playWhenReady = true },
            scale = buttonScale
        ) {
            Icon(painter = painterResource(R.drawable.baseline_skip_next_24), contentDescription = "next video")
        }

    }

}



//@Preview
//@Composable
//fun PreviewCenterNavigation(){
//    CenterNavigation({}, {}, {}, true)
//}