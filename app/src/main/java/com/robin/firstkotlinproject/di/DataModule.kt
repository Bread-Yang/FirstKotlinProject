package com.robin.firstkotlinproject.di

import android.content.Context
import com.robin.firstkotlinproject.BuildConfig
import com.robin.firstkotlinproject.R
import com.robin.firstkotlinproject.data.lastfm.LastFmRequestInterceptor
import com.robin.firstkotlinproject.data.lastfm.LastFmService
import com.robin.firstkotlinproject.di.qualifier.ApiKey
import com.robin.firstkotlinproject.di.qualifier.ApplicationQualifier
import com.robin.firstkotlinproject.di.qualifier.CacheDuration
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Robin Yang on 10/30/17.
 */
@Module
class DataModule {

    @Provides
    @Singleton
    fun provideCache(@ApplicationQualifier context: Context) = Cache(context.cacheDir, 10 * 1024 * 1024.toLong())

    @Provides
    @Singleton
    @ApiKey
    fun provideApiKey(@ApplicationQualifier context: Context): String = context.getString(R.string.last_fm_api_key)

    @Provides
    @Singleton
    @CacheDuration
    fun provideCacheDuration(@ApplicationQualifier context: Context) = 86400

    @Provides
    @Singleton
    fun provideOkHttpClient(cache: Cache, interceptor: LastFmRequestInterceptor): OkHttpClient =
            OkHttpClient().newBuilder()
                    .cache(cache)
                    .addInterceptor(interceptor)
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = if (BuildConfig.DEBUG) Level.BODY else Level.NONE
                    })
                    .build()

    @Provides
    @Singleton
    fun provideRequestInterceptor(@ApiKey apiKey: String, @CacheDuration cacheDuration: Int)
            = LastFmRequestInterceptor(apiKey, cacheDuration)

    @Provides
    @Singleton
    fun provieRestAdapter(client: OkHttpClient): Retrofit =
            Retrofit.Builder()
                    .baseUrl("http://ws.audioscrobbler.com")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

    @Provides
    @Singleton
    fun providesLastFmService(retrofit: Retrofit): LastFmService = retrofit.create(LastFmService::class.java)
}