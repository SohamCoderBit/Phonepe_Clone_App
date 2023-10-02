package com.example.phonepeclone.ViewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.phonepeclone.Data.CableTVRepository
import com.example.phonepeclone.Data.CableTvBiller

class CableTvViewModel : ViewModel() {
    private val cableTVRepository : CableTVRepository = CableTVRepository()
    private var cableTvBillerList : List<CableTvBiller>? = null
    fun getList(context: Context) : List<CableTvBiller>
    {
        if(cableTvBillerList == null)
        {
            cableTvBillerList =  cableTVRepository.getCableTVBillerList(context = context)
        }
        return cableTvBillerList as List<CableTvBiller>
    }
}