package com.robin.firstkotlinproject.ui.entity.mapper

import com.robin.firstkotlinproject.domain.entity.Track
import com.robin.firstkotlinproject.ui.entity.TrackDetail

/**
 * Created by Robin Yang on 11/22/17.
 */
class TrackDataMapper {
    fun transform(number: Int, domainTrack: Track) = TrackDetail(number, domainTrack.name, domainTrack.duration)
    fun transform(domainTrack: List<Track>) =
            domainTrack.mapIndexed { index, track -> transform(index + 1, track) }
}