package com.example.lab2continuewatch2

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var secondsElapsed: Int = 0
    lateinit var textSecondsElapsed: TextView
    var countingEnabled: Boolean = true

    var backgroundThread = Thread {
        while (countingEnabled) {
            Thread.sleep(1000)
            textSecondsElapsed.post {
                textSecondsElapsed.text = "Seconds elapsed: " + secondsElapsed++
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("test", "on Create")
        setContentView(R.layout.activity_main)
        textSecondsElapsed = findViewById(R.id.textSecondsElapsed)
    }

    companion object {
        const val SAVED_SECONDS_ELAPSED = "savedSecondsElapsed"
    }

    override fun onStart() {
        super.onStart()
        Log.i("test", "on Start")
        secondsElapsed = getPreferences(Context.MODE_PRIVATE).getInt(
            SAVED_SECONDS_ELAPSED, 0
        )
        countingEnabled = true
        backgroundThread.start()
    }

    override fun onResume() {
        super.onResume()
        Log.i("test", "on Resume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("test", "on Pause")
    }

    override fun onStop() {
        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        with (sharedPref.edit()) {
            putInt(SAVED_SECONDS_ELAPSED, secondsElapsed)
            apply()
        }
        countingEnabled = false
        super.onStop()
        Log.i("test", "on Stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("test", "on Destroy")
    }
}
