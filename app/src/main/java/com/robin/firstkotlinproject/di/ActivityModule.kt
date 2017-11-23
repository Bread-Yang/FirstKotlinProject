package com.robin.firstkotlinproject.di


import android.content.Context
import android.support.v7.app.AppCompatActivity
import com.robin.firstkotlinproject.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Robin Yang on 10/30/17.
 */
@Module
abstract class ActivityModule(protected val activity: AppCompatActivity) {

    @Provides
    @ActivityScope
    fun provideActivity(): AppCompatActivity = activity

    @Provides
    @ActivityScope
    fun provideActivityContext(): Context = activity.baseContext
}
