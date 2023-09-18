package com.example.phonepeclone.ViewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.phonepeclone.Data.FundBillers
import com.example.phonepeclone.Data.TopCompaniesFundRepository

class TopCompaniesViewModel : ViewModel(){

    private val fundProviderRepository:TopCompaniesFundRepository = TopCompaniesFundRepository()
    private var internalName:String = "ICICI Prudential Bluechip Fund"
    private var loanFundProviderList:List<FundBillers>? = null

    fun getFundProvidersList(context: Context ):List<FundBillers>{
        if(loanFundProviderList == null)
        {
            loanFundProviderList = fundProviderRepository.parseJson(context = context)
        }
        return loanFundProviderList as List<FundBillers>
    }
}