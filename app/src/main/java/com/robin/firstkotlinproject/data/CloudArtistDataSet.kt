package com.robin.firstkotlinproject.data

import com.robin.firstkotlinproject.data.lastfm.LastFmService
import com.robin.firstkotlinproject.data.mapper.ArtistMapper
import com.robin.firstkotlinproject.domain.entity.Artist
import com.robin.firstkotlinproject.repository.dataset.ArtistDataSet

/**
 * Created by Robin Yang on 11/23/17.
 */
class CloudArtistDataSet(val language: String, val lastFmService: LastFmService) : ArtistDataSet {

    val coldplayMbid = "cc197bad-dc9c-440d-a5b5-d52ba2e14234"

    override fun requestRecommendedArtists(): List<Artist> =
            lastFmService.requestSimilar(coldplayMbid).unwrapCall {
                // Search for coldplay similar artists.
                ArtistMapper().transform(similarArtists.artists)
            } ?: emptyList()


    override fun requestArtist(id: String): Artist? =
            lastFmService.requestArtistInfo(id, language).unwrapCall {
                ArtistMapper().transform(artist)
            }

}