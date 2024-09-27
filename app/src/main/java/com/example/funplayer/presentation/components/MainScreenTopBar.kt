package com.example.funplayer.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenTopBar(){

    TopAppBar(
        title = { Text(text = "FunPlayer") },
        actions = {
            IconButton(
                onClick = {}
            )  {
                Icon(imageVector = Icons.Default.Edit, contentDescription = "style")   //change theme
            }
        }
    )

}