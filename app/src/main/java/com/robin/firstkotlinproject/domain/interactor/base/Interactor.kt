package com.robin.firstkotlinproject.domain.interactor.base

/**
 * Created by Robin Yang on 11/17/17.
 */
interface Interactor {
    operator fun invoke(): Event
}