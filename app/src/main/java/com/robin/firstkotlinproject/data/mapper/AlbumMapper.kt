package com.robin.firstkotlinproject.data.mapper

import com.robin.firstkotlinproject.data.lastfm.model.LastFmAlbum
import com.robin.firstkotlinproject.data.lastfm.model.LastFmAlbumDetail
import com.robin.firstkotlinproject.domain.entity.Album
import com.robin.firstkotlinproject.domain.entity.Artist

/**
 * Created by Robin Yang on 11/23/17.
 */
class AlbumMapper(val artistmapper: ArtistMapper = ArtistMapper(),
                  val imageMapper: ImageMapper = ImageMapper(),
                  val trackMapper: TrackMapper = TrackMapper()) {

    fun transform(albums: List<LastFmAlbum>): List<Album> {
        return albums.filter { albumhasQualityInfo(it) }.mapNotNull { transform(it) }
    }

    private fun albumhasQualityInfo(album: LastFmAlbum): Boolean {
        return !isAlbumMbidEmpty(album) && album.images.isNotEmpty()
    }

    private fun isAlbumMbidEmpty(album: LastFmAlbum): Boolean {
        return album.mbid?.isEmpty() ?: true
    }

    fun transform(album: LastFmAlbumDetail) = album.mbid?.let {
        Album(album.mbid,
                album.name,
                Artist("", album.artist),
                imageMapper.getMainImageUrl(album.images),
                trackMapper.transform(album.tracks.tracks))
    }

    fun transform(album: LastFmAlbum) = album.mbid?.let {
        Album(album.mbid,
                album.name,
                artistmapper.transform(album.artist),
                imageMapper.getMainImageUrl(album.images),
                trackMapper.transform(album.tracks?.tracks))
    }
}
