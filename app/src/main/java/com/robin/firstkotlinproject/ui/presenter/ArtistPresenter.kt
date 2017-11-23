package com.robin.firstkotlinproject.ui.presenter

import com.robin.firstkotlinproject.domain.interactor.GetArtistDetailInteractor
import com.robin.firstkotlinproject.domain.interactor.GetTopAlbumsInteractor
import com.robin.firstkotlinproject.domain.interactor.base.Bus
import com.robin.firstkotlinproject.domain.interactor.base.InteractorExecutor
import com.robin.firstkotlinproject.domain.interactor.event.ArtistDetailEvent
import com.robin.firstkotlinproject.domain.interactor.event.TopAlbumsEvent
import com.robin.firstkotlinproject.ui.entity.ImageTitle
import com.robin.firstkotlinproject.ui.entity.mapper.ArtistDetailDataMapper
import com.robin.firstkotlinproject.ui.entity.mapper.ImageTitleDataMapper
import com.robin.firstkotlinproject.ui.view.ArtistView

/**
 * Created by Robin Yang on 11/20/17.
 */
open class ArtistPresenter(
        override val view: ArtistView,
        override val bus: Bus,
        val artistDetailInteractor: GetArtistDetailInteractor,
        val topAlbumsInteractor: GetTopAlbumsInteractor,
        val interactorExecutor: InteractorExecutor,
        val artistDetailMapper: ArtistDetailDataMapper,
        val albumsMapper: ImageTitleDataMapper) : Presenter<ArtistView>, AlbumsPresenter {

    open fun init(artistId: String) {
        val artistDetailInteractor = artistDetailInteractor
        artistDetailInteractor.id = artistId
        interactorExecutor.execute(artistDetailInteractor)

        val topAlbumsInteractor = topAlbumsInteractor
        topAlbumsInteractor.artistId = artistId
        interactorExecutor.execute(this.topAlbumsInteractor)
    }

    fun onEvent(event: ArtistDetailEvent) {
        view.showArtist(artistDetailMapper.transform(event.artist))
    }

    fun onEvent(event: TopAlbumsEvent) {
        view.showAlbums(albumsMapper.transformAlbums(event.topAlbums))
    }

    override fun onAlbumClicked(item: ImageTitle) {
        view.navigateToAlbum(item.id)
    }
}