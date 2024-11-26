package com.alberto.practica17.view

import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


// esta clase será capar de recibir las notificaciones y mediante la cual podremos manejarlas
class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        Looper.prepare()
        Handler().post() {
            Toast.makeText(baseContext, message.notification?.title, Toast.LENGTH_LONG).show()
        }
    }
}