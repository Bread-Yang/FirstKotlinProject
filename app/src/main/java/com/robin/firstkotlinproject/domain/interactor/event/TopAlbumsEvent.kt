package com.robin.firstkotlinproject.domain.interactor.event

import com.robin.firstkotlinproject.domain.model.Album
import com.robin.firstkotlinproject.domain.interactor.base.Event

/**
 * Created by Robin Yang on 11/20/17.
 */
data class TopAlbumsEvent(val topAlbums: List<Album>) : Event