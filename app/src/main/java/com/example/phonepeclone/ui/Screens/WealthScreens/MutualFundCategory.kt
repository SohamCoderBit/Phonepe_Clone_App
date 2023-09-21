package com.example.phonepeclone.ui.Screens.WealthScreens

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.phonepeclone.FundsScreenLayout
import com.example.phonepeclone.FundsSurface
import com.example.phonepeclone.R
import com.example.phonepeclone.ViewModels.DynamicScreenViewModel
import com.example.phonepeclone.ViewModels.TopCompaniesViewModel

@Composable
fun LargeCapFundsScreen(
    topCompaniesViewModel: TopCompaniesViewModel,
    dynamicScreenViewModel: DynamicScreenViewModel
)
{
    val heading = "LARGE CAP FUNDS"
    val semiHeading = "Invest in India's biggest companies"
    val paragraphStringID = R.string.large_cap_fund_advertise
    val ButtonRowList = arrayListOf<String>()
    ButtonRowList.add("High Growth")
    ButtonRowList.add("No Lock-in")
    ButtonRowList.add("Long Term")

    FundsScreenLayout(
        TopBarHeading = "Large Cap Funds",
        Heading = heading,
        SemiHeading = semiHeading,
        ParaGraphStringID = paragraphStringID,
        SmallBoxsRow = ButtonRowList,
        Content = {
            topCompaniesViewModel.getFundProvidersList(LocalContext.current)
                .forEach { fundBillers ->
                    FundsSurface(
                        FundProvider = fundBillers,
                        SurfaceOnClick = {
                            dynamicScreenViewModel.HeadingText.value = fundBillers.FundProviderName
                        }
                    )
                }
        }
    )
}

@Composable
fun MidCapFundsScreen(
    topCompaniesViewModel: TopCompaniesViewModel,
    dynamicScreenViewModel: DynamicScreenViewModel
)
{
    val heading = "MID CAP FUNDS"
    val semiHeading = "Invest in fast growing companies"
    val paragraphStringID = R.string.mid_cap_fund_advertise
    val ButtonRowList = arrayListOf<String>()
    ButtonRowList.add("High Growth")
    ButtonRowList.add("No Lock-in")
    ButtonRowList.add("Long Term")

    FundsScreenLayout(
        TopBarHeading = "Mid Cap Funds",
        Heading = heading,
        SemiHeading = semiHeading,
        ParaGraphStringID = paragraphStringID,
        SmallBoxsRow = ButtonRowList,
        Content = {
            topCompaniesViewModel.getFundProvidersList(LocalContext.current)
                .forEach { fundBillers ->
                    FundsSurface(
                        FundProvider = fundBillers,
                        SurfaceOnClick = {
                            dynamicScreenViewModel.HeadingText.value = fundBillers.FundProviderName

                        }
                    )
                }
        }
    )
}

@Composable
fun SmallCapFundsScreen(
    topCompaniesViewModel: TopCompaniesViewModel,
    dynamicScreenViewModel: DynamicScreenViewModel
)
{
    val heading = "SMALL CAP FUNDS"
    val semiHeading = "Invest in tomorrow's Leaders"
    val paragraphStringID = R.string.small_cap_fund_advertise
    val ButtonRowList = arrayListOf<String>()
    ButtonRowList.add("High Growth")
    ButtonRowList.add("No Lock-in")
    ButtonRowList.add("Long Term")

    FundsScreenLayout(
        TopBarHeading = heading,
        Heading = heading,
        SemiHeading = semiHeading,
        ParaGraphStringID = paragraphStringID,
        SmallBoxsRow = ButtonRowList,
        Content = {
            topCompaniesViewModel.getFundProvidersList(LocalContext.current)
                .forEach { fundBillers ->
                    FundsSurface(
                        FundProvider = fundBillers,
                        SurfaceOnClick = {
                            dynamicScreenViewModel.HeadingText.value = fundBillers.FundProviderName

                        }
                    )
                }
        }
    )
}

@Composable
fun IndexFundsScreen(
    topCompaniesViewModel: TopCompaniesViewModel,
    dynamicScreenViewModel: DynamicScreenViewModel
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

    FundsScreenLayout(
        TopBarHeading = heading,
        Heading = heading,
        SemiHeading = semiHeading,
        ParaGraphStringID = paragraphStringID,
        SmallBoxsRow = ButtonRowList,
        Content = {
            topCompaniesViewModel.getFundProvidersList(LocalContext.current)
                .forEach { fundBillers ->
                    FundsSurface(
                        FundProvider = fundBillers,
                        SurfaceOnClick = {
                            dynamicScreenViewModel.HeadingText.value = fundBillers.FundProviderName

                        }
                    )
                }
        }
    )
}