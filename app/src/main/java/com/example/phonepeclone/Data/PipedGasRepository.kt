package com.example.phonepeclone.Data

import android.content.Context

data class PipedGasBiller(val BillerName:String)
class PipedGasRepository{
    private var pipedGasBillerList: List<PipedGasBiller>?= null

    fun getPipedGasBillerList(context: Context) : List<PipedGasBiller>
    {
        pipedGasBillerList = parseJson(context =  context , FilePath =  "PipedgasBillerList.json")
        return pipedGasBillerList as List<PipedGasBiller>
    }


}