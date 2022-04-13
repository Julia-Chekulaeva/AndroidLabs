package com.example.lab3task2.ui.activity1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Activity1ViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is 1 Activity"
    }
    val text: LiveData<String> = _text
}