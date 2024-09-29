package com.example.funplayer.presentation.VideoList

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.funplayer.domain.VideoListItem


@Composable
fun VideoList(
    videoList: List<VideoListItem>,
    onClick: (VideoListItem) -> Unit,
    modifier: Modifier = Modifier
){

    LazyColumn(
        modifier = modifier.fillMaxWidth()
    ) {
        items(videoList){
            item -> VideoListElement(item, { onClick(item) })
        }
    }

}


//
//@Preview
//@Composable
//fun PreviewVideoList(){
//    VideoList()
//}
