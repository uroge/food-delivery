package com.urosmilosavljevic.foodapp

import com.urosmilosavljevic.foodapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import android.app.Application

class AppRoot : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@AppRoot)
            modules(appModule)
        }
    }
}
