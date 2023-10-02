package com.example.phonepeclone.ui.Screens.WealthScreens

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.phonepeclone.FundsScreenLayout
import com.example.phonepeclone.R
import com.example.phonepeclone.ViewModels.TopCompaniesViewModel

@Composable
fun LargeCapFundsScreen(
    topCompaniesViewModel: TopCompaniesViewModel
)
{
    val heading = "LARGE CAP FUNDS"
    val semiHeading = "Invest in India's biggest companies"
    val paragraphStringID = R.string.large_cap_fund_advertise
    val ButtonRowList = arrayListOf<String>()
    ButtonRowList.add("High Growth")
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

@Composable
fun MidCapFundsScreen(
    topCompaniesViewModel: TopCompaniesViewModel
)
{
    val heading = "MID CAP FUNDS"
    val semiHeading = "Invest in fast growing companies"
    val paragraphStringID = R.string.mid_cap_fund_advertise
    val ButtonRowList = arrayListOf<String>()
    ButtonRowList.add("High Growth")
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

@Composable
fun SmallCapFundsScreen(
    topCompaniesViewModel: TopCompaniesViewModel
)
{
    val heading = "SMALL CAP FUNDS"
    val semiHeading = "Invest in tomorrow's Leaders"
    val paragraphStringID = R.string.small_cap_fund_advertise
    val ButtonRowList = arrayListOf<String>()
    ButtonRowList.add("High Growth")
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

@Composable
fun IndexFundsScreen(
    topCompaniesViewModel: TopCompaniesViewModel
)
{
    val heading = "INDEX FUNDS"
    val semiHeading = "Invest in India's top indices"
    val paragraphStringID = R.string.index_fund_advertise
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