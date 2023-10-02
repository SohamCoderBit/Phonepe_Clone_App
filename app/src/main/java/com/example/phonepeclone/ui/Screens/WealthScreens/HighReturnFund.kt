package com.example.phonepeclone.ui.Screens.WealthScreens

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.phonepeclone.FundsScreenLayout
import com.example.phonepeclone.R
import com.example.phonepeclone.ViewModels.TopCompaniesViewModel

@Composable
fun HighReturnsScreen(
    topCompaniesViewModel: TopCompaniesViewModel
) {

    val heading = "HIGH RETURNS FUNDS"
    val semiHeading = "Funds with strong past performance"
    val paragraphStringID = R.string.high_return_fund_advertise
    val ButtonRowList = arrayListOf<String>()
    ButtonRowList.add("High Growth")
    ButtonRowList.add("No Lock-in")
    ButtonRowList.add("Long Term")
    ButtonRowList.add("High Risk")

    val fundProviderList = topCompaniesViewModel.getFundProvidersList(LocalContext.current)
    FundsScreenLayout(
        TopBarHeading = heading,
        Heading = heading,
        SemiHeading = semiHeading,
        ParaGraphStringID = paragraphStringID,
        SmallBoxsRow = ButtonRowList,
        FundProviderList = fundProviderList
    )
}

