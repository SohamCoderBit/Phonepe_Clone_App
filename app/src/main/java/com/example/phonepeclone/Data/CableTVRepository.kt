package com.example.phonepeclone.Data

import android.content.Context

data class CableTvBiller(val BillerName : String)
class CableTVRepository {
    private var cableTVBillerList : List<CableTvBiller>? = null

    fun getCableTVBillerList(context: Context): List<CableTvBiller> {
        cableTVBillerList = parseJson(context , FilePath = "CableTvBillerList.json")
        return cableTVBillerList as List<CableTvBiller>
    }
}