package com.robin.firstkotlinproject.domain.entity

/**
 * Created by Robin Yang on 11/17/17.
 */
data class Album(
        val id: String,
        val name: String,
        val artist: Artist? = null,
        val url: String? = null,
        val tracks: List<Track> = emptyList()
)