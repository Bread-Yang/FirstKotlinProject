package com.robin.firstkotlinproject.ui.model.mapper

import com.robin.firstkotlinproject.domain.model.Artist
import com.robin.firstkotlinproject.ui.model.ArtistDetail
import com.robin.firstkotlinproject.ui.model.ImageTitle

/**
 * Mapper class used to transform [Artist] (in the domain layer) to [ArtistDetail] in the
 * presentation layer.
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