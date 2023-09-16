package com.example.phonepeclone.Data

import android.content.Context


data class InsuranceRenewalBiller(val BillerName: String)
class InsuranceRenewalRepository {
    private var insuranceRenewalBillersList: List<InsuranceRenewalBiller>? = null

    fun getInsuranceRenewalBillerList(context: Context): List<InsuranceRenewalBiller> {
        insuranceRenewalBillersList = parseJson(context = context, FilePath = "InsuranceRenewalBillersList.json")
        return insuranceRenewalBillersList as List<InsuranceRenewalBiller>
    }
}