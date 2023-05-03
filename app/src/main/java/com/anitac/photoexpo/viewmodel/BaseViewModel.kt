package com.anitac.photoexpo.viewmodel


import androidx.lifecycle.ViewModel
import com.app.loc.commonUtils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel(
    protected val schedulerProvider: SchedulerProvider,
    protected val compositeDisposable: CompositeDisposable
) : ViewModel() {

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    /*val messageStringId: MutableLiveData<Resource<Int>> = MutableLiveData()
    val messageString: MutableLiveData<Resource<String>> = MutableLiveData()
    val showDialog: MutableLiveData<Boolean> = MutableLiveData()
    val validationObserver : MutableLiveData<ValidationResult> = MutableLiveData()
    var statusCodeLiveData = MutableLiveData<ServerError>()


    protected fun checkInternetConnection(): Boolean = NetworkHelper.isNetworkConnected()
    protected fun handleServerError(error: Throwable?,apiCode:Int=0): ServerError {
        var serverError= ServerError()
        error?.let {
            NetworkHelper.castToServerError(it).run {
                *//**
                 * @author Anita Chipkar
                 *  Handle apiCode with the unique int value if need to handle 2,3 response codes
                 *//*
                serverError.apiCode=apiCode
                serverError = this
            }
        }
        return serverError
    }
*/
    abstract fun onCreate()

}