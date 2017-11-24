package com.robin.firstkotlinproject.ui.di.subcomponent.detail

import com.robin.firstkotlinproject.ui.di.ActivityModule
import com.robin.firstkotlinproject.ui.di.scope.ActivityScope
import com.robin.firstkotlinproject.domain.interactor.GetArtistDetailInteractor
import com.robin.firstkotlinproject.domain.interactor.GetTopAlbumsInteractor
import com.robin.firstkotlinproject.domain.interactor.base.Bus
import com.robin.firstkotlinproject.domain.interactor.base.InteractorExecutor
import com.robin.firstkotlinproject.ui.model.mapper.ArtistDetailDataMapper
import com.robin.firstkotlinproject.ui.model.mapper.ImageTitleDataMapper
import com.robin.firstkotlinproject.ui.presenter.ArtistPresenter
import com.robin.firstkotlinproject.ui.screens.detail.AlbumsFragment
import com.robin.firstkotlinproject.ui.screens.detail.ArtistActivity
import com.robin.firstkotlinproject.ui.screens.detail.BiographyFragment
import com.robin.firstkotlinproject.ui.view.ArtistView
import dagger.Module
import dagger.Provides

/**
 * Created by Robin Yang on 10/30/17.
 */
@Module
class ArtistActivityModule(activity: ArtistActivity) : ActivityModule(activity) {

    @Provides
    @ActivityScope
    fun provideArtistView(): ArtistView = activity as ArtistView

    @Provides
    @ActivityScope
    fun provideArtistDataMapper(): ArtistDetailDataMapper =
            ArtistDetailDataMapper()

    @Provides
    @ActivityScope
    fun provideImageTitleDataMapper(): ImageTitleDataMapper =
            ImageTitleDataMapper()

    @Provides
    @ActivityScope
    fun provideActivityPresenter(view: ArtistView,
                                 bus: Bus,
                                 artistDetailInteractor: GetArtistDetailInteractor,
                                 topAlbumsInteractor: GetTopAlbumsInteractor,
                                 interactorExecutor: InteractorExecutor,
                                 detailDataMapper: ArtistDetailDataMapper,
                                 imageTitleDataMapper: ImageTitleDataMapper) =
            ArtistPresenter(view, bus, artistDetailInteractor, topAlbumsInteractor,
                    interactorExecutor, detailDataMapper, imageTitleDataMapper)

    @Provides
    @ActivityScope
    fun provideAlbumsFragment(): AlbumsFragment =
            AlbumsFragment()

    @Provides
    @ActivityScope
    fun provideBiographyFragment(): BiographyFragment =
            BiographyFragment()
}