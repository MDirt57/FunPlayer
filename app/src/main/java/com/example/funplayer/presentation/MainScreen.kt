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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.funplayer.domain.VideoListItem
import com.example.funplayer.navigation.FunPlayerNavActions
import com.example.funplayer.navigation.addFunPlayerGraph
import com.example.funplayer.presentation.VideoList.VideoList
import com.example.funplayer.presentation.VideoPlayer.VideoPlayer
import com.example.funplayer.presentation.components.MainScreenCategories
import com.example.funplayer.presentation.components.MainScreenTopBar


@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController(),
    navActions: FunPlayerNavActions = remember(navController){
        FunPlayerNavActions(navController)
    },

){

    NavHost(
        navController = navController,
        startDestination = "main"
    ){
        addFunPlayerGraph(navActions = navActions)
    }

}