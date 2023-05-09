package com.anitac.photoexpo.dagger

import javax.inject.Qualifier

/**
 * @author Anita Chipkar
 * @since 13/06/2022
 */
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ApplicationContext

@Qualifier
@Retention(AnnotationRetention.SOURCE)
annotation class ActivityContext