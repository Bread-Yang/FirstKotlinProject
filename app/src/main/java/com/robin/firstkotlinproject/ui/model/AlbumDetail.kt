package com.robin.firstkotlinproject.ui.model

import com.robin.firstkotlinproject.domain.model.Track

/**
 * Class that represents a Album in the presentation layer.
 */
data class AlbumDetail(val id: String,
                       val name: String,
                       val url: String? = null,
                       val tracks: List<Track> = emptyList())