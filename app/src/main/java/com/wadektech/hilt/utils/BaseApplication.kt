package com.wadektech.hilt.utils

import android.app.Application
import timber.log.Timber

class BaseApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}