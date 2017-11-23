package com.robin.firstkotlinproject.repository

import com.robin.firstkotlinproject.domain.entity.Artist
import com.robin.firstkotlinproject.domain.repository.ArtistRepository
import com.robin.firstkotlinproject.repository.dataset.ArtistDataSet

/**
 * Created by Robin Yang on 11/22/17.
 */
class ArtistRepositoryImp(val artistDataSets: List<ArtistDataSet>) : ArtistRepository {

    override fun getRecommendedArtists(): List<Artist> {
        for (dataSet in artistDataSets) {
            val result = dataSet.requestRecommendedArtists()
            if (result.isNotEmpty()) {
                return result
            }
        }

        return emptyList()
    }

    override fun getArtist(id: String): Artist {
        for (dataSet in artistDataSets) {
            val result = dataSet.requestArtist(id)
            if (result != null) {
                return result
            }
        }

        return Artist("empty", "empty", "empty")
    }

}