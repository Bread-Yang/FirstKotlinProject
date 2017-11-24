package com.robin.firstkotlinproject.domain.model.mapper

import com.robin.firstkotlinproject.data.lastfm.entity.LastFmImage
import com.robin.firstkotlinproject.data.lastfm.entity.LastFmImageType

/**
 * Mapper class used to transform [LastFmImage] (in the data layer) to [String] in the
 * domain layer.
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