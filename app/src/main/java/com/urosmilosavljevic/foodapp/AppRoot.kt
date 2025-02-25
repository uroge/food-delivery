package com.urosmilosavljevic.foodapp

import com.urosmilosavljevic.foodapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager

class AppRoot : Application() {
    override fun onCreate() {
        super.onCreate()

        val channel =
            NotificationChannel(
                Constants.LOCATION_CHANNEL_ID,
                "Food App Channel",
                NotificationManager.IMPORTANCE_DEFAULT,
            )

        val notificationManager = getSystemService(NotificationManager::class.java)
        notificationManager.createNotificationChannel(channel)

        startKoin {
            androidLogger()
            androidContext(this@AppRoot)
            modules(appModule)
        }
    }
}
