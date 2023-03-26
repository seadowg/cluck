package com.seadowg.cluck

import android.app.Application
import com.google.android.material.color.DynamicColors

class ChickenTimerApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        DynamicColors.applyToActivitiesIfAvailable(this);
    }
}
