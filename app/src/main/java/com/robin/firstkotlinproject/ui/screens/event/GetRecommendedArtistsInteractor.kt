package com.robin.firstkotlinproject.ui.screens.event

import com.robin.firstkotlinproject.domain.interactor.base.Event
import com.robin.firstkotlinproject.domain.interactor.base.Interactor
import com.robin.firstkotlinproject.domain.interactor.event.ArtistsEvent
import com.robin.firstkotlinproject.domain.repository.ArtistRepository

/**
 * Created by Robin Yang on 11/17/17.
 */
class GetRecommendedArtistsInteractor(val artistRepository: ArtistRepository) : Interactor {

    override fun invoke(): Event {
        val artists = artistRepository.getRecommendedArtists()
        return ArtistsEvent(artists)
    }
}