package com.example.phonepeclone.ViewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.phonepeclone.Data.FundBillers
import com.example.phonepeclone.Data.TaxSavingFundRepository

class TaxSavingFundViewModel : ViewModel() {
    private val taxSavingFundRepository:TaxSavingFundRepository = TaxSavingFundRepository()

    private var taxSavingFundBillersList: List<FundBillers>? = null

    fun getTaxSavingFundBillersList(context: Context) : List<FundBillers>
    {
        if(taxSavingFundBillersList == null)
        {
            taxSavingFundBillersList = taxSavingFundRepository.parseJson(context = context)
        }
        return taxSavingFundBillersList as List<FundBillers>
    }
}