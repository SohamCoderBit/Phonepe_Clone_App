package com.example.phonepeclone.ui.Screens.WealthScreens

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.phonepeclone.FundsScreenLayout
import com.example.phonepeclone.FundsSurface
import com.example.phonepeclone.NavigationDestinations
import com.example.phonepeclone.R
import com.example.phonepeclone.ViewModels.TaxSavingFundViewModel
import com.example.phonepeclone.navController

@Composable
fun TaxSavingFundScreen(taxSavingFundViewModel: TaxSavingFundViewModel) {

    val heading = "TAX SAVING FUNDS"
    val semiHeading = "Invest and save tax up to 46,800"
    val paragraphStringID = R.string.tax_saving_fund_advertise
    val ButtonRowList = arrayListOf<String>()
    ButtonRowList.add("High Growth")
    ButtonRowList.add("3 year Lock-in")

    FundsScreenLayout(
        TopBarHeading = heading,
        Heading = heading,
        SemiHeading = semiHeading,
        ParaGraphStringID = paragraphStringID,
        SmallBoxsRow = ButtonRowList,
        Content = {
            taxSavingFundViewModel.getTaxSavingFundBillersList(LocalContext.current)
                .forEach { fundBillers ->
                    FundsSurface(
                        FundProvider = fundBillers,
                        SurfaceOnClick = {
                            navController.navigateTo(Route = NavigationDestinations.DYNAMICSCREEN_ROUTE)
                        }
                    )
                }
        }
    )
}