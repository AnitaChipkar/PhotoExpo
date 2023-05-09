package com.anitac.photoexpo.viewmodel


import com.anitac.photoexpo.api.NetworkHelper
import com.anitac.photoexpo.repository.SplashRepository
import com.anitac.photoexpo.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

/**
 * @author Anita Chipkar
 * Splash view model
 * @property splashRepository
 * @constructor
 * @param schedulerProvider
 * @param compositeDisposable
 * @param networkHelper
 */
class SplashViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val splashRepository: SplashRepository
) : BaseViewModel(schedulerProvider, compositeDisposable,networkHelper) {


    override fun onCreate() {

    }
}