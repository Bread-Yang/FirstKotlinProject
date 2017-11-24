package com.robin.firstkotlinproject.ui.model.mapper

import com.robin.firstkotlinproject.domain.model.Album
import com.robin.firstkotlinproject.domain.model.Artist
import com.robin.firstkotlinproject.ui.model.ImageTitle

/**
 * Mapper class used to transform [Artist] or [Album] (in the domain layer) to [ImageTitle] in the
 * presentation layer.
 */
class ImageTitleDataMapper() {

    fun transformArtists(artists: List<Artist>): List<ImageTitle> {
        return artists.map { ImageTitle(it.id, it.name, it.url) }
    }

    fun transformAlbums(albums: List<Album>): List<ImageTitle> {
        return albums.map { ImageTitle(it.id, it.name, it.url) }
    }
}