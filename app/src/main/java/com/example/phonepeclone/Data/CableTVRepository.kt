package com.example.phonepeclone.Data

import android.content.Context

class CableTVRepository {
    private var cableTVBillerList : List<String>? = null

    fun getCableTVBillerList(context: Context): List<String> {
        cableTVBillerList = parseJson(context , FilePath = "CableTvBillerList.json")
        return cableTVBillerList as List<String>
    }
}