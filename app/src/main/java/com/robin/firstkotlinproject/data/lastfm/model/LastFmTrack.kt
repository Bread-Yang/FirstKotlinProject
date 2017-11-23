package com.robin.firstkotlinproject.data.lastfm.model

/**
 * Created by Robin Yang on 11/22/17.
 */
class LastFmTrack (
        val name: String,
        val duration: Int = 0,
        val mbid: String?,
        val url: String?,
        val artist: LastFmArtist
)
