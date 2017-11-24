package com.robin.firstkotlinproject.domain.model.mapper

import com.robin.firstkotlinproject.data.lastfm.entity.LastFmTrack
import com.robin.firstkotlinproject.domain.model.Track

/**
 * Mapper class used to transform [LastFmTrack] (in the data layer) to [Track] in the
 * domain layer.
 */
class TrackMapper {

    fun transform(tracks: List<LastFmTrack>?): List<Track> = tracks?.map { transform(it) } ?: emptyList()
    fun transform(track: LastFmTrack) = Track(track.name, track.duration)
}