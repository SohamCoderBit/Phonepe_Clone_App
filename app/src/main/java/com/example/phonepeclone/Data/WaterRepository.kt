package com.example.phonepeclone.Data

import android.content.Context

data class WaterBiller(val BillerName : String)
class WaterRepository {
    private var waterBillerList : List<WaterBiller>? = null

    fun getWaterBillerList(context : Context) : List<WaterBiller>
    {
        waterBillerList = parseJson(context = context , FilePath =  "WaterBillerList.json")
        return waterBillerList as List<WaterBiller>
    }

}