package com.robin.firstkotlinproject.domain.interactor.base

/**
 * Created by Robin Yang on 11/17/17.
 */
interface Bus {
    fun post(event: Any): Unit
    fun register(observer: Any): Unit
    fun unregister(observer: Any): Unit
}
