package com.robin.firstkotlinproject.di

import com.robin.firstkotlinproject.domain.interactor.GetAlbumDetailInteractor
import com.robin.firstkotlinproject.domain.interactor.GetArtistDetailInteractor
import com.robin.firstkotlinproject.domain.interactor.GetTopAlbumsInteractor
import com.robin.firstkotlinproject.domain.repository.AlbumRepository
import com.robin.firstkotlinproject.domain.repository.ArtistRepository
import com.robin.firstkotlinproject.ui.screens.event.GetRecommendedArtistsInteractor
import dagger.Module
import dagger.Provides

/**
 * Created by Robin Yang on 10/30/17.
 */
@Module
class DomainModule {

    @Provides
    fun provideRecommendedArtistsInteractor(artistRepository: ArtistRepository): GetRecommendedArtistsInteractor =
            GetRecommendedArtistsInteractor(artistRepository)

    @Provides
    fun provideArtistDetailInteractor(artistRepository: ArtistRepository): GetArtistDetailInteractor =
            GetArtistDetailInteractor(artistRepository)

    @Provides
    fun provideTopAlbumsInteractor(albumRepository: AlbumRepository): GetTopAlbumsInteractor =
            GetTopAlbumsInteractor(albumRepository)

    @Provides
    fun provideAlbumsDetailInteractor(albumRepository : AlbumRepository): GetAlbumDetailInteractor =
            GetAlbumDetailInteractor(albumRepository)
}