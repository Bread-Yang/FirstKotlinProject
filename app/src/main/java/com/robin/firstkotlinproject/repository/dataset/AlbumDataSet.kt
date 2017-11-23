package com.robin.firstkotlinproject.repository.dataset

import com.robin.firstkotlinproject.domain.entity.Album

/**
 * Created by Robin Yang on 11/23/17.
 */
interface AlbumDataSet {

    fun requestTopAlbums(artistId: String?, artistName: String?): List<Album>
    fun requestAlbum(mbid: String): Album?
}