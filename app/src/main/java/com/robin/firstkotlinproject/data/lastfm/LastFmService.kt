package com.robin.firstkotlinproject.data.lastfm

import com.robin.firstkotlinproject.data.lastfm.model.LastFmResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Robin Yang on 11/22/17.
 */
interface LastFmService {

    @GET("/2.0/?method=artist.search")
    fun searchArtist(@Query("artist") artist: String): retrofit2.Call<LastFmResponse>

    @GET("/2.0/?method=artist.getinfo")
    fun requestArtistInfo(@Query("mbid") id: String, @Query("lang") language: String): retrofit2.Call<LastFmResponse>

    @GET("/2.0/?method=artist.gettopalbums")
    fun requestAlbums(@Query("mbid") id: String, @Query("artist") artist: String): retrofit2.Call<LastFmResponse>

    @GET("/2.0/?method=artist.getsimilar")
    fun requestSimilar(@Query("mbid") id: String): retrofit2.Call<LastFmResponse>

    @GET("/2.0/?method=album.getInfo")
    fun requestAlbum(@Query("mbid") id: String): retrofit2.Call<LastFmResponse>
}