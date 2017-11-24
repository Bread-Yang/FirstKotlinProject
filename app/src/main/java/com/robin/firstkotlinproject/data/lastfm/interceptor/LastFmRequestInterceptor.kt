package com.robin.firstkotlinproject.data.lastfm.interceptor

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by Robin Yang on 11/22/17.
 */
class LastFmRequestInterceptor(val apiKey: String, val cacheDuration: Int) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val url = request.url().newBuilder()
                .addQueryParameter("api_key", apiKey)
                .addQueryParameter("format", "json")
                .build()

        val newRequest = request.newBuilder()
                .url(url)
                .addHeader("Cache-Control", "public, max-age=$cacheDuration")
                .build()
        return chain.proceed(newRequest)
    }
}