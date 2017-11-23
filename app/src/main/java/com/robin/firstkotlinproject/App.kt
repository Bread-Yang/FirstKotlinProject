package com.robin.firstkotlinproject

import android.app.Application
import com.robin.firstkotlinproject.di.ApplicationComponent
import com.robin.firstkotlinproject.di.ApplicationModule
import com.robin.firstkotlinproject.di.DaggerApplicationComponent

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