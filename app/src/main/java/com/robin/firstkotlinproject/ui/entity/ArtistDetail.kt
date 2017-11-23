package com.robin.firstkotlinproject.ui.entity

/**
 * Created by Robin Yang on 11/20/17.
 */
data class ArtistDetail(val id: String,
                        val name: String,
                        val url: String? = null,
                        val bio: String? = null,
                        val albums: List<ImageTitle>? = null)