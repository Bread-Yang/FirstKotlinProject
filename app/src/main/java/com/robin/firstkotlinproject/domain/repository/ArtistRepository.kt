package com.robin.firstkotlinproject.domain.repository

import com.robin.firstkotlinproject.domain.entity.Artist

/**
 * Created by Robin Yang on 11/17/17.
 */
interface ArtistRepository {
    fun getRecommendedArtists(): List<Artist>
    fun getArtist(id: String): Artist
}