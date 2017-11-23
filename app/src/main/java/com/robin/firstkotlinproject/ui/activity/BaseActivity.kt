package com.robin.firstkotlinproject.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.robin.firstkotlinproject.App
import com.robin.firstkotlinproject.di.ApplicationComponent
import org.jetbrains.anko.setContentView

/**
 * Created by Robin Yang on 10/27/17.
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