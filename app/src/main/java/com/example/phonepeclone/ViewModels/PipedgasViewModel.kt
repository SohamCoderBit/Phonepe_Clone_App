package com.example.phonepeclone.ViewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.phonepeclone.Data.PipedGasBiller
import com.example.phonepeclone.Data.PipedGasRepository

class PipedgasViewModel : ViewModel(){
    private val pipedGasRepository : PipedGasRepository = PipedGasRepository()
    private var pipedgasBillerList : List<PipedGasBiller>? = null

    fun getPipedGasBillerList(context: Context) : List<PipedGasBiller>
    {
        if(pipedgasBillerList == null)
        {
            pipedgasBillerList = pipedGasRepository.getPipedGasBillerList(context = context)
        }
        return pipedgasBillerList as List<PipedGasBiller>
    }
}