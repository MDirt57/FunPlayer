package com.example.funplayer.presentation

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.funplayer.domain.VideoListItem
import com.example.funplayer.presentation.VideoList.VideoList
import com.example.funplayer.presentation.components.MainScreenCategories
import com.example.funplayer.presentation.components.MainScreenTopBar


@Composable
fun MainScreen(
    viewModel: MainScreenViewModel = hiltViewModel()
){

    var videoList by remember { mutableStateOf(emptyList<VideoListItem>()) }

    viewModel.liveData.observe(LocalLifecycleOwner.current){
        videoList = it
    }

    Scaffold(
        topBar = { MainScreenTopBar() }
    ) { contentPadding ->

        Column(
            modifier = Modifier.padding(contentPadding)
        ) {
            MainScreenCategories()
            VideoList()
        }

    }


}