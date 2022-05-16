package com.crownedjester.soft.waterdrinkremainder.domain.alarm_manager

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationManagerCompat
import com.crownedjester.soft.waterdrinkremainder.R
import com.crownedjester.soft.waterdrinkremainder.presentation.MainActivity

class HydrationReceiver : BroadcastReceiver() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onReceive(context: Context?, intent: Intent?) {
        val notification: Notification.Builder
        var message = ""
        val channelId = "1029"

        if (intent?.action == "HYDRATION_ALARM") {
            message = intent.getStringExtra("key")!!
            Log.d("HydrationReceiver", message)
        }

        val pIntent =
            Intent(context, MainActivity::class.java).let {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                PendingIntent.getActivity(
                    context,
                    0,
                    it,
                    PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
                )
            }

        notification = Notification.Builder(context, channelId)
            .setSmallIcon(R.drawable.ic_big_cup)
            .setContentText(message)
            .setContentIntent(pIntent)

        with(NotificationManagerCompat.from(context!!)) {
            if (getNotificationChannel(channelId) == null)
                createNotificationChannel(
                    NotificationChannel(
                        channelId,
                        "Hydration",
                        NotificationManager.IMPORTANCE_HIGH
                    )
                )

            notify(1, notification.build())

        }


    }
}