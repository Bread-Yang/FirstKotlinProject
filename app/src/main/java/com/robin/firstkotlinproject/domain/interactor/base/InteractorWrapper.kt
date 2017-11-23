package com.robin.firstkotlinproject.domain.interactor.base

import com.birbit.android.jobqueue.Job
import com.birbit.android.jobqueue.Params
import com.birbit.android.jobqueue.RetryConstraint

/**
 * Created by Robin Yang on 11/22/17.
 */
class InteractorWrapper(val interactor: Interactor, priority: InteractorPriority, val bus: Bus) :
        Job(Params(priority.value).requireNetwork()) {


    override fun onRun() {
        val event = interactor.invoke()
        bus.post(event)
    }

    override fun onAdded() = Unit
    override fun onCancel(cancelReason: Int, throwable: Throwable?) = Unit
    override fun shouldReRunOnThrowable(throwable: Throwable, runCount: Int, maxRunCount: Int): RetryConstraint = RetryConstraint.CANCEL
}