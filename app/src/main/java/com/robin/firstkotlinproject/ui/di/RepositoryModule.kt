package com.robin.firstkotlinproject.ui.di

import com.robin.firstkotlinproject.data.lastfm.LastFmService
import com.robin.firstkotlinproject.data.repository.AlbumRepositoryImpl
import com.robin.firstkotlinproject.data.repository.ArtistRepositoryImp
import com.robin.firstkotlinproject.data.repository.dataset.CloudAlbumDataSet
import com.robin.firstkotlinproject.data.repository.dataset.CloudArtistDataSet
import com.robin.firstkotlinproject.data.repository.base.AlbumRepository
import com.robin.firstkotlinproject.data.repository.base.ArtistRepository
import com.robin.firstkotlinproject.ui.di.qualifier.LanguageSelection
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Robin Yang on 10/30/17.
 */
@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideArtistRepo(@LanguageSelection language: String, lastFmService: LastFmService): ArtistRepository
            = ArtistRepositoryImp(listOf(CloudArtistDataSet(language, lastFmService)))

    @Provides
    @Singleton
    fun provideAlbumRepo(lastFmService: LastFmService): AlbumRepository
            = AlbumRepositoryImpl(listOf(CloudAlbumDataSet(lastFmService)))
}