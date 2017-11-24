package com.robin.firstkotlinproject.domain.interactor.event

import com.robin.firstkotlinproject.domain.model.Artist
import com.robin.firstkotlinproject.domain.interactor.base.Event

/**
 * Created by Robin Yang on 11/17/17.
 */
data class ArtistsEvent(val artists: List<Artist>) : Event