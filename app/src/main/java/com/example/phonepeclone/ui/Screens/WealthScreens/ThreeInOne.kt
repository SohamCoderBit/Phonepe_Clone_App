package com.example.phonepeclone.ui.Screens.WealthScreens

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.phonepeclone.FundsScreenLayout
import com.example.phonepeclone.R
import com.example.phonepeclone.ViewModels.DynamicScreenViewModel
import com.example.phonepeclone.ViewModels.TopCompaniesViewModel

@Composable
fun ThreeInOneScreen(
    topCompaniesViewModel: TopCompaniesViewModel,
    dynamicScreenViewModel: DynamicScreenViewModel
)
{
    val heading = " 3-IN-1 FUNDS"
    val semiHeading = "A mix of Equity , Debt and Gold in one fund"
    val paragraphStringID = R.string.three_in_one_fund_advertise
    val ButtonRowList = arrayListOf<String>()
    ButtonRowList.add("For Beginners")
    ButtonRowList.add("Diversified")
    ButtonRowList.add("No Lock-in")
    ButtonRowList.add("Long Term")

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
