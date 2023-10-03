package com.example.phonepeclone.ui.Screens.HomeUnitScreens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.phonepeclone.BlueTopAppBar
import com.example.phonepeclone.DrawIconInRow
import com.example.phonepeclone.HeadingTextInSurfaceView
import com.example.phonepeclone.Home
import com.example.phonepeclone.R
import com.example.phonepeclone.SurfaceInView
import com.example.phonepeclone.WriteLabelInRow
import com.example.phonepeclone.mainNavController
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme

@Composable
fun RechargePayBillScreen() {

    val boxmodifier: Modifier = Modifier
        .size(60.dp)
        .clip(RoundedCornerShape(25.dp))

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = colorResource(id = R.color.background)
    ) {
        Column(modifier = Modifier
            .padding(top = 70.dp)
            .verticalScroll(rememberScrollState())) {
            SurfaceInView(Height = 165) {
                Column {

                    HeadingTextInSurfaceView(
                        HeadingText = "Recharge",
                        HeadingTextFontWeight = FontWeight.Normal,
                        SurfacePadding = PaddingValues(start = 20.dp, top = 10.dp)
                    )

                    Row(modifier = Modifier.padding(top = 5.dp)) {
                        val surfacemodifier: Modifier = Modifier.weight(1f)

                        //Mobile Recharge
                        DrawIconInRow(
                            SurfaceModifier = surfacemodifier,
                            BoxModifier = boxmodifier.clickable {

                            },
                            IconSize = 45,
                            IconResource = R.drawable.mobile
                        )

                        //FASTag Recharge
                        DrawIconInRow(
                            SurfaceModifier = surfacemodifier,
                            BoxModifier = boxmodifier.clickable {

                            },
                            IconSize = 45,
                            IconResource = R.drawable.super_top_up_logo,
                        )

                        //DTH
                        DrawIconInRow(
                            SurfaceModifier = surfacemodifier,
                            BoxModifier = boxmodifier,
                            IconSize = 45,
                            IconResource = R.drawable.dth_recharge,
                        )

                        //Cable TV
                        DrawIconInRow(
                            SurfaceModifier = surfacemodifier,
                            BoxModifier = boxmodifier.clickable {
                                mainNavController.navigateTo(Route = Home.CABLE_TV_SCREEN)
                            },
                            IconSize = 45,
                            IconResource = R.drawable.cable_tv,
                        )
                    }

                    Row(modifier = Modifier.padding(top = 5.dp)) {

                        val surfacemodifier: Modifier = Modifier.weight(1f)
                        //Mobile \nRecharge
                        WriteLabelInRow(modifier = surfacemodifier, label = "Mobile\nRecharge")

                        //FASTag \nRecharge
                        WriteLabelInRow(modifier = surfacemodifier, label = "FASTag\nRecharge")

                        //DTH
                        WriteLabelInRow(modifier = surfacemodifier, label = "DTH")

                        //Cable TV
                        WriteLabelInRow(modifier = surfacemodifier, label = "Cable TV")

                    }

                }
            }

            SurfaceInView(Height = 270) {
                Column {

                    HeadingTextInSurfaceView(
                        HeadingText = "Utilities",
                        SurfacePadding = PaddingValues(start = 20.dp, top = 10.dp),
                        HeadingTextFontWeight = FontWeight.Normal
                    )
                    //Investment Ideas Section Row 1 (Icons)
                    Row(modifier = Modifier.padding(top = 5.dp)) {
                        val surfacemodifier: Modifier = Modifier.weight(1f)

                        //Rent\nPayment
                        DrawIconInRow(
                            SurfaceModifier = surfacemodifier,
                            BoxModifier = boxmodifier.clickable {

                            },
                            IconSize = 45,
                            IconResource = R.drawable.building,
                        )

                        //Piped gas
                        DrawIconInRow(
                            SurfaceModifier = surfacemodifier,
                            BoxModifier = boxmodifier.clickable {
                                mainNavController.navigateTo(Route = Home.PIPED_GAS_SCREEN)
                            },
                            IconSize = 45,
                            IconResource = R.drawable.fluctuation,
                        )

                        //Water
                        DrawIconInRow(
                            SurfaceModifier = surfacemodifier,
                            BoxModifier = boxmodifier.clickable {
                                mainNavController.navigateTo(Route = Home.WATER_SCREEN)
                            },
                            IconSize = 45,
                            IconResource = R.drawable.water,
                        )

                        //Electricity
                        DrawIconInRow(
                            SurfaceModifier = surfacemodifier,
                            BoxModifier = boxmodifier.clickable {

                            },
                            IconSize = 45,
                            IconResource = R.drawable.bulb,
                        )
                    }

                    //Investment Ideas Section Row 1 (Label Texts)
                    Row(modifier = Modifier.padding(top = 5.dp)) {
                        val surfacemodifier: Modifier = Modifier.weight(1f)

                        //Rent\nPayment
                        WriteLabelInRow(modifier = surfacemodifier, label = "Rent\nPayment")

                        //Piped gas
                        WriteLabelInRow(modifier = surfacemodifier, label = "Piped gas")

                        //Water
                        WriteLabelInRow(modifier = surfacemodifier, label = "Water")

                        //Electricity
                        WriteLabelInRow(modifier = surfacemodifier, label = "Electricity")

                    }

                    //Investment Ideas Section Row 2 (Icons)
                    Row(modifier = Modifier.padding(top = 10.dp)) {
                        val surfacemodifier: Modifier = Modifier.weight(1f)

                        //PostPaid
                        DrawIconInRow(
                            SurfaceModifier = surfacemodifier,
                            BoxModifier = boxmodifier.clickable {

                            },
                            IconSize = 45,
                            IconResource = R.drawable.growth_846173,
                        )

                        //Broadband/Landline
                        DrawIconInRow(
                            SurfaceModifier = surfacemodifier,
                            BoxModifier = boxmodifier.clickable {

                            },
                            IconSize = 45,
                            IconResource = R.drawable.broadband,
                        )

                        //Education fees
                        DrawIconInRow(
                            SurfaceModifier = surfacemodifier,
                            BoxModifier = boxmodifier.clickable {
                                mainNavController.navigateTo(Route = Home.EDUCATION_FEES_SCREEN)
                            },
                            IconSize = 45,
                            IconResource = R.drawable.education_fees,
                        )

                        //Book A cylinder
                        DrawIconInRow(
                            SurfaceModifier = surfacemodifier,
                            BoxModifier = boxmodifier.clickable {

                            },
                            IconSize = 45,
                            IconResource = R.drawable.gas_cylinder,
                        )
                    }

                    //Investment Ideas Section Row 2 (Label Texts)
                    Row(modifier = Modifier.padding(top = 5.dp)) {
                        val surfacemodifier: Modifier = Modifier.weight(1f)

                        //Postpaid
                        WriteLabelInRow(modifier = surfacemodifier, label = "PostPaid")

                        //Broadband/Landline
                        WriteLabelInRow(modifier = surfacemodifier, label = "Broadband/\nLandline")

                        //Education fees
                        WriteLabelInRow(modifier = surfacemodifier, label = "Education \nFees")

                        //Book A Cylinder
                        WriteLabelInRow(modifier = surfacemodifier, label = "Book A\n cylinder")

                    }
                }
            }

            SurfaceInView(Height = 165) {
                Column {

                    HeadingTextInSurfaceView(
                        HeadingText = "Purchase",
                        HeadingTextFontWeight = FontWeight.Normal,
                        SurfacePadding = PaddingValues(start = 20.dp, top = 10.dp)
                    )

                    Row(modifier = Modifier.padding(top = 5.dp)) {
                        val surfacemodifier: Modifier = Modifier.weight(1f)

                        //Brand Vouchers
                        DrawIconInRow(
                            SurfaceModifier = surfacemodifier,
                            BoxModifier = boxmodifier.clickable {

                            },
                            IconSize = 40,
                            IconResource = R.drawable.brand_vouchers,
                        )

                        //Google Play
                        DrawIconInRow(
                            SurfaceModifier = surfacemodifier,
                            BoxModifier = boxmodifier.clickable {

                            },
                            IconSize = 40,
                            IconResource = R.drawable.google_play_store,
                            IconTint = Color.Unspecified
                        )

                        //Subscriptions
                        DrawIconInRow(
                            SurfaceModifier = surfacemodifier,
                            BoxModifier = boxmodifier,
                            IconSize = 45,
                            IconResource = R.drawable.subscriptions,
                        )

                        //App Store Code
                        DrawIconInRow(
                            SurfaceModifier = surfacemodifier,
                            BoxModifier = boxmodifier.clickable {

                            },
                            IconSize = 50,
                            IconResource = R.drawable.apple_store_code,
                            IconTint = Color.Unspecified
                        )
                    }

                    Row(modifier = Modifier.padding(top = 5.dp)) {

                        val surfacemodifier: Modifier = Modifier.weight(1f)
                        //Health
                        WriteLabelInRow(modifier = surfacemodifier, label = "Brand \nVouchers")

                        //Super Top-Up
                        WriteLabelInRow(modifier = surfacemodifier, label = "Google Play")

                        //Term Life
                        WriteLabelInRow(modifier = surfacemodifier, label = "Subscriptions")

                        //Accident
                        WriteLabelInRow(modifier = surfacemodifier, label = "App Store \n Store")

                    }

                }
            }

            SurfaceInView(Height = 165) {
                Column {

                    HeadingTextInSurfaceView(
                        HeadingText = "More Services",
                        HeadingTextFontWeight = FontWeight.Normal,
                        SurfacePadding = PaddingValues(start = 20.dp, top = 10.dp)
                    )

                    Row(modifier = Modifier.padding(top = 5.dp)) {
                        val surfacemodifier: Modifier = Modifier.weight(1f)

                        //Health
                        DrawIconInRow(
                            SurfaceModifier = surfacemodifier,
                            BoxModifier = boxmodifier.clickable {

                            },
                            IconSize = 45,
                            IconResource = R.drawable.new_group,
                        )

                        //Super Top-Up
                        DrawIconInRow(
                            SurfaceModifier = surfacemodifier,
                            BoxModifier = boxmodifier.clickable {

                            },
                            IconSize = 45,
                            IconResource = R.drawable.super_top_up_logo,
                        )

                        //Apartments
                        DrawIconInRow(
                            SurfaceModifier = surfacemodifier,
                            BoxModifier = boxmodifier.clickable {
                                mainNavController.navigateTo(Route = Home.APARTMENTS_SCREEN)
                            },
                            IconSize = 45,
                            IconResource = R.drawable.apartment,
                        )

                        //Accident
                        DrawIconInRow(
                            SurfaceModifier = surfacemodifier,
                            BoxModifier = boxmodifier.clickable {

                            },
                            IconSize = 45,
                            IconResource = R.drawable.patient_469444,
                        )
                    }

                    Row(modifier = Modifier.padding(top = 5.dp)) {

                        val surfacemodifier: Modifier = Modifier.weight(1f)
                        //Health
                        WriteLabelInRow(
                            modifier = surfacemodifier,
                            label = "Clubs and \n Associations"
                        )

                        //Super Top-Up
                        WriteLabelInRow(modifier = surfacemodifier, label = "HP & UK \nFloods")

                        //Apartments
                        WriteLabelInRow(modifier = surfacemodifier, label = "Apartments")

                        //Accident
                        WriteLabelInRow(modifier = surfacemodifier, label = "Donate\nmeals")

                    }

                }
            }

        }

        BlueTopAppBar(Heading = "Recharge & Bill Pay...")
    }
}


@Preview
@Composable
fun PreviewRechargePayBillScreen() {
    PhonepeCloneTheme {
        RechargePayBillScreen()
    }
}

