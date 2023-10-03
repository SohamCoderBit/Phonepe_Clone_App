package com.example.phonepeclone.Data

import android.content.Context


class WaterRepository {
    private var waterBillerList : List<String>? = null

    fun getWaterBillerList(context : Context) : List<String>
    {
        waterBillerList = parseJson(context = context , FilePath =  "WaterBillerList.json")
        return waterBillerList as List<String>
    }

}