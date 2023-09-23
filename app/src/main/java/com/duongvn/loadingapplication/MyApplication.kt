package com.duongvn.loadingapplication

import android.app.Application
import android.app.Notification
import android.app.NotificationManager
import androidx.core.app.NotificationCompat


class MyApplication : Application() {

    companion object {
        const val CHANNEL_ID = "CHANNEL_ID_DOWNLOAD"
    }

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        val name  = "Channel DownLoad"
        val description = "Channel DownLoad Description"

        //Send push notification
        val notify: Notification = NotificationCompat.Builder(applicationContext, CHANNEL_ID)
            .setContentTitle(name)
            .setContentText(description)
            .setSmallIcon(R.drawable.round_cloud_download_24)
            .build()

        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(0, notify)
    }
}