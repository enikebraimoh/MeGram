package com.example.android.eggtimernotifications.util

import android.content.Intent
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        if (remoteMessage.data.isNotEmpty()) {
            Log.d("TESTING_NOTIFICATION",remoteMessage.data.toString() )

            val intent = Intent(Intent.ACTION_ANSWER)
            intent.putExtra("caller_name", remoteMessage.data.get("caller_name"))
            sendBroadcast(intent)
        }
        else{
            Log.d("TESTING_NOTIFICATION",remoteMessage.data.toString() )
        }

    }

}