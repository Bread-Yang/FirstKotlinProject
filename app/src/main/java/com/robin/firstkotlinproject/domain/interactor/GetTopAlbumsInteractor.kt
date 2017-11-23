package com.robin.firstkotlinproject.domain.interactor

import com.robin.firstkotlinproject.domain.interactor.base.Event
import com.robin.firstkotlinproject.domain.interactor.base.Interactor
import com.robin.firstkotlinproject.domain.interactor.event.TopAlbumsEvent
import com.robin.firstkotlinproject.domain.repository.AlbumRepository

/**
 * Created by Robin Yang on 11/20/17.
 */
class GetTopAlbumsInteractor(val albumRepository: AlbumRepository) : Interactor {

    var artistId: String? = null
    var artistName: String? = null

    override fun invoke(): Event {
        if (artistId == null && artistName == null) {
            throw IllegalStateException("Either mbid or name should be specified")
        }
        val albums = albumRepository.getTopAlbums(artistId, artistName)
        return TopAlbumsEvent(albums)
    }
}