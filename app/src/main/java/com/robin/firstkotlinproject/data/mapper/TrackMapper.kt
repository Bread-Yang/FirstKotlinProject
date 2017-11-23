package com.robin.firstkotlinproject.data.mapper

import com.robin.firstkotlinproject.data.lastfm.model.LastFmTrack
import com.robin.firstkotlinproject.domain.entity.Track

/**
 * Created by Robin Yang on 11/23/17.
 */
class TrackMapper {

    fun transform(tracks: List<LastFmTrack>?): List<Track> = tracks?.map { transform(it) } ?: emptyList()
    fun transform(track: LastFmTrack) = Track(track.name, track.duration)
}