package com.example.funplayer.presentation.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.funplayer.R
import com.example.funplayer.presentation.VideoList.VideoListViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenTopBar(
    viewModel: VideoListViewModel = hiltViewModel()
){

    val isDarkTheme by viewModel.getTheme().collectAsState(initial = false)

    TopAppBar(
        title = { Text(text = "FunPlayer") },
        actions = {
            IconButton(
                onClick = { viewModel.switchTheme(isDarkTheme?.not()) }
            )  {
                Icon(
                    painter = painterResource(if (isDarkTheme == true) R.drawable.baseline_light_mode_24 else R.drawable.baseline_mode_night_24),
                    contentDescription = "style"
                )   //change theme
            }
        }
    )

}