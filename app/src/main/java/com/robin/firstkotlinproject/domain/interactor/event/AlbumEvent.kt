package com.robin.firstkotlinproject.domain.interactor.event

import com.robin.firstkotlinproject.domain.entity.Album
import com.robin.firstkotlinproject.domain.interactor.base.Event

/**
 * Created by Robin Yang on 11/21/17.
 */
data class AlbumEvent(val album: Album?) : Event