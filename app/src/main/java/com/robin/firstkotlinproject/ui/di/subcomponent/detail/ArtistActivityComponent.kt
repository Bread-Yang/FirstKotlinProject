package com.robin.firstkotlinproject.ui.di.subcomponent.detail

import com.robin.firstkotlinproject.ui.di.scope.ActivityScope
import com.robin.firstkotlinproject.ui.screens.detail.ArtistActivity
import dagger.Subcomponent

/**
 * Created by Robin Yang on 10/30/17.
 */
@ActivityScope
@Subcomponent(modules = arrayOf(
        ArtistActivityModule::class
))
interface ArtistActivityComponent {

    fun injectTo(activity: ArtistActivity)
}