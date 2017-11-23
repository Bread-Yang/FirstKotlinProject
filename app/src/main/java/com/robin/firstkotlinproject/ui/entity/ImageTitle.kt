package com.robin.firstkotlinproject.ui.entity

/**
 * Created by Robin Yang on 11/17/17.
 */
data class ImageTitle(val id: String, val name: String, private val rawUrl: String? = null) {
    // Picasso handles nulls nicely, but not empty strings
    val url: String? = if ("" == rawUrl) null else rawUrl
}