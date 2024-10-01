package com.example.funplayer.presentation.VideoPlayer.components

import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color


@Composable
fun StyledIconButton(
    onClick: () -> Unit,
    scale: Float = 1f,
    content: @Composable () -> Unit
){

    IconButton(
        onClick = onClick,
        modifier = Modifier.scale(scale),
        colors = IconButtonDefaults.iconButtonColors(contentColor = Color.White)
    ) {
        content()
    }

}