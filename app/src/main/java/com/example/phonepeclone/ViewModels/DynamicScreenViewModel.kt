package com.example.phonepeclone.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DynamicScreenViewModel : ViewModel() {
    val HeadingText: MutableLiveData<String> by lazy { MutableLiveData<String>() }
}

class DynamicScrennViewModelFactory: ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DynamicScreenViewModel::class.java))
        {
            println("creating the DynamicScreenViewModel")
            return DynamicScreenViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}