package com.robin.firstkotlinproject.ui.presenter

import com.robin.firstkotlinproject.domain.interactor.base.Bus
import com.robin.firstkotlinproject.domain.interactor.base.InteractorExecutor
import com.robin.firstkotlinproject.domain.interactor.event.ArtistsEvent
import com.robin.firstkotlinproject.ui.entity.ImageTitle
import com.robin.firstkotlinproject.ui.entity.mapper.ImageTitleDataMapper
import com.robin.firstkotlinproject.ui.screens.event.GetRecommendedArtistsInteractor
import com.robin.firstkotlinproject.ui.view.MainView

/**
 * Created by Robin Yang on 11/17/17.
 */
class MainPresenter(
        override val view: MainView,
        override val bus: Bus,
        val recommendedArtistsInterator: GetRecommendedArtistsInteractor,
        val interactorExecutor: InteractorExecutor,
        val mapper: ImageTitleDataMapper) : Presenter<MainView> {

    override fun onResume() {
        super.onResume()
        interactorExecutor.execute(recommendedArtistsInterator)
    }

    fun onEvent(event: ArtistsEvent) {
        view.showArtists(mapper.transformArtists(event.artists))
    }

    fun onArtistClicked(item: ImageTitle) {
        view.navigateToDetail(item.id)
    }
}