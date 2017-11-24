package com.robin.firstkotlinproject.ui.model.mapper

import com.robin.firstkotlinproject.domain.model.Album
import com.robin.firstkotlinproject.ui.model.AlbumDetail

/**
 * Mapper class used to transform [Album] (in the domain layer) to [AlbumDetail] in the
 * presentation layer.
 */
class AlbumDetailDataMapper {

    fun transform(album: Album?) = album?.let {
        AlbumDetail(it.id, it.name, it.url, it.tracks)
    }
}