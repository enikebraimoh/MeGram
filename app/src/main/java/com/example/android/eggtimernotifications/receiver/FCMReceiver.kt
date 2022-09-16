package com.example.android.eggtimernotifications.receiver

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.android.eggtimernotifications.R
import com.example.android.eggtimernotifications.ui.IncomingCallActivity
import com.example.android.eggtimernotifications.util.inComingCallNotification
import com.example.android.eggtimernotifications.util.sendNotification

class FCMReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.d("TESTING_NOTIFICATION","it works!!!" )
        //Toast.makeText(context, "yaay!", Toast.LENGTH_SHORT).show()

        val user = intent.extras?.get("caller_name")

        val notificationManager = ContextCompat.getSystemService(
            context,
            NotificationManager::class.java
        ) as NotificationManager

        notificationManager.inComingCallNotification(user.toString(),context)

        val callIntent = Intent(context,IncomingCallActivity::class.java)

        callIntent.putExtra("2 ", user.toString())
        context.startActivity(callIntent)
    }

}