package com.robin.firstkotlinproject.ui.di

import com.robin.firstkotlinproject.ui.di.subcomponent.album.AlbumActivityComponent
import com.robin.firstkotlinproject.ui.di.subcomponent.album.AlbumActivityModule
import com.robin.firstkotlinproject.ui.di.subcomponent.detail.ArtistActivityComponent
import com.robin.firstkotlinproject.ui.di.subcomponent.detail.ArtistActivityModule
import com.robin.firstkotlinproject.ui.di.subcomponent.main.MainActivityComponent
import com.robin.firstkotlinproject.ui.di.subcomponent.main.MainActivityModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Robin Yang on 10/27/17.
 */
@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        DataModule::class,
        RepositoryModule::class,
        DomainModule::class
))
interface ApplicationComponent {
    fun plus(module: MainActivityModule): MainActivityComponent
    fun plus(module: ArtistActivityModule): ArtistActivityComponent
    fun plus(module: AlbumActivityModule): AlbumActivityComponent
}