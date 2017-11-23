package com.robin.firstkotlinproject.di.subcomponent.album

import com.robin.firstkotlinproject.di.scope.ActivityScope
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