package com.example.phonepeclone.ViewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.phonepeclone.Data.InsuranceRenewalBiller
import com.example.phonepeclone.Data.InsuranceRenewalRepository

class InsuranceRenewalViewModel: ViewModel() {
    private val insuranceRenewalRepository:InsuranceRenewalRepository = InsuranceRenewalRepository()
    private var insuranceRenewalBillersList:List<InsuranceRenewalBiller>? = null

    fun getInsuranceRenewalBillersList(context: Context):List<InsuranceRenewalBiller>
    {
        if(insuranceRenewalBillersList == null)
        {
            insuranceRenewalBillersList = insuranceRenewalRepository.getInsuranceRenewalBillerList(context = context)
        }
        return insuranceRenewalBillersList as List<InsuranceRenewalBiller>
    }

}