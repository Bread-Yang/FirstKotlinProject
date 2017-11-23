package com.robin.firstkotlinproject.ui.screens.main

import android.os.Bundle
import android.view.View
import com.robin.firstkotlinproject.di.ApplicationComponent
import com.robin.firstkotlinproject.di.subcomponent.main.MainActivityModule
import com.robin.firstkotlinproject.ui.activity.BaseActivity
import com.robin.firstkotlinproject.ui.adapter.BaseAdapter
import com.robin.firstkotlinproject.ui.adapter.ImageTitleAdapter
import com.robin.firstkotlinproject.ui.entity.ImageTitle
import com.robin.firstkotlinproject.ui.presenter.MainPresenter
import com.robin.firstkotlinproject.ui.screens.detail.ArtistActivity
import com.robin.firstkotlinproject.ui.util.navigate
import com.robin.firstkotlinproject.ui.view.MainView
import javax.inject.Inject

class MainActivity : BaseActivity<MainLayout>(), MainView {

    override val ui = MainLayout()

    @Inject
    lateinit var presenter: MainPresenter

    val adapter = ImageTitleAdapter { presenter.onArtistClicked(it) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui.recycler.adapter = adapter
    }

    override fun injectDependencies(applicationComponent: ApplicationComponent) {
        applicationComponent.plus(MainActivityModule(this))
                .injectTo(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    override fun showArtists(artists: List<ImageTitle>) {
        adapter.items = artists
    }

    override fun navigateToDetail(id: String) {
        navigate<ArtistActivity>(id, findItemById(id), BaseActivity.IMAGE_TRANSITION_NAME)
    }

    private fun findItemById(id: String): View {
        val pos = adapter.findPositionById(id)
        val holder = ui.recycler.findViewHolderForLayoutPosition(pos)
                as BaseAdapter.BaseViewHolder<ImageTitleAdapter.Component>
        return holder.ui.image
    }
}
