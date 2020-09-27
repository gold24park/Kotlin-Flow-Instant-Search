package com.gold24park.instantsearch

import android.app.Application
import com.gold24park.instantsearch.di.module
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Dependency Injection
        startKoin {
            androidContext(this@BaseApplication)
            modules(module)
        }
    }
}