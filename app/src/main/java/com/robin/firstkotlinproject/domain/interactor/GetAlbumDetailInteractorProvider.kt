package com.robin.firstkotlinproject.domain.interactor

import com.robin.firstkotlinproject.domain.interactor.base.Event
import com.robin.firstkotlinproject.domain.interactor.base.Interactor
import com.robin.firstkotlinproject.domain.interactor.event.AlbumEvent
import com.robin.firstkotlinproject.domain.repository.AlbumRepository

/**
 * Created by Robin Yang on 11/22/17.
 */
class GetAlbumDetailInteractor(val albumRepoitory: AlbumRepository) : Interactor {

    var albumId: String? = null

    override fun invoke(): Event {
        val id = albumId ?: throw IllegalStateException("Album id should be specified")

        val album = albumRepoitory.getAlbum(id)
        return AlbumEvent(album)
    }
}