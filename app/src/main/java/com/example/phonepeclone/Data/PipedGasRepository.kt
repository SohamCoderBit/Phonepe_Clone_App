package com.example.phonepeclone.Data

import android.content.Context

class PipedGasRepository{
    private var pipedGasBillerList: List<String>?= null

    fun getPipedGasBillerList(context: Context) : List<String>
    {
        pipedGasBillerList = parseJson(context =  context , FilePath =  "PipedgasBillerList.json")
        return pipedGasBillerList as List<String>
    }


}