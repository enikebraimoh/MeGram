/*
 * Copyright (C) 2019 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.eggtimernotifications.util

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.example.android.eggtimernotifications.MainActivity
import com.example.android.eggtimernotifications.R
import com.example.android.eggtimernotifications.receiver.SnoozeReceiver

// Notification ID.
private val NOTIFICATION_ID = 0
private val CALLS_NOTIFICATION_ID = 1
private val REQUEST_CODE = 0
private val FLAGS = 0

// TODO: Step 1.1 extension function to send messages (GIVEN)
/**
 * Builds and delivers the notification.
 *
 * @param context, activity context.
 */
fun NotificationManager.sendNotification(messageBody: String, applicationContext: Context) {
    // Create the content intent for the notification, which launches
    // this activity
    // TODO: Step 1.11 create intent
    val intent = Intent(applicationContext, MainActivity::class.java)

    // TODO: Step 1.12 create PendingIntent
    val pendingIntent = PendingIntent.getActivity(
        applicationContext,
        NOTIFICATION_ID,
        intent,
        PendingIntent.FLAG_UPDATE_CURRENT
    )

    // TODO: Step 2.0 add style
    val eggImage = BitmapFactory.decodeResource(
        applicationContext.resources,
        R.drawable.cooked_egg
    )

    val bigPicStyle = NotificationCompat.BigPictureStyle()
        .bigPicture(eggImage)
        .bigLargeIcon(null)

    // TODO: Step 2.2 add snooze action

    val snoozeIntent = Intent(applicationContext, SnoozeReceiver::class.java)
    val snoozePendingIntent: PendingIntent = PendingIntent.getBroadcast(
        applicationContext,
        REQUEST_CODE,
        snoozeIntent,
        PendingIntent.FLAG_ONE_SHOT
    )

    // TODO: Step 1.2 get an instance of NotificationCompat.Builder
    // Build the notification
    var builder = NotificationCompat.Builder(
        applicationContext,
        applicationContext.getString(R.string.egg_notification_channel_id)
    )

        // TODO: Step 1.8 use the new 'breakfast' notification channel

        // TODO: Step 1.3 set title, text and icon to builder
        .setContentTitle(applicationContext.getString(R.string.notification_title))
        .setSmallIcon(R.drawable.egg_icon)
        .setContentText(messageBody)
        .setStyle(bigPicStyle)
        .setLargeIcon(eggImage)
        .setContentIntent(pendingIntent)
        .setAutoCancel(true)

    // TODO: Step 1.13 set content intent

    // TODO: Step 2.1 add style to builder

    // TODO: Step 2.3 add snooze action
        .addAction(
            R.drawable.egg_icon,
            applicationContext.getString(R.string.snooze),
            snoozePendingIntent
        )

    // TODO: Step 2.5 set priority

    // TODO: Step 1.4 call notify
    notify(NOTIFICATION_ID, builder.build())
}



fun NotificationManager.inComingCallNotification(callerName : String, context: Context){

    val eggImage = BitmapFactory.decodeResource(
        context.resources,
        R.drawable.cooked_egg
    )

    var builder = NotificationCompat.Builder(
        context,
        context.getString(R.string.calls_channel_id)
    )
        .setContentTitle(callerName)
        .setContentText("Incoming Call")
        .setLargeIcon(eggImage)
        .setSmallIcon(R.drawable.egg_icon)



    notify(CALLS_NOTIFICATION_ID,builder.build())

}

// TODO: Step 1.14 Cancel all notifications
fun NotificationManager.cancelNotifications() {
    cancelAll()
}