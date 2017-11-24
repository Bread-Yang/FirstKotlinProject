package com.robin.firstkotlinproject.data.repository

import com.robin.firstkotlinproject.data.repository.dataset.base.ArtistDataSet
import com.robin.firstkotlinproject.domain.model.Artist
import com.robin.firstkotlinproject.data.repository.base.ArtistRepository

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