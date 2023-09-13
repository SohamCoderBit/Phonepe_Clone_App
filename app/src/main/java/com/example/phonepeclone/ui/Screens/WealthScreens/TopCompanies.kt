package com.example.phonepeclone.ui.Screens.WealthScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.phonepeclone.BlueTopAppBar
import com.example.phonepeclone.Data.FundBillers
import com.example.phonepeclone.NavigationDestinations
import com.example.phonepeclone.R
import com.example.phonepeclone.ScrollableBoxs
import com.example.phonepeclone.ViewModels.TopCompaniesViewModel
import com.example.phonepeclone.navController
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme

@Composable
fun FundsSurface(
    FundProvider: FundBillers,
    SurfaceOnClick: () -> Unit = {},
    MoreDetailesOnClick: () -> Unit = {}
) {
    Surface(
        modifier = Modifier
            .padding(top = 10.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth()
            .height(190.dp)
            .clickable { SurfaceOnClick() },
        shape = RoundedCornerShape(10),
        color = Color(33, 24, 43, 255)
    ) {

        Column {

            Row {

                Box(
                    modifier = Modifier
                        .weight(1.2f)
                        .height(80.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        modifier = Modifier
                            .height(60.dp),
                        painter = painterResource(id = R.mipmap.icici_fund_foreground),
                        contentDescription = null
                    )
                }

                Box(
                    modifier = Modifier
                        .weight(3f)
                        .height(80.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Column {
                        Text(
                            text = FundProvider.FundProviderName,
                            color = Color.White,
                            fontSize = 16.sp
                        )
                        Text(text = "Equity : Large Cap", color = Color.White)
                    }
                }

                Box(
                    modifier = Modifier
                        .weight(0.8f)
                        .height(80.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier = Modifier
                            .height(15.dp),
                        painter = painterResource(id = R.drawable.chevron_right_solid),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }

            Divider(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                thickness = 2.dp,
                color = Color(46, 37, 56, 255)
            )

            Row {
                Box(
                    modifier = Modifier
                        .weight(0.9f)
                        .height(70.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Column(modifier = Modifier.padding(start = 20.dp)) {
                        Text(text = "Last 3Y", fontSize = 13.sp, color = Color.White)
                        Row(modifier = Modifier.padding(top = 2.dp)) {
                            Text(
                                text = FundProvider.Last3Year + "%",
                                fontSize = 17.sp,
                                color = Color.White
                            )
                            Text(
                                modifier = Modifier.padding(top = 8.dp),
                                text = " p.a",
                                fontSize = 10.sp,
                                color = Color.White
                            )
                        }
                    }
                }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(70.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column {
                        Text(text = "Min Invest.", color = Color.White)
                        Text(text = FundProvider.MinInvest, fontSize = 17.sp, color = Color.White)
                    }
                }

                Box(
                    modifier = Modifier
                        .weight(1.3f)
                        .height(70.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Column(modifier = Modifier.padding(start = 25.dp)) {
                        Text(text = "Fund Size", color = Color.White)
                        Text(
                            text = "₹" + FundProvider.FundSize + "Cr",
                            fontSize = 17.sp,
                            color = Color.White
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp)
                    .fillMaxWidth()

            ) {
                Text(
                    modifier = Modifier.clickable(
                        indication = null,
                        interactionSource = MutableInteractionSource()
                    ) {
                        MoreDetailesOnClick()
                    },
                    text = "More Details",
                    color = Color(146, 111, 198, 255),
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}


@Composable
fun FundsFacilityBoxs(Label: String, StartPadding: Int, EndPadding: Int) {
    ScrollableBoxs(Label = Label, StartPadding = StartPadding, EndPadding = EndPadding)
}


@Composable
fun TopCompaniesScreen(topCompaniesViewModel: TopCompaniesViewModel) {

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
                                    text = "TOP COMPANIES",
                                    color = Color.White,
                                    fontWeight = FontWeight.Medium
                                )

                                Text(
                                    modifier = Modifier.padding(start = 15.dp, bottom = 5.dp),
                                    text = "Invest in India's biggest companies",
                                    fontSize = 20.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.SemiBold
                                )
                                Text(
                                    modifier = Modifier.padding(start = 15.dp),
                                    text = stringResource(id = R.string.fund_advertise),
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
                        FundsFacilityBoxs(Label = "No Lock-in", StartPadding = 2, EndPadding = 2)
                        FundsFacilityBoxs(Label = "Long Term", StartPadding = 2, EndPadding = 2)
                        FundsFacilityBoxs(
                            Label = "For Beginners",
                            StartPadding = 2,
                            EndPadding = 10
                        )
                    }
                }


            }

            topCompaniesViewModel.getFundProvidersList(LocalContext.current)
                .forEach { fundBillers ->
                    FundsSurface(
                        FundProvider = fundBillers,
                        SurfaceOnClick = {
                            topCompaniesViewModel.setString(fundBillers.FundProviderName)
                            navController.navigateTo(Route = NavigationDestinations.DYNAMICSCREEN_ROUTE)
                        }
                    )
                }
        }
        BlueTopAppBar(Heading = "Top Companies")
    }
}

@Preview
@Composable
fun PreviewTopCompanies() {
    PhonepeCloneTheme {
        TopCompaniesScreen(viewModel())
    }
}

