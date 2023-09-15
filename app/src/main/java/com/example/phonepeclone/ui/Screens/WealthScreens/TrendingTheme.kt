package com.example.phonepeclone.ui.Screens.WealthScreens

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.phonepeclone.FundsScreenLayout
import com.example.phonepeclone.NavigationDestinations
import com.example.phonepeclone.R
import com.example.phonepeclone.ViewModels.DynamicScreenViewModel
import com.example.phonepeclone.ViewModels.TopCompaniesViewModel
import com.example.phonepeclone.navController

@Composable
fun TrendingThemesScreen(
    topCompaniesViewModel: TopCompaniesViewModel,
    dynamicScreenViewModel: DynamicScreenViewModel
)
{
    val heading = "TRENDING THEMES"
    val semiHeading = "Invest in funds tracking top themes ans sectors"
    val paragraphStringID = R.string.trending_themes_advertise
    val ButtonRowList = arrayListOf<String>()
    ButtonRowList.add("High Growth")
    ButtonRowList.add("No Lock-in")
    ButtonRowList.add("Long Term")
    ButtonRowList.add("High Risk")

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
                            navController.navigateTo(Route = NavigationDestinations.DYNAMICSCREEN_ROUTE)
                        }
                    )
                }
        })
}


