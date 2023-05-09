package com.anitac.photoexpo.viewmodel


import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.anitac.photoexpo.ImageList
import com.anitac.photoexpo.api.NetworkHelper
import com.anitac.photoexpo.repository.HomeRepository
import com.anitac.photoexpo.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

/**
 * @author Anita Chipkar
 * @constructor
 * @param schedulerProvider
 * @param compositeDisposable
 * @param networkHelper
 */
class HomeViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val homeRepository: HomeRepository
) : BaseViewModel(schedulerProvider, compositeDisposable,networkHelper) {
    val checkForInternetConnectionLiveData = MutableLiveData<Boolean>()
    var imageListLiveData = MutableLiveData<ArrayList<ImageList>>()

    override fun onCreate() {
        checkForInternetConnection()
    }

    private fun checkForInternetConnection() {
        when {
            checkInternetConnection() -> checkForInternetConnectionLiveData.postValue(true)
            else -> checkForInternetConnectionLiveData.postValue(false)
        }
    }

    fun callGetImageList() {
        compositeDisposable.addAll(
            homeRepository.callImageList()
                .subscribeOn(schedulerProvider.io())
                .subscribe(
                    { response ->
                        imageListLiveData.postValue(response)
                    },
                    { error ->
                     Log.i("TAG",error.message.toString())
                    }
                )
        )
    }



}