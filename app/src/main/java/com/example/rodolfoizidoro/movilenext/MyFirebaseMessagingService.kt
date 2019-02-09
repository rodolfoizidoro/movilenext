package com.example.rodolfoizidoro.movilenext

import android.util.Log
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    companion object {
        private const val TAG = "FCM SERVICE"
    }

    override fun onNewToken(token: String?) {
        Log.i(TAG, "Refreshed token: $token")

        val firebaseMessaging = FirebaseMessaging.getInstance()
        firebaseMessaging.subscribeToTopic("MAIN")
        firebaseMessaging.isAutoInitEnabled = true
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        val notification = remoteMessage.notification

        Log.i(TAG, "Message ID: ${remoteMessage.messageId} ")
        Log.i(TAG, "Data message: ${remoteMessage.data} ")
        Log.i(TAG, "Notification Message: $notification ")

        notification?.let {
            val title = it.title ?: "Titulo Default"
            val body = it.body ?: "Descricao default"
            val data = remoteMessage.data

            Log.i(TAG, "Notification Title $title ")
            Log.i(TAG, "Notification body $body ")
            Log.i(TAG, "Notification data $data ")

            NotificationCreation.create(this, title, body)
        }

    }
}
