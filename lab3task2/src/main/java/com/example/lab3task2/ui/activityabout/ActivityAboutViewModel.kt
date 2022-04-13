package com.example.lab3task2.ui.activityabout

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ActivityAboutViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Activity About"
    }
    val text: LiveData<String> = _text
}