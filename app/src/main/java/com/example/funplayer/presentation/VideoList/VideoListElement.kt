package com.example.funplayer.presentation.VideoList

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.funplayer.R
import com.example.funplayer.domain.VideoListItem


@Composable
fun VideoListElement(
    videoListItem: VideoListItem,
    onClick: () -> Unit
){

    val title = videoListItem.title
    val preview = videoListItem.preview

    val textLimit = 27

    Row(
        modifier = Modifier.fillMaxWidth().height(80.dp).clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {

        AsyncImage(
            model = preview,
            contentDescription = "preview",
            modifier = Modifier.size(width = 80.dp, height = 64.dp).weight(0.3f)
        )

        Text(
            text = if (title.length < textLimit+1) title else title.slice(0..textLimit).trim()+"...",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            maxLines = 2,
            modifier = Modifier.weight(0.5f)
        )

        IconButton(
            onClick = {},
            modifier = Modifier.weight(0.2f)
        ) {
            Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = "to favourites")
        }

    }

}




//@Preview
//@Composable
//fun PreviewVideoListElement(){
//    VideoListElement(
//        VideoListItem(
//            title = "For Bigger Blazes"
//        )
//    )
//}