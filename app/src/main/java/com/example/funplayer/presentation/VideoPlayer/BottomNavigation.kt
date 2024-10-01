package com.example.funplayer.presentation.VideoPlayer

import android.app.Activity
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.media3.exoplayer.ExoPlayer
import com.example.funplayer.R
import com.example.funplayer.presentation.VideoPlayer.components.StyledIconButton
import kotlinx.coroutines.delay


@Composable
fun BottomNavigation(
    player: ExoPlayer?,
    contact: () -> Unit
){

    val activity = LocalContext.current as Activity
    val orientation = LocalConfiguration.current.orientation == Configuration.ORIENTATION_PORTRAIT

    val duration by remember { mutableFloatStateOf(player?.duration?.toFloat() ?: 0f) }
    var sliderPositionToChange by remember { mutableFloatStateOf(0f) }
    var sliderPositionCurrent by remember { mutableFloatStateOf(player?.currentPosition?.toFloat() ?: 0f) }

    val durationText by remember { mutableStateOf(floatToTime(duration)) }
    val currentPositionText = floatToTime(sliderPositionCurrent)

    LaunchedEffect(sliderPositionToChange) {
        if (sliderPositionToChange != 0f) player?.seekTo(sliderPositionToChange.toLong())
        contact()
    }

    LaunchedEffect(sliderPositionToChange) {
        while (true){
            sliderPositionCurrent = player?.currentPosition?.toFloat() ?: 0f
            delay(500L)
        }
    }

    Column(
        modifier = Modifier.padding(start = 10.dp, end = 10.dp)
    ) {
        Slider(
            value = sliderPositionCurrent,
            onValueChange = { sliderPositionToChange = it },
            valueRange = 0f..duration
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "$currentPositionText / $durationText",
                modifier = Modifier.weight(1f),
                color = Color.White
            )
            StyledIconButton(
                onClick = { activity.requestedOrientation =  if (orientation) ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE else ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED}
            ) {
                Icon(painter = painterResource(R.drawable.baseline_fullscreen_24), contentDescription = "fullscreen")
            }
        }
    }

}


fun floatToTime(value: Float): String{
    val seconds = (value / 1000).toInt()
    val minutes = seconds / 60
    val hours = minutes / 60
    return "${if (hours != 0) "$hours:" else ""}${minutes % 60}:${seconds % 60}"
}

//
//@Preview
//@Composable
//fun PreviewBottomNavigation(){
//    BottomNavigation()
//}