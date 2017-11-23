package com.robin.firstkotlinproject.domain.interactor.base

/**
 * Created by Robin Yang on 11/17/17.
 */
enum class InteractorPriority(val value: Int) {
    LOW(0),
    MID(500),
    HIGH(1000)
}