package com.example.lab8

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity2 : AppCompatActivity() {
    private lateinit var musicServiceIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        musicServiceIntent = Intent(this, MusicForegroundService::class.java)
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.button_music_start -> ContextCompat.startForegroundService(this, musicServiceIntent)
            R.id.button_music_stop -> stopService(musicServiceIntent)
        }
    }
}
