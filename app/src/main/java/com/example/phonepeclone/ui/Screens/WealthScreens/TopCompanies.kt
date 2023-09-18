package com.example.phonepeclone.ui.Screens.WealthScreens

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.phonepeclone.FundsScreenLayout
import com.example.phonepeclone.FundsSurface
import com.example.phonepeclone.NavigationDestinations
import com.example.phonepeclone.R
import com.example.phonepeclone.ScrollableBoxs
import com.example.phonepeclone.ViewModels.DynamicScreenViewModel
import com.example.phonepeclone.ViewModels.TopCompaniesViewModel
import com.example.phonepeclone.navController
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme


@Composable
fun FundsFacilityBoxs(Label: String, StartPadding: Int, EndPadding: Int) {
    ScrollableBoxs(Label = Label, StartPadding = StartPadding, EndPadding = EndPadding)
}


@Composable
fun TopCompaniesScreen(
    topCompaniesViewModel: TopCompaniesViewModel,
    dynamicScreenViewModel: DynamicScreenViewModel
) {

    val heading = "TOP COMPANIES"
    val semiHeading = "Invest in India's biggest companies"
    val paragraphStringID = R.string.fund_advertise
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
        }
    )


}

@Preview
@Composable
fun PreviewTopCompanies() {
    PhonepeCloneTheme {
        TopCompaniesScreen(viewModel(), viewModel())
    }
}

