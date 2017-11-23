package com.robin.firstkotlinproject.ui.fragment

import com.robin.firstkotlinproject.ui.presenter.AlbumsPresenter

/**
 * Created by Robin Yang on 11/20/17.
 */

interface AlbumsFragmentContainer {
    fun getAlbumsPresenter(): AlbumsPresenter
}