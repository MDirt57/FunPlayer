package com.example.funplayer.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.funplayer.presentation.VideoList.VideoListScreen
import com.example.funplayer.presentation.VideoPlayer.VideoPlayer


fun NavGraphBuilder.addFunPlayerGraph(
    navActions: FunPlayerNavActions
){

    navigation(startDestination = "video_list", route = "main"){

        composable(route = "player"){
            VideoPlayer()
        }

        composable(
            route = "video_list"
        ) {
            VideoListScreen(navActions = navActions)
        }

    }

}