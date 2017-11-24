package com.robin.firstkotlinproject.domain.interactor

import com.robin.firstkotlinproject.domain.interactor.base.Event
import com.robin.firstkotlinproject.domain.interactor.base.Interactor
import com.robin.firstkotlinproject.domain.interactor.event.ArtistDetailEvent
import com.robin.firstkotlinproject.data.repository.base.ArtistRepository

/**
 * Created by Robin Yang on 11/20/17.
 */
class GetArtistDetailInteractor(val artistRepository: ArtistRepository) : Interactor {

    var id: String? = null

    override fun invoke(): Event {
        val id = this.id ?: throw IllegalStateException("id can't be null")
        val artist = artistRepository.getArtist(id)
        return ArtistDetailEvent(artist)
    }
}