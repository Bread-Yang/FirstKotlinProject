package com.robin.firstkotlinproject.domain.model.mapper

import com.robin.firstkotlinproject.data.lastfm.entity.LastFmAlbum
import com.robin.firstkotlinproject.data.lastfm.entity.LastFmAlbumDetail
import com.robin.firstkotlinproject.domain.model.Album
import com.robin.firstkotlinproject.domain.model.Artist

/**
 * Mapper class used to transform [LastFmAlbum] (in the data layer) to [Album] in the
 * domain layer.
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
