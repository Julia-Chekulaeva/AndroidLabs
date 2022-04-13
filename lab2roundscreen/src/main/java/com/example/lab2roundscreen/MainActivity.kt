package com.example.lab2roundscreen

import android.os.Bundle
import android.util.Log
import android.view.animation.AnimationUtils
import android.view.animation.RotateAnimation
import androidx.appcompat.app.AppCompatActivity
import com.example.lab2roundscreen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("test", "on Create")
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.button.setOnClickListener {
            Log.i("test", "Button Pressed")
        }
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        Log.i("test", "on Start")
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
        super.onStop()
        Log.i("test", "on Stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("test", "on Destroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("test", "on Restart")
    }
}