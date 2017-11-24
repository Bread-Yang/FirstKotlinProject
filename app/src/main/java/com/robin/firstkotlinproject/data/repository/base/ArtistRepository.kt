package com.robin.firstkotlinproject.data.repository.base

import com.robin.firstkotlinproject.domain.model.Artist

/**
 * Interface that represents a Repository for getting [Artist] related data.
 */
interface ArtistRepository {
    fun getRecommendedArtists(): List<Artist>
    fun getArtist(id: String): Artist
}