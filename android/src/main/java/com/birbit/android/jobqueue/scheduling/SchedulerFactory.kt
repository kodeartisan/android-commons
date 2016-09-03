package com.birbit.android.jobqueue.scheduling

import android.content.Context

/**
 * @author Eugen on 23.08.2016.
 */
object SchedulerFactory {

    @JvmStatic
    fun createSchedulerForGcmJobSchdulerService(appContext: Context, klass: Class<out GcmJobSchedulerService>): Scheduler {
        return GcmJobSchedulerService.createSchedulerFor(appContext, klass)
    }

    @JvmStatic
    fun createSchedulerForFrameworkJobSchedulerService(appContext: Context, klass: Class<out FrameworkJobSchedulerService>): Scheduler {
        return FrameworkJobSchedulerService.createSchedulerFor(appContext, klass)
    }

}
