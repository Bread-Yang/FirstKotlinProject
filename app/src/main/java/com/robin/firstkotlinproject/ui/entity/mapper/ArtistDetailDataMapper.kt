package com.robin.firstkotlinproject.ui.entity.mapper

import com.robin.firstkotlinproject.domain.entity.Artist
import com.robin.firstkotlinproject.ui.entity.ArtistDetail
import com.robin.firstkotlinproject.ui.entity.ImageTitle

/**
 * Created by Robin Yang on 11/20/17.
 */
class ArtistDetailDataMapper {

    fun transform(artist: Artist) = ArtistDetail(
            artist.id,
            artist.name,
            artist.url,
            artist.bio,
            artist.albums?.map { ImageTitle(it.id, it.name, it.url) }
    )
}