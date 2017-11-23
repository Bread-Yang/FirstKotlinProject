package com.robin.firstkotlinproject.repository.dataset

import com.robin.firstkotlinproject.domain.entity.Artist

/**
 * Created by Robin Yang on 11/22/17.
 */
interface ArtistDataSet {

    fun requestRecommendedArtists(): List<Artist>
    fun requestArtist(id: String): Artist?
}