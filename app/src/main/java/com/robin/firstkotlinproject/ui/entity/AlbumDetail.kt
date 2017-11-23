package com.robin.firstkotlinproject.ui.entity

import com.robin.firstkotlinproject.domain.entity.Track

/**
 * Created by Robin Yang on 11/21/17.
 */
data class AlbumDetail(val id: String,
                       val name: String,
                       val url: String? = null,
                       val tracks: List<Track> = emptyList())