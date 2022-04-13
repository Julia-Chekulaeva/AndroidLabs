package com.example.lab2continuewatch1

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
        const val SAVED_SECONDS_ELAPSED ="savedSecondsElapsed"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            putInt(SAVED_SECONDS_ELAPSED, secondsElapsed)
        }
        super.onSaveInstanceState(outState)
        Log.i("test", "on Save Instance State")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i("test", "on Restore Instance State")
        savedInstanceState.run {
            secondsElapsed = getInt(SAVED_SECONDS_ELAPSED)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("test", "on Start")
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
        countingEnabled = false
        super.onStop()
        Log.i("test", "on Stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("test", "on Destroy")
    }
}
