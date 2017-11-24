package com.robin.firstkotlinproject

import android.app.Application
import com.robin.firstkotlinproject.ui.di.ApplicationComponent
import com.robin.firstkotlinproject.ui.di.ApplicationModule
import com.robin.firstkotlinproject.ui.di.DaggerApplicationComponent

/**
 * Created by Robin Yang on 10/27/17.
 */
class App : Application() {

    companion object {
        lateinit var graph: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        initializeDagger()
    }

    fun initializeDagger() {
        graph = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }
}