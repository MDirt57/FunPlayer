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
    modifier: Modifier = Modifier
){

    val dummyList = List<VideoListItem>(10) {
        index -> VideoListItem(
            title = "Video$index",
            duration = "Duration: 10:$index"
        )
    }

    LazyColumn(
        modifier = modifier.fillMaxWidth()
    ) {
        items(dummyList){
            item -> VideoListElement(item)
        }
    }

}



@Preview
@Composable
fun PreviewVideoList(){
    VideoList()
}
