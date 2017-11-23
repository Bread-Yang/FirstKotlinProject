package com.robin.firstkotlinproject.domain.interactor.base

/**
 * Created by Robin Yang on 11/17/17.
 */
interface InteractorExecutor {
    fun execute(interactor: Interactor, priority: InteractorPriority = InteractorPriority.LOW)
}