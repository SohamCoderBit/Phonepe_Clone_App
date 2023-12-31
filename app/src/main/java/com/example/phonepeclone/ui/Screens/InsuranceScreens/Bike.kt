package com.example.phonepeclone.ui.theme.Screens.InsuranceScreens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.phonepeclone.BlueTopAppBar
import com.example.phonepeclone.FullPurpleButton
import com.example.phonepeclone.R
import com.example.phonepeclone.SurfaceInView
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme


@Composable
fun BikeScreen() {

    var enteredBikeNumber by remember {
        mutableStateOf("")
    }
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = colorResource(id = R.color.background)
    ) {
        Column(modifier = Modifier.padding(top = 70.dp)) {
            SurfaceInView(Height = 290) {

                Column {

                    Surface(
                        modifier = Modifier.padding(start = 20.dp, top = 20.dp),
                        color = Color.Transparent
                    ) {
                        Column {
                            Text(
                                text = "Enter Your Bike Number",
                                color = Color.White,
                                fontSize = 18.sp
                            )
                            Text(
                                modifier = Modifier.padding(top = 5.dp),
                                text = "Currently serving only private bikes",
                                color = Color.LightGray,
                                fontSize = 13.sp
                            )
                        }

                    }


                    Box(
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .height(80.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        enteredBikeNumber = textFieldCarAndBikeScreen()
                    }


                    //Submit Button
                    Box(
                        modifier = Modifier
                            .height(70.dp)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Button(
                            modifier = Modifier
                                .padding(start = 20.dp, end = 20.dp)
                                .fillMaxWidth()
                                .height(60.dp),
                            onClick = { /*TODO*/ },
                            shape = RoundedCornerShape(50),
                            contentPadding = PaddingValues(
                                start = 35.dp,
                                end = 35.dp,
                                top = 5.dp,
                                bottom = 5.dp
                            ),
                            colors = ButtonDefaults.outlinedButtonColors(Color(163, 99, 235, 255))
                        ) {
                            Text(
                                text = "SUBMIT",
                                textAlign = TextAlign.Center,
                                lineHeight = 18.sp,
                                color = Color.White,
                            )
                        }

                        FullPurpleButton(
                            ButtonPadding = PaddingValues(
                                start = 20.dp,
                                end = 20.dp
                            ),
                            ButtonLabel = "SUBMIT",
                            ButtonLabelFontSize = 18,
                            ButtonColor = Color(163, 99, 235, 255),
                            ButtonHeight = 60,
                            ContentPadding = PaddingValues(
                                start = 35.dp,
                                end = 35.dp,
                                top = 5.dp,
                                bottom = 5.dp
                            ),
                            OnClick = {

                            }
                        )

                    }

                    Box(
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            modifier = Modifier.padding(top = 5.dp),
                            text = "Don't remember your bike number?",
                            color = Color(134, 94, 181, 255),
                            fontSize = 11.sp
                        )
                    }

                }
            }
        }


        BlueTopAppBar(Heading = "Bike Insurance")
    }
}

@Preview
@Composable
fun PreviewBike() {
    PhonepeCloneTheme {
        BikeScreen()
    }
}