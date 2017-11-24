package com.robin.firstkotlinproject.ui.di.subcomponent.album

import com.robin.firstkotlinproject.ui.di.scope.ActivityScope
import com.robin.firstkotlinproject.ui.screens.album.AlbumActivity
import dagger.Subcomponent

/**
 * Created by Robin Yang on 10/30/17.
 */
@ActivityScope
@Subcomponent(modules = arrayOf(
        AlbumActivityModule::class
))
interface AlbumActivityComponent {

    fun injectTo(activity: AlbumActivity)
}