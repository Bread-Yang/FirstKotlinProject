package com.robin.firstkotlinproject.data

import retrofit2.Call


/**
 * Created by Robin Yang on 11/23/17.
 */
inline fun <T, U> Call<T>.unwrapCall(f: T.() -> U) = execute().body()?.f()