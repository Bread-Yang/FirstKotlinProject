package com.robin.firstkotlinproject.domain.entity

/**
 * Created by Robin Yang on 11/17/17.
 */
data class Artist(
        val id: String,
        val name: String,
        val url: String? = null,
        val bio: String? = null,
        val albums: List<Album>? = null
)