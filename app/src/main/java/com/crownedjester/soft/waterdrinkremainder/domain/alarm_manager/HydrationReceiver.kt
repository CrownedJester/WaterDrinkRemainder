package com.crownedjester.soft.waterdrinkremainder.domain.alarm_manager

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.crownedjester.soft.waterdrinkremainder.R

class HydrationReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val notification: NotificationCompat.Builder
        var message = ""
        val channelId = "1029"

        if (intent?.action == "HYDRATION_ALARM") {
            message = intent.getStringExtra("key")!!
            Log.d("HydrationReceiver", message)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && context != null) {
            notification = NotificationCompat.Builder(context, channelId)
                .setSmallIcon(R.drawable.ic_big_cup)
                .setContentText(message)

        }else{
            notification = NotificationCompat.Builder(context!!)
        }
        with(NotificationManagerCompat.from(context!!)) {
            if (getNotificationChannel(channelId) == null)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    createNotificationChannel(
                        NotificationChannel(
                            channelId,
                            "Hydration",
                            NotificationManager.IMPORTANCE_HIGH
                        )
                    )
                }

            notify(1, notification.build())

        }


    }

}