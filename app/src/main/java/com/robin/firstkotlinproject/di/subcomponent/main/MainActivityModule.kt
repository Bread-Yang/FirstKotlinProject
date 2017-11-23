package com.robin.firstkotlinproject.di.subcomponent.main

import com.robin.firstkotlinproject.di.ActivityModule
import com.robin.firstkotlinproject.di.scope.ActivityScope
import com.robin.firstkotlinproject.domain.interactor.base.Bus
import com.robin.firstkotlinproject.domain.interactor.base.InteractorExecutor
import com.robin.firstkotlinproject.ui.entity.mapper.ImageTitleDataMapper
import com.robin.firstkotlinproject.ui.presenter.MainPresenter
import com.robin.firstkotlinproject.ui.screens.event.GetRecommendedArtistsInteractor
import com.robin.firstkotlinproject.ui.screens.main.MainActivity
import com.robin.firstkotlinproject.ui.view.MainView
import dagger.Module
import dagger.Provides

/**
 * Created by Robin Yang on 10/30/17.
 */
@Module
class MainActivityModule(activity: MainActivity) : ActivityModule(activity) {

    @Provides
    @ActivityScope
    fun provideMainView(): MainView = activity as MainView

    @Provides
    @ActivityScope
    fun provideImageTitleMapper(): ImageTitleDataMapper = ImageTitleDataMapper()

    @Provides
    @ActivityScope
    fun provideMainPresenter(view: MainView, bus: Bus,
                             recommendedArtistsInteractor: GetRecommendedArtistsInteractor,
                             interactorExecutor: InteractorExecutor,
                             imageMapper: ImageTitleDataMapper) =
            MainPresenter(view, bus, recommendedArtistsInteractor, interactorExecutor, imageMapper)
}