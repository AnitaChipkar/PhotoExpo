package com.anitac.photoexpo.rx

import io.reactivex.Scheduler
import javax.inject.Singleton

/**
 * @author Anita Chipkar
 * SchedulerProvider
 */
@Singleton
interface SchedulerProvider {

    fun computation(): Scheduler

    fun io(): Scheduler

    fun ui(): Scheduler
}