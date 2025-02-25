package com.urosmilosavljevic.foodapp.services

import androidx.core.app.NotificationCompat
import com.urosmilosavljevic.foodapp.Constants
import android.app.Service
import android.content.Intent
import android.os.IBinder

class LocationService : Service() {
    override fun onBind(p0: Intent?): IBinder? = null

    override fun onStartCommand(
        intent: Intent?,
        flags: Int,
        startId: Int,
    ): Int {
        when (intent?.action) {
            Actions.START.name -> {
                startService()
            }
            Actions.STOP.name -> {
                stopSelf()
            }
        }

        return super.onStartCommand(intent, flags, startId)
    }

    private fun startService() {
        val notification =
            NotificationCompat
                .Builder(this, Constants.LOCATION_CHANNEL_ID)
                .setContentTitle("Location Service")
                .setContentText("Location Service is running")
                .setSmallIcon(android.R.drawable.ic_dialog_map)
                .build()

        startForeground(1, notification)
    }

    enum class Actions {
        START,
        STOP,
    }
}
