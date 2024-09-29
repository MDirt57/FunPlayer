package com.example.funplayer.data.local

import com.example.funplayer.domain.VideoListItem

object RoomDataMapper{

    fun entityToItem(itemEntity: VideoItemEntity): VideoListItem{
        return VideoListItem(
            id = itemEntity.id,
            title = itemEntity.title,
            source = itemEntity.source,
            preview = itemEntity.preview,
            isFavourite = itemEntity.isFavourite
        )
    }

    fun itemToEntity(item: VideoListItem): VideoItemEntity{
        return VideoItemEntity(
            title = item.title,
            source = item.source,
            preview = item.preview,
            isFavourite = item.isFavourite
        )
    }

}