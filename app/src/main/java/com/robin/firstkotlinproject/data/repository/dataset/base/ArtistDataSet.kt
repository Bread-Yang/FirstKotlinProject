package com.robin.firstkotlinproject.data.repository.dataset.base

import com.robin.firstkotlinproject.domain.model.Artist

/**
 * Created by Robin Yang on 11/22/17.
 */
interface ArtistDataSet {

    fun requestRecommendedArtists(): List<Artist>
    fun requestArtist(id: String): Artist?
}