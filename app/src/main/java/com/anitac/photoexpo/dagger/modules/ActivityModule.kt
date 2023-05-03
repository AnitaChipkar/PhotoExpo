package com.anitac.photoexpo.dagger.modules


import androidx.lifecycle.ViewModelProviders
import com.anitac.photoexpo.repository.DetailsRepository
import com.anitac.photoexpo.repository.HomeRepository
import com.anitac.photoexpo.repository.SplashRepository
import com.anitac.photoexpo.view.BaseActivity
import com.anitac.photoexpo.viewmodel.DetailsViewModel
import com.anitac.photoexpo.viewmodel.HomeViewModel
import com.anitac.photoexpo.viewmodel.SplashViewModel
import com.anitac.photoexpo.viewmodel.ViewModelProviderFactory
import com.app.loc.commonUtils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable


/**
 * @author Anita Chipkar
 * @since 13/06/2022
 * @property activity
 */
@Module
class ActivityModule(private val activity: BaseActivity<*>) {

    @Provides
    fun provideSplashViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        splashRepository: SplashRepository
    ): SplashViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(
            SplashViewModel::
            class
        ) {
            SplashViewModel(
                schedulerProvider,
                compositeDisposable,
                splashRepository
            )
        })[SplashViewModel::class.java]

    @Provides
    fun provideHomeViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        homeRepository: HomeRepository
    ): HomeViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(
            HomeViewModel::
            class
        ) {
            HomeViewModel(
                schedulerProvider,
                compositeDisposable,
                homeRepository
            )
        })[HomeViewModel::class.java]

    @Provides
    fun provideDetailsViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        detailsRepository: DetailsRepository
    ): DetailsViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(
            DetailsViewModel::
            class
        ) {
            DetailsViewModel(
                schedulerProvider,
                compositeDisposable,
                detailsRepository
            )
        })[DetailsViewModel::class.java]
}