package com.robin.firstkotlinproject.domain.interactor.base

import com.birbit.android.jobqueue.JobManager

/**
 * Created by Robin Yang on 11/22/17.
 */
class InteractorExecutorImpl(val jobManager: JobManager, val bus: Bus) : InteractorExecutor {

    override fun execute(interactor: Interactor, priority: InteractorPriority) {
        jobManager.addJobInBackground(InteractorWrapper(interactor, priority, bus))
    }

}