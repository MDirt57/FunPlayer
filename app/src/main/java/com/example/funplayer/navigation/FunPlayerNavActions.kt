package com.example.funplayer.navigation

import androidx.navigation.NavController


class FunPlayerNavActions(
    private val navController: NavController
){

    fun navigateToPlayer(){
        navController.navigate("player")
    }

}