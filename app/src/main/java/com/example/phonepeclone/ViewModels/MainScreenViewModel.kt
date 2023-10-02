package com.example.phonepeclone.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.phonepeclone.Data.BottomnavItem
import com.example.phonepeclone.Data.MainScreenRepository

class MainScreenViewModel : ViewModel(){

    private val mainScreenRepository:MainScreenRepository = MainScreenRepository()
    private var bottomNavBarItemList:List<BottomnavItem>? = null
    val ShowAppbar : MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }


    fun getBottomAppBarItemList():List<BottomnavItem>
    {
        if(bottomNavBarItemList == null)
        {
            bottomNavBarItemList = mainScreenRepository.getBottomAppBarItemList()
        }
        return bottomNavBarItemList as List<BottomnavItem>
    }
}