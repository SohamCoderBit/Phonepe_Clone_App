package com.example.phonepeclone.ViewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.phonepeclone.Data.PipedGasRepository

class PipedgasViewModel : ViewModel(){
    private val pipedGasRepository : PipedGasRepository = PipedGasRepository()
    private var pipedgasBillerList : List<String>? = null

    fun getPipedGasBillerList(context: Context) : List<String>
    {
        if(pipedgasBillerList == null)
        {
            pipedgasBillerList = pipedGasRepository.getPipedGasBillerList(context = context)
        }
        return pipedgasBillerList as List<String>
    }
}