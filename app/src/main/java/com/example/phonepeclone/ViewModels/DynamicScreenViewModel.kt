package com.example.phonepeclone.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DynamicScreenViewModel : ViewModel() {
    val HeadingText: MutableLiveData<String> by lazy { MutableLiveData<String>() }
}