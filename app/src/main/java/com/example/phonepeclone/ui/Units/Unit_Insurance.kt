package com.example.phonepeclone.ui.theme.Units

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.LocalTextStyle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.phonepeclone.DrawIconInRow
import com.example.phonepeclone.HeadingTextInSurfaceView
import com.example.phonepeclone.Insurance
import com.example.phonepeclone.R
import com.example.phonepeclone.SurfaceInView
import com.example.phonepeclone.WriteLabelInRow
import com.example.phonepeclone.mainNavController
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InsuranceUnit() {


    var textfromuser by remember {
        mutableStateOf("")
    }


    val boxmodifier: Modifier = Modifier
        .size(60.dp)
        .clip(RoundedCornerShape(25.dp))


    Column(
        modifier = Modifier
            .padding(top = 70.dp , bottom = 70.dp)
            .fillMaxSize()
            .verticalScroll(
                rememberScrollState()
            )
    ) {


        SurfaceInView(Height = 135) {
            Text(
                modifier = Modifier.padding(top = 40.dp),
                text = "Insurance Unit",
                color = Color.White,
                fontSize = 30.sp,
                textAlign = TextAlign.Center
            )
        }

        SurfaceInView(Height = 290) {
            Column {
                Surface(
                    modifier = Modifier
                        .height(150.dp)
                        .fillMaxWidth()
                        .padding(top = 5.dp, start = 5.dp, end = 5.dp),
                    color = Color(35, 50, 79, 255),
                    shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)
                ) {

                    //Heading Vehicle Insurance
                    Row {
                        HeadingTextInSurfaceView(
                            HeadingText = "Vehicle Insurance",
                            TextFontSize = 18,
                            SurfacePadding = PaddingValues(start = 20.dp, top = 15.dp)
                        )
                    }


                    Box(
                        contentAlignment = Alignment.Center
                    ) {

                        //Enter Vehicle Number (Text field)
                        OutlinedTextField(
                            modifier = Modifier
                                .padding(start = 20.dp, top = 50.dp, bottom = 20.dp, end = 20.dp)
                                .height(80.dp)
                                .fillMaxWidth(),
                            value = textfromuser,
                            onValueChange = { if (it.length <= 10) textfromuser = it },
                            colors = TextFieldDefaults.textFieldColors(
                                textColor = Color.White,
                                containerColor = Color(33, 24, 43, 255)
                            ),
                            placeholder = {
                                Text(
                                    text = "Enter Vehicle\nNumber",
                                    fontSize = 18.sp,
                                    lineHeight = 20.sp
                                )
                            },
                            maxLines = 1,
                            textStyle = LocalTextStyle.current.copy(fontSize = 20.sp),
                            shape = RoundedCornerShape(15),
                            singleLine = true

                        )

                        //VIEW QUOTES Button
                        Button(
                            modifier = Modifier
                                .padding(start = 175.dp, top = 29.dp)
                                .height(35.dp),
                            onClick = { println(textfromuser) },
                            colors = ButtonDefaults.outlinedButtonColors(Color(163, 99, 235, 255)),
                            shape = RoundedCornerShape(50),
                            contentPadding = PaddingValues(
                                start = 15.dp,
                                top = 1.dp,
                                bottom = 1.dp,
                                end = 15.dp
                            )
                        ) {
                            Text(text = "VIEW QUOTES", color = Color.White, fontSize = 14.sp)
                        }
                    }
                }

                //Heading Motor And Travel
                Row {
                    HeadingTextInSurfaceView(
                        HeadingText = "Motor and Travel",
                        SurfacePadding = PaddingValues(start = 20.dp, top = 10.dp),
                        HeadingTextFontWeight = FontWeight.Normal
                    )
                }

                Row(modifier = Modifier.padding(top = 5.dp)) {
                    val surfacemodifier: Modifier = Modifier.weight(1f)

                    //Bike Insurance
                    DrawIconInRow(
                        SurfaceModifier = surfacemodifier,
                        BoxModifier = boxmodifier.clickable {
                            mainNavController.navigateTo(Route = Insurance.BIKE_SCREEN)
                        },
                        IconSize = 55,
                        IconTint = Color(144, 93, 198, 255),
                        IconResource = R.drawable.motorcycle_svgrepo_com
                    )

                    //Car Insurance
                    DrawIconInRow(
                        SurfaceModifier = surfacemodifier,
                        BoxModifier = boxmodifier.clickable {
                            mainNavController.navigateTo(Route = Insurance.CAR_SCREEN)
                        },
                        IconSize = 55,
                        IconResource = R.drawable.hatchback_5035167
                    )

                    //Travel
                    DrawIconInRow(
                        SurfaceModifier = surfacemodifier,
                        BoxModifier = boxmodifier.clickable {
                            mainNavController.navigateTo(Route = Insurance.TRAVEL_SCREEN)
                        },
                        IconSize = 55,
                        IconResource = R.drawable.reshot_icon_travel_abroad_uhrq52ydg4
                    )

                    //TransParent
                    DrawIconInRow(
                        SurfaceModifier = surfacemodifier,
                        IconSize = 50,
                        IconTint = Color.Transparent,
                        IconResource = R.drawable.money_bill_solid
                    )
                }

                Row {

                    val surfacemodifier: Modifier = Modifier.weight(1f)

                    //Bike
                    WriteLabelInRow(modifier = surfacemodifier, label = "Bike")

                    //Car
                    WriteLabelInRow(modifier = surfacemodifier, label = "Car")

                    //Travel
                    WriteLabelInRow(modifier = surfacemodifier, label = "Travel")

                    //Transparent
                    WriteLabelInRow(modifier = surfacemodifier, label = "")

                }
            }
        }

        SurfaceInView(Height = 150) {
            Column {
                //Heading Health and Life
                HeadingTextInSurfaceView(
                    HeadingText = "Health and Life",
                    HeadingTextFontWeight = FontWeight.Normal,
                    SurfacePadding = PaddingValues(start = 20.dp, top = 10.dp)
                )


                Row(modifier = Modifier.padding(top = 15.dp)) {
                    val surfacemodifier: Modifier = Modifier.weight(1f)

                    //Health
                    DrawIconInRow(
                        SurfaceModifier = surfacemodifier,
                        BoxModifier = boxmodifier.clickable {
                            mainNavController.navigateTo(Route = Insurance.HEALTH_SCREEN)
                        },
                        IconSize = 45,
                        IconResource = R.drawable.heart_logo,
                    )

                    //Super Top-Up
                    DrawIconInRow(
                        SurfaceModifier = surfacemodifier,
                        BoxModifier = boxmodifier.clickable {

                        },
                        IconSize = 45,
                        IconResource = R.drawable.super_top_up_logo,
                    )

                    //Team Life
                    DrawIconInRow(
                        SurfaceModifier = surfacemodifier,
                        BoxModifier = boxmodifier,
                        IconSize = 45,
                        IconResource = R.drawable.hands,
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
                    WriteLabelInRow(modifier = surfacemodifier, label = "Health")

                    //Super Top-Up
                    WriteLabelInRow(modifier = surfacemodifier, label = "Super Top-Up")

                    //Term Life
                    WriteLabelInRow(modifier = surfacemodifier, label = "Term Life")

                    //Accident
                    WriteLabelInRow(modifier = surfacemodifier, label = "Accident")

                }
            }
        }
    }
}


@Preview
@Composable
fun PreviewInsuranceUnit() {
    PhonepeCloneTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = colorResource(id = R.color.background)
        ) {
            Column(
                modifier = Modifier
                    .verticalScroll(
                        rememberScrollState()
                    )
                    .padding(top = 70.dp, bottom = 80.dp)
            ) {
                InsuranceUnit()
            }
        }
    }
}