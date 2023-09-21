package com.example.phonepeclone.ui.theme.Screens.TransferMoneyScreens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
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
import androidx.compose.ui.unit.sp
import com.example.phonepeclone.BlueTopAppBar
import com.example.phonepeclone.HeadingTextInSurfaceView
import com.example.phonepeclone.R
import com.example.phonepeclone.SurfaceInView
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme


@Composable
fun CheckBalanceScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(), color = colorResource(id = R.color.background)
    ) {

        Column(modifier = Modifier.padding(top = 70.dp)) {
            SurfaceInView(Height = 150) {

            }

            SurfaceInView(Height = 170) {
                Row {
                    Box(
                        modifier = Modifier
                            .weight(1.3f)
                            .fillMaxHeight(),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier.size(120.dp),
                            painter = painterResource(id = R.drawable.bank_5209710),
                            contentDescription = null,
                            tint = Color.Unspecified
                        )

                    }
                    Box(
                        modifier = Modifier
                            .weight(2f)
                            .fillMaxHeight(),
                        contentAlignment = Alignment.Center
                    ) {

                        Column {
                            Text(
                                modifier = Modifier.padding(bottom = 10.dp),
                                text = "UPI Account",
                                color = Color.White,
                                fontSize = 20.sp
                            )
                            Text(
                                text = "Check Your Bank Balance Without net Banking",
                                color = Color.White,
                                fontSize = 13.sp,
                                lineHeight = 17.sp
                            )
                            Button(
                                modifier = Modifier
                                    .padding(top = 20.dp)
                                    .height(25.dp),
                                onClick = { /*TODO*/ },
                                contentPadding = PaddingValues(
                                    start = 10.dp, end = 10.dp
                                ),
                                shape = RoundedCornerShape(50),
                                colors = ButtonDefaults.outlinedButtonColors(
                                    Color(
                                        163, 99, 239, 255
                                    )
                                )
                            ) {
                                Text(
                                    text = "Add Bank Account",
                                    fontSize = 13.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                        }
                    }
                }
            }

            SurfaceInView(Height = 90) {
                Row(modifier = Modifier.clickable {}) {
                    Box(
                        modifier = Modifier
                            .weight(0.7f)
                            .height(90.dp),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        Icon(
                            modifier = Modifier.size(40.dp),
                            painter = painterResource(id = R.drawable.list_file_81296),
                            contentDescription = null,
                            tint = Color(144, 93, 198, 255)
                        )
                    }

                    Box(
                        modifier = Modifier
                            .weight(3f)
                            .height(90.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column {
                            Text(
                                text = "Bank Statements",
                                color = Color.White,
                                fontWeight = FontWeight.SemiBold
                            )

                            Text(
                                modifier = Modifier.padding(top = 2.dp),
                                text = "Phonepe Account Aggregator",
                                color = Color.White,
                                fontSize = 13.sp,
                                lineHeight = 14.sp
                            )
                        }
                    }

                    Box(
                        modifier = Modifier
                            .weight(0.9f)
                            .height(90.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier.size(15.dp),
                            painter = painterResource(id = R.drawable.chevron_right_solid),
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }
            }

            SurfaceInView(Height = 230) {

                Column {
                    HeadingTextInSurfaceView(
                        HeadingText = "Pre-Paid Balance",
                        SurfacePadding = PaddingValues(start = 20.dp, top = 10.dp)
                    )

                    //UPI Lite
                    Row(modifier = Modifier
                        .padding(top = 10.dp)
                        .clickable {
                        })
                    {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(90.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                modifier = Modifier.size(50.dp),
                                painter = painterResource(id = R.drawable.upi_ar21),
                                contentDescription = null,
                                tint = Color.Unspecified
                            )
                        }

                        Box(
                            modifier = Modifier
                                .weight(3f)
                                .height(90.dp),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Column {
                                Text(
                                    text = "UPI Lite", color = Color.White
                                )
                            }
                        }

                        Box(
                            modifier = Modifier
                                .weight(0.9f)
                                .height(90.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                modifier = Modifier.size(15.dp),
                                painter = painterResource(id = R.drawable.chevron_right_solid),
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    }

                    Divider(
                        modifier = Modifier
                            .padding(start = 76.dp)
                            .fillMaxWidth(),
                        color = Color(51, 42, 61, 255)
                    )

                    //Phonepe Wallet
                    Row(modifier = Modifier.clickable {

                    }) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(90.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                modifier = Modifier.size(40.dp),
                                painter = painterResource(id = R.drawable.wallet),
                                contentDescription = null,
                                tint = Color(144, 93, 198, 255)
                            )
                        }

                        Box(
                            modifier = Modifier
                                .weight(3f)
                                .height(90.dp),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Column {
                                Text(
                                    text = "Phonepe Wallet", color = Color.White
                                )
                            }
                        }

                        Box(
                            modifier = Modifier
                                .weight(0.9f)
                                .height(90.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                modifier = Modifier.size(15.dp),
                                painter = painterResource(id = R.drawable.chevron_right_solid),
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    }
                }


            }
        }


        //Top App Bar
        BlueTopAppBar(Heading = "Check Balance")
    }
}

@Preview(
    showSystemUi = true
)
@Composable
fun PreviewCheckBalance() {
    PhonepeCloneTheme {
        CheckBalanceScreen()
    }
}

