package com.anitac.photoexpo

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.multidex.MultiDexApplication
import com.anitac.photoexpo.dagger.components.ApplicationComponent
import com.anitac.photoexpo.dagger.components.DaggerApplicationComponent
import com.anitac.photoexpo.dagger.modules.ApplicationModule

class AppApplication: MultiDexApplication(), Application.ActivityLifecycleCallbacks{
    lateinit var applicationComponent: ApplicationComponent
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
        TODO("Not yet implemented")
    }

    override fun onActivityStarted(p0: Activity) {
        TODO("Not yet implemented")
    }

    override fun onActivityResumed(p0: Activity) {
        TODO("Not yet implemented")
    }

    override fun onActivityPaused(p0: Activity) {
        TODO("Not yet implemented")
    }

    override fun onActivityStopped(p0: Activity) {
        TODO("Not yet implemented")
    }

    override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {
        TODO("Not yet implemented")
    }

    override fun onActivityDestroyed(p0: Activity) {
        TODO("Not yet implemented")
    }

}