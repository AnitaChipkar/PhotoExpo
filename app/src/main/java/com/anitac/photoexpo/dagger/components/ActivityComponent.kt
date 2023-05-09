package com.anitac.photoexpo.dagger.components


import com.anitac.photoexpo.view.DetailsActivity
import com.anitac.photoexpo.view.HomeActivity
import com.anitac.photoexpo.view.SplashActivity
import com.app.loc.dagger.ActivityScope
import com.anitac.photoexpo.dagger.modules.ActivityModule
import dagger.Component

/**
 * @author Anita Chipkar
 * @since 13/06/2022
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