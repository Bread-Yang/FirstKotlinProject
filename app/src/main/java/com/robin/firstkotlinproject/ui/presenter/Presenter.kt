package com.robin.firstkotlinproject.ui.presenter

import com.robin.firstkotlinproject.domain.interactor.base.Bus

/**
 * Created by Robin Yang on 11/17/17.
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