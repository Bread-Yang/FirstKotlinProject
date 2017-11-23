package com.robin.firstkotlinproject.di

import com.robin.firstkotlinproject.data.CloudAlbumDataSet
import com.robin.firstkotlinproject.data.CloudArtistDataSet
import com.robin.firstkotlinproject.data.lastfm.LastFmService
import com.robin.firstkotlinproject.di.qualifier.LanguageSelection
import com.robin.firstkotlinproject.domain.repository.AlbumRepository
import com.robin.firstkotlinproject.domain.repository.ArtistRepository
import com.robin.firstkotlinproject.repository.AlbumRepositoryImpl
import com.robin.firstkotlinproject.repository.ArtistRepositoryImp
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