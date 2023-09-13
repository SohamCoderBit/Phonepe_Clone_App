package com.example.phonepeclone.Data

import android.content.Context


data class FundBillers(
    val FundProviderName: String,
    val Last3Year: String,
    val MinInvest: String,
    val FundSize: String
)

class TopCompaniesFundRepository {

    private var topCompaniesFundBillersList : List<FundBillers>? = null
    fun parseJson(context: Context): List<FundBillers> {
        topCompaniesFundBillersList = parseJson(context = context , "FundBillersList.json")
        return topCompaniesFundBillersList as List<FundBillers>
    }
}