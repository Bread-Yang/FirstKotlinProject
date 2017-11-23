package com.robin.firstkotlinproject.ui.activity

import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext

/**
 * Created by Robin Yang on 11/17/17.
 */
interface ViewAnkoComponent<T : ViewGroup> : AnkoComponent<T> {

    val view: T

    fun inflate(): View {
        val ctx = AnkoContext.Companion.create(view.context, view)
        return createView(ctx)
    }
}