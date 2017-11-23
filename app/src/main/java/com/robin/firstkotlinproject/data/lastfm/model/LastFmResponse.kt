package com.robin.firstkotlinproject.data.lastfm.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Robin Yang on 11/22/17.
 */
class LastFmResponse(
        val results: LastFmResult,
        val artist: LastFmArtist,
        @SerializedName("topalbums") val topAlbums: LastFmTopAlbums,
        @SerializedName("similarartists") val similarArtists: LastFmArtistList,
        val album: LastFmAlbumDetail
)