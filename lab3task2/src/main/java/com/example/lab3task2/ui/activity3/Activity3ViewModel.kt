package com.example.lab3task2.ui.activity3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Activity3ViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is 3 Activity"
    }
    val text: LiveData<String> = _text
}