package com.robin.firstkotlinproject.data.lastfm.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Robin Yang on 11/22/17.
 */
class LastFmAlbum(
        val name: String,
        val mbid: String?,
        val url: String,
        val artist: LastFmArtist,
        @SerializedName("image") val images: List<LastFmImage>,
        val tracks: LastFmTracklist?
)