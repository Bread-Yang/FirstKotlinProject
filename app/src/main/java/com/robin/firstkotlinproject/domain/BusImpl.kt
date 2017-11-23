package com.robin.firstkotlinproject.domain

import android.os.Handler
import android.os.Looper
import com.robin.firstkotlinproject.domain.interactor.base.Bus
import de.greenrobot.event.EventBus

/**
 * Created by Robin Yang on 11/22/17.
 */
class BusImpl : EventBus(), Bus {

    val mainThread = Handler(Looper.getMainLooper())

    override fun post(event: Any) {
        mainThread.post({ super.post(event) })
    }
}