package com.example.phonepeclone.ui.Screens.WealthScreens

import androidx.compose.runtime.Composable
import com.example.phonepeclone.R
import com.example.phonepeclone.ViewModels.DynamicScreenViewModel
import com.example.phonepeclone.ViewModels.TopCompaniesViewModel

@Composable
fun BestSIPFundsScreen(
    topCompaniesViewModel: TopCompaniesViewModel,
    dynamicScreenViewModel: DynamicScreenViewModel
) {

    val heading = "BEST SIP FUNDS"
    val semiHeading = "Invest in Funds with strong SIP Performance"
    val paragraphStringID = R.string.best_sip_fund_advertise
    val ButtonRowList = arrayListOf<String>()
    ButtonRowList.add("High Growth")
    ButtonRowList.add("No Lock-in")
    ButtonRowList.add("Long Term")
    ButtonRowList.add("For Beginners")

}

