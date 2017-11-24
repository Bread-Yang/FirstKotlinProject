package com.robin.firstkotlinproject.ui.model

/**
 * Class that represents a Artist in the presentation layer.
 */
data class ArtistDetail(val id: String,
                        val name: String,
                        val url: String? = null,
                        val bio: String? = null,
                        val albums: List<ImageTitle>? = null)