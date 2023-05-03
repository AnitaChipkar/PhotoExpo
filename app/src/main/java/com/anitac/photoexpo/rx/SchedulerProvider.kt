package com.app.loc.commonUtils.rx

import io.reactivex.Scheduler
import javax.inject.Singleton

/**
 * @author Anita Chipkar
 * @since 13/06/2022
 * SchedulerProvider
 */
@Singleton
interface SchedulerProvider {

    fun computation(): Scheduler

    fun io(): Scheduler

    fun ui(): Scheduler
}