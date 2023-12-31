package com.example.phonepeclone.ui.theme.Units

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.phonepeclone.ButtonsInView
import com.example.phonepeclone.HeadingText
import com.example.phonepeclone.Home
import com.example.phonepeclone.R
import com.example.phonepeclone.SurfaceInView
import com.example.phonepeclone.WriteLabelInRow
import com.example.phonepeclone.mainNavController
import com.example.phonepeclone.ui.theme.HomeUnitSections.InsuranceSection
import com.example.phonepeclone.ui.theme.HomeUnitSections.RechargePayBillSection
import com.example.phonepeclone.ui.theme.HomeUnitSections.SubscriptionSection
import com.example.phonepeclone.ui.theme.HomeUnitSections.SwitchSection
import com.example.phonepeclone.ui.theme.HomeUnitSections.TransferMoneysection
import com.example.phonepeclone.ui.theme.HomeUnitSections.TravelBookingSection
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme


@Composable
fun HomeScreenUnit() {

    Column(
        modifier = Modifier
            .padding(top = 70.dp, bottom = 70.dp)
            .verticalScroll(
                rememberScrollState()
            )
    ) {


        //Transfer Money Section
        SurfaceInView(Height = 170, InternalContent = @Composable {
            Column {
                HeadingText(
                    HeadingText = "Transfer Money",
                    SurfacePadding = PaddingValues(start = 20.dp, top = 10.dp),
                    HeadingTextFontWeight = FontWeight.Normal
                )
                TransferMoneysection()
            }
        })


        //Phonepe Wallet , Reward , Refer & get ₹100
        Box {
            Row {
                var modifier: Modifier = Modifier
                    .height(90.dp)
                    .weight(1.1f)
                ButtonsInView(modifier, 10, 5, R.drawable.wallet, OnClick = {
                    mainNavController.navigateTo(Route = Home.PHONEPE_WALLET_SCREEN)
                })

                modifier = Modifier
                    .height(90.dp)
                    .weight(1f)
                ButtonsInView(modifier, 5, 5, R.drawable.gift, OnClick = {
                    mainNavController.navigateTo(Route = Home.REWARD_SCREEN)
                })

                modifier = Modifier
                    .height(90.dp)
                    .weight(1.1f)
                ButtonsInView(modifier, 5, 10, R.drawable.link, OnClick = {
                    mainNavController.navigateTo(Route = Home.REFER_AND_GET_SCREEN)
                })
            }
            Row(
                modifier = Modifier
                    .align(alignment = Alignment.BottomCenter)
                    .padding(bottom = 7.dp)
            ) {

                var surfacemodifier: Modifier = Modifier.weight(1.2f)
                //Phonepe Wallet
                WriteLabelInRow(modifier = surfacemodifier, label = "Phonepe Wallet")

                surfacemodifier = Modifier.weight(1f)
                //Reward
                WriteLabelInRow(modifier = surfacemodifier, label = "Reward")

                surfacemodifier = Modifier.weight(1.2f)
                //Refer & Get ₹100
                WriteLabelInRow(modifier = surfacemodifier, label = "Refer & Get ₹100")
            }

        }


        //UPI Lite Button Main View
        val modifier: Modifier =
            Modifier.clickable { mainNavController.navigateTo(Route = Home.UPI_LITE_SCREEN) }
        SurfaceInView(
            Height = 80,
            modifier = modifier,
            InternalContent = @Composable {
                Row {
                    Icon(
                        modifier = Modifier
                            .padding(top = 15.dp, start = 30.dp)
                            .height(40.dp),
                        painter = painterResource(id = R.drawable.upi_ar21),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )

                    Divider(
                        modifier = Modifier
                            .height(50.dp)
                            .width(1.dp)
                            .padding(top = 20.dp)
                    )

                    Text(
                        modifier = Modifier.padding(start = 10.dp, top = 22.dp),
                        text = "PIN-less Payments",
                        color = colorResource(id = R.color.Pinless)
                    )

                    Icon(
                        modifier = Modifier
                            .height(40.dp)
                            .padding(top = 29.dp, start = 70.dp),
                        painter = painterResource(id = R.drawable.chevron_right_solid),
                        contentDescription = null,
                        tint = Color.White
                    )


                }
            })

        SurfaceInView(Height = 285, InternalContent = @Composable {
            RechargePayBillSection()
        })
        SurfaceInView(Height = 260, InternalContent = @Composable {
            InsuranceSection()
        })
        SurfaceInView(Height = 150, InternalContent = @Composable {
            TravelBookingSection()
        })
        SurfaceInView(Height = 150, InternalContent = @Composable {
            SwitchSection()
        })
        SurfaceInView(
            SurfacePadding = PaddingValues(10.dp),
            InternalContent = @Composable {
                SubscriptionSection()
            })
    }

}

@Preview(showSystemUi = true)
@Composable
fun PreviewHomeScreen() {
    PhonepeCloneTheme {
        HomeScreenUnit()
    }
}
