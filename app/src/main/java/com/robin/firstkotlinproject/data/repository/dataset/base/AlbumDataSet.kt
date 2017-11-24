package com.robin.firstkotlinproject.data.repository.dataset.base

import com.robin.firstkotlinproject.domain.model.Album

/**
 * Created by Robin Yang on 11/23/17.
 */
interface AlbumDataSet {

    fun requestTopAlbums(artistId: String?, artistName: String?): List<Album>
    fun requestAlbum(mbid: String): Album?
}