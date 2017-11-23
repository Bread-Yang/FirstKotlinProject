package com.robin.firstkotlinproject.di.subcomponent.album

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import com.robin.firstkotlinproject.di.ActivityModule
import com.robin.firstkotlinproject.di.scope.ActivityScope
import com.robin.firstkotlinproject.domain.interactor.GetAlbumDetailInteractor
import com.robin.firstkotlinproject.domain.interactor.base.Bus
import com.robin.firstkotlinproject.domain.interactor.base.InteractorExecutor
import com.robin.firstkotlinproject.ui.adapter.TracksAdapter
import com.robin.firstkotlinproject.ui.entity.mapper.AlbumDetailDataMapper
import com.robin.firstkotlinproject.ui.entity.mapper.TrackDataMapper
import com.robin.firstkotlinproject.ui.presenter.AlbumPresenter
import com.robin.firstkotlinproject.ui.screens.album.AlbumActivity
import com.robin.firstkotlinproject.ui.view.AlbumView
import dagger.Module
import dagger.Provides

/**
 * Created by Robin Yang on 10/30/17.
 */
@Module
class AlbumActivityModule(activity: AlbumActivity) : ActivityModule(activity) {

    @Provides
    @ActivityScope
    fun provideAlbumView(): AlbumView =
            activity as AlbumView

    @Provides
    @ActivityScope
    fun provideAlbumDataMapper(): AlbumDetailDataMapper =
            AlbumDetailDataMapper()

    @Provides
    @ActivityScope
    fun provideTrackDataMapper(): TrackDataMapper =
            TrackDataMapper()

    @Provides
    @ActivityScope
    fun provideLinearLayoutManager(context: Context) =
            LinearLayoutManager(context)

    @Provides
    @ActivityScope
    fun provideTracksAdapter(): TracksAdapter =
            TracksAdapter()

    @Provides
    @ActivityScope
    fun provideAlbumPresenter(view: AlbumView,
                              bus: Bus,
                              albumInteractor: GetAlbumDetailInteractor,
                              interactorExecutor: InteractorExecutor,
                              albumDetailDataMapper: AlbumDetailDataMapper) =
            AlbumPresenter(view, bus, albumInteractor,
                    interactorExecutor, albumDetailDataMapper)
}