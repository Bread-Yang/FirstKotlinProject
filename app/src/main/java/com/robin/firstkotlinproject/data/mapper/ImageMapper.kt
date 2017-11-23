package com.robin.firstkotlinproject.data.mapper

import com.robin.firstkotlinproject.data.lastfm.model.LastFmImage
import com.robin.firstkotlinproject.data.lastfm.model.LastFmImageType

/**
 * Created by Robin Yang on 11/23/17.
 */
class ImageMapper {

    fun getMainImageUrl(images: List<LastFmImage>?): String? {
        if (images == null || images.isEmpty()) {
            return null
        }

        val image = images.firstOrNull { it.size == LastFmImageType.MEGA.type }
        return image?.url ?: images.last().url
    }
}