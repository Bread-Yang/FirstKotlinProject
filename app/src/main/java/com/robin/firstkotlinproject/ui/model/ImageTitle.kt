package com.robin.firstkotlinproject.ui.model

/**
 * Class that represents a Image in the presentation layer.
 */
data class ImageTitle(val id: String, val name: String, private val rawUrl: String? = null) {
    // Picasso handles nulls nicely, but not empty strings
    val url: String? = if ("" == rawUrl) null else rawUrl
}