package com.anitac.photoexpo.dagger.modules

import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.anitac.photoexpo.AppApplication
import com.anitac.photoexpo.api.NetworkService
import com.anitac.photoexpo.api.Networking
import com.app.loc.commonUtils.rx.RxSchedulerProvider
import com.app.loc.commonUtils.rx.SchedulerProvider
import com.app.loc.dagger.ApplicationContext
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

/**
 * @author Anita Chipkar
 * @since 13/06/2022
 * @property application
 */
@Module
class ApplicationModule(private val application: AppApplication) {

    @Provides
    @Singleton
    fun provideApplication(): Application = application

    @Provides
    @Singleton
    @ApplicationContext
    fun provideContext(): Context = application
    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = RxSchedulerProvider()
    /**
     * We need to write @Singleton on the provide method if we are create the instance inside this method
     * to make it singleton. Even if we have written @Singleton on the instance's class
     */
    @Provides
    @Singleton
    fun provideNetworkService(): NetworkService =
        Networking.create(
            "",
            "",
            application
        )

   /* @Singleton
    @Provides
    fun provideNetworkHelper(): NetworkHelper = NetworkHelper(application)
*/
    @Provides
    fun provideAlertDialogBuilder(): AlertDialog.Builder = AlertDialog.Builder(application)

    @Provides
    fun provideLayoutInflater(): LayoutInflater = LayoutInflater.from(application)

}