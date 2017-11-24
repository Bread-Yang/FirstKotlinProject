package com.robin.firstkotlinproject.domain.model.mapper

import com.robin.firstkotlinproject.data.lastfm.entity.LastFmArtist
import com.robin.firstkotlinproject.domain.model.Artist

/**
 * Mapper class used to transform [LastFmArtist] (in the data layer) to [Artist] in the
 * domain layer.
 */
class ArtistMapper(val imageMapper: ImageMapper = ImageMapper()) {

    fun transform(artists: List<LastFmArtist>): List<Artist> {
        return artists.filter { artistHasQualityInfo(it) }.mapNotNull { transform(it) }
    }

    fun transform(artist: LastFmArtist): Artist? = artist.mbid?.let {
        Artist(artist.mbid, artist.name, imageMapper.getMainImageUrl(artist.images), artist.bio?.content)
    }

    private fun artistHasQualityInfo(it: LastFmArtist): Boolean {
        return !isArtistMbidEmpty(it) && it.images != null && it.images.isNotEmpty()
    }

    private fun isArtistMbidEmpty(artist: LastFmArtist): Boolean {
        return artist.mbid?.isEmpty() ?: true
    }
}