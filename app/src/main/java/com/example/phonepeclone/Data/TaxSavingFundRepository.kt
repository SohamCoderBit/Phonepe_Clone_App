package com.example.phonepeclone.Data

import android.content.Context

class TaxSavingFundRepository {
    private var taxSavingFundBillersList:List<FundBillers>? = null
    fun parseJson(context: Context) : List<FundBillers>
    {
        taxSavingFundBillersList = parseJson(context = context , "TaxSavingFundBillersList.json")
        return taxSavingFundBillersList as List<FundBillers>
    }
}