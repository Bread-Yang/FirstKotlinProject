package com.robin.firstkotlinproject.ui.di

import android.content.Context
import com.birbit.android.jobqueue.JobManager
import com.robin.firstkotlinproject.App
import com.robin.firstkotlinproject.ui.di.qualifier.ApplicationQualifier
import com.robin.firstkotlinproject.ui.di.qualifier.LanguageSelection
import com.robin.firstkotlinproject.domain.BusImpl
import com.robin.firstkotlinproject.domain.interactor.base.Bus
import com.robin.firstkotlinproject.domain.interactor.base.CustomJobManager
import com.robin.firstkotlinproject.domain.interactor.base.InteractorExecutor
import com.robin.firstkotlinproject.domain.interactor.base.InteractorExecutorImpl
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import java.util.*
import javax.inject.Singleton

/**
 * Created by Robin Yang on 10/30/17.
 */
@Module
class ApplicationModule(private val app: App) {

    @Provides
    @Singleton
    fun provideApplication(): App = app

    @Provides
    @Singleton
    @ApplicationQualifier
    fun provideApplicatioinContext(): Context = app

    @Provides
    @Singleton
    fun provideBus(): Bus
            = BusImpl()

    @Provides
    @Singleton
    fun providePicasso(@ApplicationQualifier context: Context): Picasso
            = Picasso.Builder(context).build()

    @Provides
    @Singleton
    fun provideJobManager(@ApplicationQualifier context: Context): JobManager = CustomJobManager(context)

    @Provides
    @Singleton
    fun provideInteractorExecutor(jobManager: JobManager, bus: Bus): InteractorExecutor = InteractorExecutorImpl(jobManager, bus)

    @Provides
    @Singleton
    @LanguageSelection
    fun provideLanguageSelection(): String = Locale.getDefault().language
}