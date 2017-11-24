package com.robin.firstkotlinproject.data.lastfm.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by Robin Yang on 11/22/17.
 */
class LastFmResult(
        @SerializedName("artistmatches") val artistMatches: LastFmArtistMatches
)