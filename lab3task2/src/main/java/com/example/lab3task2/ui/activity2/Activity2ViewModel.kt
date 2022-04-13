package com.example.lab3task2.ui.activity2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Activity2ViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is 2 Activity"
    }
    val text: LiveData<String> = _text
}