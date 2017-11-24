package com.robin.firstkotlinproject.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.robin.firstkotlinproject.App
import com.robin.firstkotlinproject.ui.di.ApplicationComponent
import org.jetbrains.anko.setContentView

/**
 * Base [AppCompatActivity] class for every Activity in this application.
 */
abstract class BaseActivity<out UI : ActivityAnkoComponent<out AppCompatActivity>> : AppCompatActivity() {

    companion object {
        val IMAGE_TRANSITION_NAME = "activity_image_transition"
    }

    abstract val ui: UI

    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependencies(App.graph)
        (ui as ActivityAnkoComponent<AppCompatActivity>).setContentView(this)
//        setSupportActionBar(ui.toolbar)
    }

    abstract fun injectDependencies(applicationComponent: ApplicationComponent)
}