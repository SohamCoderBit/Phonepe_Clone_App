package com.example.phonepeclone.ui.Screens.WealthScreens

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
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
import com.example.phonepeclone.HeadingTextInSurfaceView
import com.example.phonepeclone.R
import com.example.phonepeclone.ScrollableBoxs
import com.example.phonepeclone.SurfaceInView
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme


@Composable
fun GoldFacilityButtons(Label: String) {
    ScrollableBoxs(Label = Label)
}

@Composable
fun GoldScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = colorResource(id = R.color.background)
    ) {

        Column(modifier = Modifier.padding(top = 70.dp)) {
            SurfaceInView(Height = 150, surfaceColor = Color.White) {

            }

            Surface(
                modifier = Modifier
                    .height(240.dp)
                    .fillMaxWidth(),
                color = colorResource(id = R.color.scrollable_view)
            ) {

                Column {
                    HeadingTextInSurfaceView(
                        HeadingText = "Buy 24K Gold with ease",
                        TextFontSize = 22
                    )

                    Row(
                        modifier = Modifier
                            .padding(start = 10.dp, top = 30.dp)
                            .horizontalScroll(
                                rememberScrollState()
                            )
                    ) {
                        GoldFacilityButtons(Label = "99.99% Purity")
                        GoldFacilityButtons(Label = "Buy/Sell 24*7")
                        GoldFacilityButtons(Label = "Insured Storage")
                        GoldFacilityButtons(Label = "Wealth Protection")
                    }

                    Divider(
                        modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 15.dp),
                        thickness = 1.dp
                    )

                    Row(
                        modifier = Modifier.padding(top = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            modifier = Modifier.padding(start = 20.dp),
                            text = "Buy Price:",
                            color = Color.LightGray,
                            fontSize = 18.sp
                        )

                        Text(
                            modifier = Modifier.padding(start = 10.dp),
                            text = "₹6,096.59/gm",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Medium
                        )

                        Text(
                            modifier = Modifier.padding(start = 10.dp),
                            text = "+3% GST",
                            color = Color(0xAACCCCCC)
                        )
                    }

                    Divider(
                        modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 15.dp),
                        thickness = 1.dp
                    )


                    Row(modifier = Modifier.padding(top = 10.dp)) {
                        Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                            Button(
                                modifier = Modifier
                                    .padding(start = 20.dp, end = 10.dp)
                                    .fillMaxWidth(),
                                onClick = { /*TODO*/ },
                                shape = CircleShape,
                                colors = ButtonDefaults.outlinedButtonColors(Color(163, 99, 235, 255))
                            ) {
                                Text(text = "START SIP", fontSize = 12.sp , color = Color.White)
                            }
                        }
                        Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                            Button(
                                modifier = Modifier
                                    .padding(start = 10.dp, end = 20.dp)
                                    .fillMaxWidth(),
                                onClick = { /*TODO*/ },
                                shape = CircleShape,
                                colors = ButtonDefaults.outlinedButtonColors(Color(163, 99, 235, 255))
                            ) {
                                Text(text = "BUY ONE TIME", fontSize = 12.sp , color = Color.White)
                            }
                        }
                    }

                    Divider(
                        modifier = Modifier.padding(top = 10.dp),
                        thickness = 1.dp
                    )
                }
            }
        }
        BlueTopAppBar(Heading = "Gold Savings")
    }
}


@Preview
@Composable
fun PreviewGoldScreen() {
    PhonepeCloneTheme {
        GoldScreen()
    }
}
