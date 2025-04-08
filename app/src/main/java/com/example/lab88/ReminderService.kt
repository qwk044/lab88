package com.example.lab8

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.widget.Toast
import java.util.*

class ReminderService : Service() {
    private val handler = Handler()
    private val messages = listOf(
        "Сделай перерыв 👀",
        "Встань, размнись 🙆‍♂️",
        "Попей воды 💧",
        "Проверь осанку 🪑",
        "Сфокусируйся 🎯"
    )

    // Интервал 15 секунд (15 * 1000)
    private val interval = 15 * 1000L

    private val reminderRunnable = object : Runnable {
        override fun run() {
            val msg = messages.random()
            Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG).show()
            handler.postDelayed(this, interval)
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        handler.post(reminderRunnable)
        return START_STICKY
    }

    override fun onDestroy() {
        handler.removeCallbacks(reminderRunnable)
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? = null
}
