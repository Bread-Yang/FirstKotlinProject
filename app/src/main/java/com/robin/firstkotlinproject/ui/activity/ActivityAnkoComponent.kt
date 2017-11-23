package com.robin.firstkotlinproject.ui.activity

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import org.jetbrains.anko.AnkoComponent

/**
 * Created by Robin Yang on 10/27/17.
 */
interface ActivityAnkoComponent<T : AppCompatActivity> : AnkoComponent<T> {
    val toolbar: Toolbar
}
