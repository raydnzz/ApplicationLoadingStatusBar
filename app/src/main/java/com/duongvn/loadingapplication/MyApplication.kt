package com.duongvn.loadingapplication

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build


class MyApplication : Application() {

    companion object {
        const val CHANNEL_ID = "CHANNEL_ID_DOWNLOAD"
    }

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val name  = "Channel DownLoad"
            val description = "Channel DownLoad Description"
            val importance = NotificationManager.IMPORTANCE_MIN
            val channel = NotificationChannel(CHANNEL_ID, name, importance)
            channel.description = description
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }

    }
}
