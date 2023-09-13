package com.example.phonepeclone.ui.Screens.WealthScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.phonepeclone.BlueTopAppBar
import com.example.phonepeclone.NavigationDestinations
import com.example.phonepeclone.R
import com.example.phonepeclone.ViewModels.TaxSavingFundViewModel
import com.example.phonepeclone.navController

@Composable
fun TaxSavingFundScreen(taxSavingFundViewModel: TaxSavingFundViewModel) {

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = colorResource(id = R.color.background)
    ) {

        Column(
            modifier = Modifier
                .padding(top = 70.dp)
                .verticalScroll(rememberScrollState())
        ) {

            Box(
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .background(colorResource(id = R.color.scrollable_view))
            ) {

                Box(modifier = Modifier.align(alignment = Alignment.TopStart)) {
                    Row {
                        Box(
                            modifier = Modifier
                                .weight(2.5f)
                                .fillMaxHeight()
                        ) {
                            Column {
                                Text(
                                    modifier = Modifier.padding(
                                        start = 15.dp,
                                        top = 10.dp,
                                        bottom = 10.dp
                                    ),
                                    text = "TAX SAVING FUNDS",
                                    color = Color.White,
                                    fontWeight = FontWeight.Medium
                                )

                                Text(
                                    modifier = Modifier.padding(start = 15.dp, bottom = 5.dp),
                                    text = "Invest and save tax up to 46,800",
                                    fontSize = 20.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.SemiBold
                                )
                                Text(
                                    modifier = Modifier.padding(start = 15.dp),
                                    text = stringResource(id = R.string.tax_saving_fund_advertise),
                                    color = Color.White,
                                    lineHeight = 18.sp
                                )
                            }
                        }
                        Box(modifier = Modifier.weight(1f)) {

                        }
                    }
                }
                Box(modifier = Modifier.align(alignment = Alignment.BottomStart)) {
                    Row(
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .horizontalScroll(rememberScrollState())
                    ) {
                        FundsFacilityBoxs(Label = "High Growth", StartPadding = 10, EndPadding = 2)
                        FundsFacilityBoxs(Label = "3 year Lock-in", StartPadding = 2, EndPadding = 2)
                    }
                }

            }

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
        BlueTopAppBar(Heading = "Top Companies")
    }
}