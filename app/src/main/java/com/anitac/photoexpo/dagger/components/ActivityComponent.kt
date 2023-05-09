package com.anitac.photoexpo.dagger.components


import com.anitac.photoexpo.view.DetailsActivity
import com.anitac.photoexpo.view.HomeActivity
import com.anitac.photoexpo.view.SplashActivity
import com.anitac.photoexpo.dagger.ActivityScope
import com.anitac.photoexpo.dagger.modules.ActivityModule
import dagger.Component

/**
 * @author Anita Chipkar
 */
@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {
    fun inject(splashActivity: SplashActivity)
    fun inject(homeActivity: HomeActivity)
    fun inject(detailsActivity: DetailsActivity)
}