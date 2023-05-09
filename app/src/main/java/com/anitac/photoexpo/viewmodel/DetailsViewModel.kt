package com.anitac.photoexpo.viewmodel


import com.anitac.photoexpo.api.NetworkHelper
import com.anitac.photoexpo.repository.DetailsRepository
import com.anitac.photoexpo.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

/**
 * @author Anita Chipkar
 * @constructor
 * @param schedulerProvider
 * @param compositeDisposable
 * @param networkHelper
 */
class DetailsViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val detailsRepository: DetailsRepository
) : BaseViewModel(schedulerProvider, compositeDisposable,networkHelper) {

    override fun onCreate() {
    }

}