package com.example.phonepeclone.ui.Screens.WealthScreens

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.phonepeclone.FundsScreenLayout
import com.example.phonepeclone.FundsSurface
import com.example.phonepeclone.NavigationDestinations
import com.example.phonepeclone.R
import com.example.phonepeclone.ViewModels.DynamicScreenViewModel
import com.example.phonepeclone.ViewModels.TopCompaniesViewModel
import com.example.phonepeclone.navController

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
                            navController.navigateTo(Route = NavigationDestinations.DYNAMIC_SCREEN_ROUTE)
                        }
                    )
                }
        })
}

