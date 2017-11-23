package com.robin.firstkotlinproject.data.mapper

import com.robin.firstkotlinproject.data.lastfm.model.LastFmArtist
import com.robin.firstkotlinproject.domain.entity.Artist

/**
 * Created by Robin Yang on 11/23/17.
 */
class ArtistMapper(val imageMapper: ImageMapper = ImageMapper()) {

    fun transform(artists: List<LastFmArtist>) : List<Artist> {
        return artists.filter { artistHasQualityInfo(it) }.mapNotNull { transform(it) }
    }

    fun transform(artist: LastFmArtist) = artist.mbid?.let {
        Artist(artist.mbid, artist.name, imageMapper.getMainImageUrl(artist.images), artist.bio?.content)
    }

    private fun artistHasQualityInfo(it: LastFmArtist): Boolean {
        return !isArtistMbidEmpty(it) && it.images != null && it.images.isNotEmpty()
    }

    private fun isArtistMbidEmpty(artist: LastFmArtist): Boolean {
        return artist.mbid?.isEmpty() ?: true
    }
}