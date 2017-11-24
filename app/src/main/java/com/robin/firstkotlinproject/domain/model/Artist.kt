package com.robin.firstkotlinproject.domain.model

/**
 * Class that represents a Artist in the domain layer.
 */
data class Artist(
        val id: String,
        val name: String,
        val url: String? = null,
        val bio: String? = null,
        val albums: List<Album>? = null
)