package com.example.funplayer.presentation.VideoList

import androidx.compose.foundation.Image
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
import com.example.funplayer.R
import com.example.funplayer.domain.VideoListItem


@Composable
fun VideoListElement(
    videoListItem: VideoListItem
){

    val title = videoListItem.title
    val duration = videoListItem.duration

    Row(
        modifier = Modifier.fillMaxWidth().height(80.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {

        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "video preview",
            modifier = Modifier.size(width = 80.dp, height = 48.dp)
        )

        Column(
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = if (title.length < 10) title else title.slice(0..9)+"...",
                fontWeight = FontWeight.Bold,
                fontSize = 36.sp
            )
            Text(text = duration)
        }

        IconButton(
            onClick = {}
        ) {
            Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = "to favourites")
        }

    }

}




@Preview
@Composable
fun PreviewVideoListElement(){
    VideoListElement(
        VideoListItem(
            title = "Title",
            duration = "Duration: 10:00"
        )
    )
}