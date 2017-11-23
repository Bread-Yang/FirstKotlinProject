package com.robin.firstkotlinproject.domain.repository

import com.robin.firstkotlinproject.domain.entity.Album

/**
 * Created by Robin Yang on 11/20/17.
 */
interface  AlbumRepository {
    fun getTopAlbums(artistId: String?, artistName: String?): List<Album>
    fun getAlbum(id: String): Album?
}