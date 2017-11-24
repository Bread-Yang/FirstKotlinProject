package com.robin.firstkotlinproject.data.lastfm.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by Robin Yang on 11/22/17.
 */
class LastFmImage (
        @SerializedName("#text") val url: String,
        val size: String
)