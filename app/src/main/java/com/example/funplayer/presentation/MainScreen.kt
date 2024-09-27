package com.example.funplayer.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.funplayer.presentation.VideoList.VideoList
import com.example.funplayer.presentation.components.MainScreenCategories
import com.example.funplayer.presentation.components.MainScreenTopBar


@Composable
fun MainScreen(){

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