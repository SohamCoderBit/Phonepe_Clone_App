package com.example.phonepeclone.ViewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.phonepeclone.Data.WaterRepository

class WaterViewModel  : ViewModel()
{
    private val waterRepository:WaterRepository = WaterRepository()
    private var waterBillerList : List<String>? = null

    fun getWaterBillerList(context: Context) : List<String>
    {
        if(waterBillerList == null)
        {
            waterBillerList = waterRepository.getWaterBillerList(context = context)
        }
        return waterBillerList as List<String>
    }

}
