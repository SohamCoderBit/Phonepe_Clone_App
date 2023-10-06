package com.example.phonepeclone.ui.Screens.HomeUnitScreens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.phonepeclone.BlueTopAppBar
import com.example.phonepeclone.DrawIcon
import com.example.phonepeclone.HeadingText
import com.example.phonepeclone.R
import com.example.phonepeclone.SurfaceInView
import com.example.phonepeclone.ThreeBoxRow
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme


data class paymentSetting(
    val firstIconID: Int,
    val mainHeading: String,
    val seconderyHeading: String
)

data class settings(
    val firstIconID : Int ,
    val mainHeading: String ,
    val seconderyHeading : String
)

@Composable
fun Profile() {

    val paymentSettingList = listOf(
        paymentSetting(
            firstIconID = R.drawable.qrcode_solid,
            mainHeading = "QR Codes",
            seconderyHeading = "View your QR codes"
        ),
        paymentSetting(
            firstIconID = R.drawable.credit_card,
            mainHeading = "Link Rupay Credit Card on UPI",
            seconderyHeading = "Scan and pay eith UPI PIN"
        ),
        paymentSetting(
            firstIconID = R.drawable.at_the_rate,
            mainHeading = "UPI Settings",
            seconderyHeading = "View all your UPI IDs"
        ),
        paymentSetting(
            firstIconID = R.drawable.auto_pay,
            mainHeading = "Autopay Setting",
            seconderyHeading = "Manage your Autopay settings"
        ),
        paymentSetting(
            firstIconID = R.drawable.internatinoal_upi,
            mainHeading = "UPI International",
            seconderyHeading = "Make instant international payments through UPI"
        ),
        paymentSetting(
            firstIconID = R.drawable.reminder,
            mainHeading = "Reminders",
            seconderyHeading = "View your QR codes"
        )
    )
    val settingsList = listOf(
        settings(
            firstIconID = R.drawable.language,
            mainHeading = "Languages",
            seconderyHeading = "Choosen  Language : English"
        ) ,
        settings(
            firstIconID = R.drawable.bill_notification,
            mainHeading = "Bill Notifications",
            seconderyHeading = "Receive alerts when bill is genrated"
        ) ,
        settings(
            firstIconID = R.drawable.permission,
            mainHeading = "Permissions",
            seconderyHeading = "Manage data sharing settings"
        ) ,
        settings(
            firstIconID = R.drawable.theme,
            mainHeading = "Themes",
            seconderyHeading = "Choose between light and dark mode"
        ) ,
        settings(
            firstIconID = R.drawable.user_preferences,
            mainHeading = "Data Preferences",
            seconderyHeading = "Manage all the shared information"
        )

    )

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = colorResource(id = R.color.background)
    ) {

        LazyColumn(modifier = Modifier.padding(top = 70.dp)) {

            item {
                SurfaceInView {
                    Column {
                        HeadingText(HeadingText = "Payment Settings")

                        paymentSettingList.forEachIndexed { index, item ->
                            Box {
                                ThreeBoxRow(
                                    firstBoxContent = {
                                        DrawIcon(IconID = item.firstIconID)
                                    },
                                    secondBoxContent = {
                                        Column {
                                            HeadingText(
                                                HeadingText = item.mainHeading,
                                                SurfacePadding = PaddingValues(0.dp)
                                            )

                                            HeadingText(
                                                HeadingText = item.seconderyHeading,
                                                SurfacePadding = PaddingValues(0.dp),
                                                HeadingTextFontWeight = FontWeight.Normal,
                                                HeadingTextColor = Color.LightGray,
                                                HeadingTextLineHeight = 15.sp ,
                                                TextFontSize = 13
                                            )
                                        }
                                    },
                                    thirdBoxContent = {
                                        DrawIcon(
                                            IconID = R.drawable.chevron_right_solid_2,
                                            IconSize = 20
                                        )
                                    },
                                    boxWeightList = listOf(0.2f, 0.7f, 0.2f),
                                    alignmentList = listOf(
                                        Alignment.Center,
                                        Alignment.CenterStart,
                                        Alignment.Center
                                    ),
                                    onClick = {

                                    },
                                    doRipple = true
                                )
                            }
                            if (index < paymentSettingList.size - 1) {

                                Row(modifier = Modifier.fillMaxWidth()) {

                                    Box(modifier = Modifier.weight(0.2f)) {}
                                    Box(
                                        modifier = Modifier.weight(0.9f),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Divider(color = colorResource(id = R.color.divider_color))
                                    }
                                }
                            }
                        }
                    }
                }
            }

            item {
                SurfaceInView {
                    Column {
                        HeadingText(HeadingText = "Settings & Preferences")

                        settingsList.forEachIndexed { index, item ->
                            Box {
                                ThreeBoxRow(
                                    firstBoxContent = {
                                        DrawIcon(IconID = item.firstIconID)
                                    },
                                    secondBoxContent = {
                                        Column {
                                            HeadingText(
                                                HeadingText = item.mainHeading,
                                                SurfacePadding = PaddingValues(0.dp)
                                            )

                                            HeadingText(
                                                HeadingText = item.seconderyHeading,
                                                SurfacePadding = PaddingValues(0.dp),
                                                HeadingTextFontWeight = FontWeight.Normal,
                                                HeadingTextColor = Color.LightGray,
                                                HeadingTextLineHeight = 15.sp ,
                                                TextFontSize = 13
                                            )
                                        }
                                    },
                                    thirdBoxContent = {
                                        DrawIcon(
                                            IconID = R.drawable.chevron_right_solid_2,
                                            IconSize = 20
                                        )
                                    },
                                    boxWeightList = listOf(0.2f, 0.7f, 0.2f),
                                    alignmentList = listOf(
                                        Alignment.Center,
                                        Alignment.CenterStart,
                                        Alignment.Center
                                    ),
                                    onClick = {

                                    },
                                    doRipple = true
                                )
                            }
                            if (index < settingsList.size - 1) {

                                Row(modifier = Modifier.fillMaxWidth()) {

                                    Box(modifier = Modifier.weight(0.2f)) {}
                                    Box(
                                        modifier = Modifier.weight(0.9f),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Divider(color = colorResource(id = R.color.divider_color))
                                    }
                                }
                            }
                        }
                    }
                }
            }

            item {
                SurfaceInView(Height = 300) {

                }
            }

            item {
                SurfaceInView(Height = 300) {

                }
            }

        }

        BlueTopAppBar(Heading = "Profile")
    }
}


@Preview
@Composable
fun PreviewProfile() {
    PhonepeCloneTheme {
        Profile()
    }
}
