package com.example.phonepeclone.ui.Screens.WealthScreens

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.phonepeclone.FundsScreenLayout
import com.example.phonepeclone.R
import com.example.phonepeclone.ViewModels.TopCompaniesViewModel

@Composable
fun StartWithScreen(
    topCompaniesViewModel: TopCompaniesViewModel,
)
{
    val heading = "START WITH 100"
    val semiHeading = "Top mutual funds to invest with just 100"
    val paragraphStringID = R.string.start_with_100_advertise
    val ButtonRowList = arrayListOf<String>()
    ButtonRowList.add("High Growth")
    ButtonRowList.add("No Lock-in")
    ButtonRowList.add("Long Term")
    ButtonRowList.add("For Beginners")

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
