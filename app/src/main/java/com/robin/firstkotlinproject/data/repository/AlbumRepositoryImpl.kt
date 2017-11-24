package com.robin.firstkotlinproject.data.repository

import com.robin.firstkotlinproject.data.repository.dataset.base.AlbumDataSet
import com.robin.firstkotlinproject.domain.model.Album
import com.robin.firstkotlinproject.data.repository.base.AlbumRepository

/**
 * [AlbumRepository] for retrieving album data.
 */
class AlbumRepositoryImpl(val albumDataSets: List<AlbumDataSet>) : AlbumRepository {

    override fun getAlbum(id: String): Album? = albumDataSets
            .map { it.requestAlbum(id) }
            .firstOrNull { it != null }

    override fun getTopAlbums(artistId: String?, artistName: String?): List<Album> = albumDataSets
            .map { it.requestTopAlbums(artistId, artistName) }
            .firstOrNull { it.isNotEmpty() } ?: emptyList()
}