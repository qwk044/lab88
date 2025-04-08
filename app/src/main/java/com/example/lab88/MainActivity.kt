package com.example.lab8

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var reminderIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        reminderIntent = Intent(this, ReminderService::class.java)
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.button_start_reminder -> startService(reminderIntent)
            R.id.button_stop_reminder -> stopService(reminderIntent)
            R.id.button_next_activity -> {
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
            }
        }
    }
}
