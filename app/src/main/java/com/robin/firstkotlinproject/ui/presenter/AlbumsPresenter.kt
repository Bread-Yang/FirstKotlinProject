package com.robin.firstkotlinproject.ui.presenter

import com.robin.firstkotlinproject.ui.model.ImageTitle

/**
 * Created by Robin Yang on 11/20/17.
 */
interface AlbumsPresenter {
    fun onAlbumClicked(item: ImageTitle)
}