package com.robin.firstkotlinproject.ui.presenter

import com.robin.firstkotlinproject.domain.interactor.base.Bus

/**
 * Interface representing a Presenter in a model view presenter (MVP) pattern.
 */
interface Presenter<out T> {

    val view: T
    val bus: Bus

    fun onResume() {
        bus.register(this)
    }

    fun onPause() {
        bus.unregister(this)
    }
}