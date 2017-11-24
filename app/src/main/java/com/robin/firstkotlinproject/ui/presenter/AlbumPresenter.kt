package com.robin.firstkotlinproject.ui.presenter

import com.robin.firstkotlinproject.domain.interactor.GetAlbumDetailInteractor
import com.robin.firstkotlinproject.domain.interactor.base.Bus
import com.robin.firstkotlinproject.domain.interactor.base.InteractorExecutor
import com.robin.firstkotlinproject.domain.interactor.event.AlbumEvent
import com.robin.firstkotlinproject.ui.model.mapper.AlbumDetailDataMapper
import com.robin.firstkotlinproject.ui.view.AlbumView

/**
 * Created by Robin Yang on 11/21/17.
 */
open class AlbumPresenter(
        override val view: AlbumView,
        override val bus: Bus,
        val albumInteractor: GetAlbumDetailInteractor,
        val interactorExecutor: InteractorExecutor,
        val albumDetailMapper: AlbumDetailDataMapper) : Presenter<AlbumView> {

    open fun init(albumId: String) {
        val albumDetailInteractor = albumInteractor
        albumInteractor.albumId = albumId
        interactorExecutor.execute(albumDetailInteractor)
    }

    fun onEvent(event: AlbumEvent) {
        view.showAlbum(albumDetailMapper.transform(event.album))
    }
}