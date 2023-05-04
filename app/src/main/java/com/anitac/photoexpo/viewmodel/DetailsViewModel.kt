package com.anitac.photoexpo.viewmodel


import com.anitac.photoexpo.api.NetworkHelper
import com.anitac.photoexpo.repository.DetailsRepository
import com.app.loc.commonUtils.rx.SchedulerProvider
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
class DetailsViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val detailsRepository: DetailsRepository
) : BaseViewModel(schedulerProvider, compositeDisposable,networkHelper) {

   /* val configParamsPhoneLiveData = MutableLiveData<TAListResponse<VersionConfigResponse>>()
    val checkForInternetConnectionLiveData = MutableLiveData<Boolean>()
    var deviceToken : String = ""
*/

    override fun onCreate() {
       // checkForInternetConnection()
       // deviceToken = AppineersApplication.sharedPreference.deviceToken ?: ""
    }


   /* private fun checkForInternetConnection() {
        when {
            checkInternetConnection() -> checkForInternetConnectionLiveData.postValue(true)
            else -> checkForInternetConnectionLiveData.postValue(false)
        }
    }
    fun callGetConfigParameters() {
        compositeDisposable.addAll(
            splashRepository.callConfigParameters()
                .subscribeOn(schedulerProvider.io())
                .subscribe(
                    { response ->
                        configParamsPhoneLiveData.postValue(response)
                    },
                    { error ->
                        statusCodeLiveData.postValue(handleServerError(error))
                    }
                )
        )
    }*/


}