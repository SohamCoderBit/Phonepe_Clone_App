package com.example.phonepeclone.ui.Screens.WealthScreens

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.phonepeclone.FundsScreenLayout
import com.example.phonepeclone.R
import com.example.phonepeclone.ViewModels.TaxSavingFundViewModel

@Composable
fun TaxSavingFundScreen(taxSavingFundViewModel: TaxSavingFundViewModel) {

    val heading = "TAX SAVING FUNDS"
    val semiHeading = "Invest and save tax up to 46,800"
    val paragraphStringID = R.string.tax_saving_fund_advertise
    val ButtonRowList = arrayListOf<String>()
    ButtonRowList.add("High Growth")
    ButtonRowList.add("3 year Lock-in")

    val fundProviderList = taxSavingFundViewModel.getTaxSavingFundBillersList(LocalContext.current)
    FundsScreenLayout(
        TopBarHeading = heading,
        Heading = heading,
        SemiHeading = semiHeading,
        ParaGraphStringID = paragraphStringID,
        SmallBoxsRow = ButtonRowList,
        FundProviderList = fundProviderList
    )
}