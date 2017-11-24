package com.robin.firstkotlinproject.ui.view

import com.robin.firstkotlinproject.ui.model.ArtistDetail
import com.robin.firstkotlinproject.ui.model.ImageTitle

/**
 * Created by Robin Yang on 11/20/17.
 */
interface ArtistView : PresentationView {

    fun showArtist(artistDetail: ArtistDetail)

    fun showAlbums(albums: List<ImageTitle>)

    fun navigateToAlbum(albumId: String)
}