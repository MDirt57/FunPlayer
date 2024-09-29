package com.example.funplayer.presentation.VideoList

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.funplayer.domain.VideoListItem
import com.example.funplayer.navigation.FunPlayerNavActions
import com.example.funplayer.presentation.CurrentVideo
import com.example.funplayer.presentation.components.MainScreenCategories
import com.example.funplayer.presentation.components.MainScreenTopBar


@Composable
fun VideoListScreen(
    navActions: FunPlayerNavActions,
    viewModel: VideoListViewModel = hiltViewModel()
){

    var videoList by remember { mutableStateOf(emptyList<VideoListItem>()) }

    viewModel.liveData.observe(LocalLifecycleOwner.current){
        videoList = it
        Log.d("retrofit", videoList.toString())
    }

    Scaffold(
        topBar = { MainScreenTopBar() }
    ) { contentPadding ->

        Column(
            modifier = Modifier.padding(contentPadding)
        ) {
            MainScreenCategories()
            VideoList(videoList, {item -> navActions.navigateToPlayer(); CurrentVideo.videoId = item.id})
        }

    }

}