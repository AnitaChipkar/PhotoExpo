package com.anitac.photoexpo

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.multidex.MultiDexApplication
import com.anitac.photoexpo.dagger.components.ApplicationComponent
import com.anitac.photoexpo.dagger.components.DaggerApplicationComponent
import com.anitac.photoexpo.dagger.modules.ApplicationModule
import com.anitac.photoexpo.view.BaseActivity
import com.anitac.photoexpo.viewmodel.BaseViewModel
import java.lang.ref.WeakReference

class AppApplication: MultiDexApplication(), Application.ActivityLifecycleCallbacks{
    lateinit var applicationComponent: ApplicationComponent
    var weakActivity: WeakReference<BaseActivity<BaseViewModel>>? = null
    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(this)
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }


    override fun onActivityCreated(p0: Activity, p1: Bundle?) {

    }

    override fun onActivityStarted(p0: Activity) {

    }

    override fun onActivityResumed(p0: Activity) {

    }

    override fun onActivityPaused(p0: Activity) {

    }

    override fun onActivityStopped(p0: Activity) {

    }

    override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {

    }

    override fun onActivityDestroyed(p0: Activity) {

    }
    fun getCurrentActivity(): BaseActivity<BaseViewModel>? {
        return weakActivity?.get()
    }
}