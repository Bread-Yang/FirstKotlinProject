package com.robin.firstkotlinproject.repository

import com.robin.firstkotlinproject.domain.entity.Album
import com.robin.firstkotlinproject.domain.repository.AlbumRepository
import com.robin.firstkotlinproject.repository.dataset.AlbumDataSet

/**
 * Created by Robin Yang on 11/23/17.
 */
class AlbumRepositoryImpl(val albumDataSets: List<AlbumDataSet>) : AlbumRepository {

    override fun getAlbum(id: String): Album? = albumDataSets
            .map { it.requestAlbum(id) }
            .firstOrNull { it != null }

    override fun getTopAlbums(artistId: String?, artistName: String?) = albumDataSets
            .map { it.requestTopAlbums(artistId, artistName) }
            .firstOrNull { it.isNotEmpty() } ?: emptyList()
}