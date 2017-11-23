package com.robin.firstkotlinproject.data.lastfm.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Robin Yang on 11/22/17.
 */
class LastFmArtistMatches (
        @SerializedName("artist") val artists: List<LastFmArtist>
)