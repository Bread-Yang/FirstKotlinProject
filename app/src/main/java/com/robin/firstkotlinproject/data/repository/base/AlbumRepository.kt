package com.robin.firstkotlinproject.data.repository.base

import com.robin.firstkotlinproject.domain.model.Album

/**
 * Interface that represents a Repository for getting [Album] related data.
 */
interface AlbumRepository {
    fun getTopAlbums(artistId: String?, artistName: String?): List<Album>
    fun getAlbum(id: String): Album?
}