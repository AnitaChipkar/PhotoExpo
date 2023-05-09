package com.anitac.photoexpo.viewmodel


import androidx.lifecycle.ViewModel
import com.anitac.photoexpo.api.NetworkHelper
import com.anitac.photoexpo.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

/**
 * @author Anita Chipkar
 */
abstract class BaseViewModel(
    protected val schedulerProvider: SchedulerProvider,
    protected val compositeDisposable: CompositeDisposable,
    protected val networkHelper: NetworkHelper
) : ViewModel() {

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
    protected fun checkInternetConnection(): Boolean = networkHelper.isNetworkConnected()
    abstract fun onCreate()

}