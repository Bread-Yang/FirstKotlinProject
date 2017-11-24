package com.robin.firstkotlinproject.domain.model

/**
 * Class that represents a Album in the domain layer.
 */
data class Album(
        val id: String,
        val name: String,
        val artist: Artist? = null,
        val url: String? = null,
        val tracks: List<Track> = emptyList()
)