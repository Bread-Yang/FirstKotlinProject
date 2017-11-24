package com.robin.firstkotlinproject.domain.interactor.event

import com.robin.firstkotlinproject.domain.model.Artist
import com.robin.firstkotlinproject.domain.interactor.base.Event

/**
 * Created by Robin Yang on 11/20/17.
 */
data class ArtistDetailEvent(val artist: Artist) : Event