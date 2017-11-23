package com.robin.firstkotlinproject.ui.entity.mapper

import com.robin.firstkotlinproject.domain.entity.Album
import com.robin.firstkotlinproject.ui.entity.AlbumDetail

/**
 * Created by Robin Yang on 11/22/17.
 */
class AlbumDetailDataMapper {

    fun transform(album: Album?) = album?.let {
        AlbumDetail(it.id, it.name, it.url, it.tracks)
    }
}