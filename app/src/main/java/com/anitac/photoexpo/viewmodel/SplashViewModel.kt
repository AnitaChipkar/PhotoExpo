package com.anitac.photoexpo.viewmodel


import com.anitac.photoexpo.repository.SplashRepository
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
class SplashViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    private val splashRepository: SplashRepository
) : BaseViewModel(schedulerProvider, compositeDisposable) {


    override fun onCreate() {
        //checkForInternetConnection()
       // deviceToken = AppineersApplication.sharedPreference.deviceToken ?: ""
    }
  /*  val configParamsPhoneLiveData = MutableLiveData<TAListResponse<VersionConfigResponse>>()
    val checkForInternetConnectionLiveData = MutableLiveData<Boolean>()
    var deviceToken : String = ""





    private fun checkForInternetConnection() {
        when {
            checkInternetConnection() -> checkForInternetConnectionLiveData.postValue(true)
            else -> checkForInternetConnectionLiveData.postValue(false)
        }
    }*/

   /* fun callGetConfigParameters() {
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
    }
*/

}