package com.robin.firstkotlinproject.ui.model.mapper

import com.robin.firstkotlinproject.domain.model.Track
import com.robin.firstkotlinproject.ui.model.TrackDetail

/**
 * Mapper class used to transform [Track] (in the domain layer) to [TrackDetail] in the
 * presentation layer.
 */
class TrackDataMapper {
    fun transform(number: Int, domainTrack: Track) = TrackDetail(number, domainTrack.name, domainTrack.duration)
    fun transform(domainTrack: List<Track>) =
            domainTrack.mapIndexed { index, track -> transform(index + 1, track) }
}