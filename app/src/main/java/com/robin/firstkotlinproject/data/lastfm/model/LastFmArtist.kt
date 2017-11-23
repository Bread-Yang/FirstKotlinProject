package com.robin.firstkotlinproject.data.lastfm.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Robin Yang on 11/22/17.
 */
class LastFmArtist (
        val name: String,
        val mbid: String?,
        val url: String,
        @SerializedName("image") val images: List<LastFmImage>? = null,
        val similar: LastFmSimilar? = null,
        val bio: LastFmBio? = null
)