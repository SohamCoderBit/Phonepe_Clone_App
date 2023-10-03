package com.example.phonepeclone.ViewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.phonepeclone.Data.CableTVRepository

class CableTvViewModel : ViewModel() {
    private val cableTVRepository : CableTVRepository = CableTVRepository()
    private var cableTvBillerList : List<String>? = null
    fun getList(context: Context) : List<String>
    {
        if(cableTvBillerList == null)
        {
            cableTvBillerList =  cableTVRepository.getCableTVBillerList(context = context)
        }
        return cableTvBillerList as List<String>
    }
}