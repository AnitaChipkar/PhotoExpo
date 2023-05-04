package com.anitac.photoexpo.dagger.components

import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.anitac.photoexpo.AppApplication
import com.anitac.photoexpo.api.NetworkHelper
import com.anitac.photoexpo.api.NetworkService
import com.app.loc.dagger.ApplicationContext
import com.anitac.photoexpo.dagger.modules.ApplicationModule
import com.app.loc.commonUtils.rx.SchedulerProvider
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

/**
 * @author Anita Chipkar
 * @since 13/06/2022
 */
@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(app: AppApplication)

    fun getApplication(): Application

    @ApplicationContext
    fun getContext(): Context

     fun getNetworkService(): NetworkService

     fun getNetworkHelper(): NetworkHelper

     fun getSchedulerProvider(): SchedulerProvider

    fun getCompositeDisposable(): CompositeDisposable

    fun getAlertDialogBuilder(): AlertDialog.Builder

    fun getLayoutInflater(): LayoutInflater
}