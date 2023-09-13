package com.example.phonepeclone.ViewModels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.phonepeclone.Data.BottomnavItem
import com.example.phonepeclone.Data.MainScreenRepository

class MainScreenViewModel : ViewModel(){

    private val mainScreenRepository:MainScreenRepository = MainScreenRepository()
    private var bottomNavBarItemList:List<BottomnavItem>? = null

    var isSurfaceVisible = mutableStateOf(true)

    fun getBottomAppBarItemList():List<BottomnavItem>
    {
        if(bottomNavBarItemList == null)
        {
            bottomNavBarItemList = mainScreenRepository.getBottomAppBarItemList()
        }
        return bottomNavBarItemList as List<BottomnavItem>
    }
}