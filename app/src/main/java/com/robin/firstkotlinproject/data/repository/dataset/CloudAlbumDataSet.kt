package com.robin.firstkotlinproject.data.repository.dataset

import com.robin.firstkotlinproject.data.lastfm.LastFmService
import com.robin.firstkotlinproject.data.repository.dataset.base.AlbumDataSet
import com.robin.firstkotlinproject.domain.model.Album
import com.robin.firstkotlinproject.domain.model.mapper.AlbumMapper

/**
 * Created by Robin Yang on 11/23/17.
 */
class CloudAlbumDataSet(val lastFmService: LastFmService) : AlbumDataSet {

    override fun requestAlbum(mbid: String): Album?
            = lastFmService.requestAlbum(mbid).unwrapCall { AlbumMapper().transform(album) }

    override fun requestTopAlbums(artistId: String?, artistName: String?): List<Album> {
        val mbid = artistId ?: ""
        val name = artistName ?: ""

        if (!mbid.isEmpty() || !name.isEmpty()) {
            return lastFmService.requestAlbums(mbid, name).unwrapCall {
                AlbumMapper().transform(topAlbums.albums)
            } ?: emptyList()
        }
        return emptyList()
    }
}