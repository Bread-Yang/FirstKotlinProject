package com.robin.firstkotlinproject.ui.screens

import android.view.View
import com.robin.firstkotlinproject.R
import com.robin.firstkotlinproject.ui.custom.AutofitRecyclerView
import com.robin.firstkotlinproject.ui.custom.PaddingItemDecoration
import org.jetbrains.anko.dimen
import org.jetbrains.anko.dip
import org.jetbrains.anko.horizontalPadding
import org.jetbrains.anko.verticalPadding

/**
 * Created by Robin Yang on 11/20/17.
 */
fun AutofitRecyclerView.style() {
    clipToPadding = false
    columnWidth = dip(180)
    scrollBarStyle = View.SCROLLBARS_OUTSIDE_OVERLAY
    horizontalPadding = dimen(R.dimen.recycler_spacing)
    verticalPadding = dip(2)
    addItemDecoration(PaddingItemDecoration(dip(2)))
}