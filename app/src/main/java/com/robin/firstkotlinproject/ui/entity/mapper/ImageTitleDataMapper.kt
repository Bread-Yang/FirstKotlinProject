package com.robin.firstkotlinproject.ui.entity.mapper

import com.robin.firstkotlinproject.domain.entity.Album
import com.robin.firstkotlinproject.domain.entity.Artist
import com.robin.firstkotlinproject.ui.entity.ImageTitle

/**
 * Created by Robin Yang on 11/17/17.
 */
class ImageTitleDataMapper() {

    fun transformArtists(artists: List<Artist>): List<ImageTitle> {
        return artists.map { ImageTitle(it.id, it.name, it.url) }
    }

    fun transformAlbums(albums: List<Album>): List<ImageTitle> {
        return albums.map { ImageTitle(it.id, it.name, it.url) }
    }
}