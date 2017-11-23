package com.robin.firstkotlinproject.ui.util

import android.os.Build

/**
 * Created by Robin Yang on 11/20/17.
 */
fun supportsKitKat(code: () -> Unit) {
    supportVersion(code, 19)
}

fun supportsLollipop(code: () -> Unit) {
    supportVersion(code, 21)
}

private fun supportVersion(code: () -> Unit, sdk: Int) {
    if (Build.VERSION.SDK_INT >= sdk) {
        code.invoke()
    }
}