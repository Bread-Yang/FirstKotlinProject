package com.robin.firstkotlinproject.data

import com.robin.firstkotlinproject.data.lastfm.LastFmService
import com.robin.firstkotlinproject.data.mapper.AlbumMapper
import com.robin.firstkotlinproject.domain.entity.Album
import com.robin.firstkotlinproject.repository.dataset.AlbumDataSet

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