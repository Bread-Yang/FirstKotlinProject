package com.robin.firstkotlinproject.ui.view

import com.robin.firstkotlinproject.ui.entity.AlbumDetail

/**
 * Created by Robin Yang on 11/21/17.
 */
interface AlbumView : PresentationView {
    fun showAlbum(albumDetail: AlbumDetail?)
}
