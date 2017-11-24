package com.robin.firstkotlinproject.ui.view

import com.robin.firstkotlinproject.ui.model.ImageTitle

/**
 * Created by Robin Yang on 11/3/17.
 */
interface MainView : PresentationView {
    fun showArtists(artists: List<ImageTitle>)
    fun navigateToDetail(id: String)
}
