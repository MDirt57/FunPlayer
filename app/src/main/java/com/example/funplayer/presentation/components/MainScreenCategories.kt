package com.example.funplayer.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape


@Composable
fun MainScreenCategories(
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        Button(
            onClick = {},
            shape = RectangleShape,
            modifier = Modifier.weight(1f)
        ){
            Text(text = "New")
        }

        Button(
            onClick = {},
            shape = RectangleShape,
            modifier = Modifier.weight(1f)
        ){
            Text(text = "Favourites")
        }
    }

}