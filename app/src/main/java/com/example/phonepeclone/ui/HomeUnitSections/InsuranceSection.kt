package com.example.phonepeclone.ui.theme.HomeUnitSections

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.phonepeclone.DrawIconInRow
import com.example.phonepeclone.HeadingTextInSurfaceView
import com.example.phonepeclone.Insurance
import com.example.phonepeclone.R
import com.example.phonepeclone.WriteLabelInRow
import com.example.phonepeclone.mainNavController
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme


@Composable
fun InsuranceSection() {
    Column {
        Row {
            HeadingTextInSurfaceView(
                HeadingText = "Insurance",
                SurfacePadding = PaddingValues(start = 20.dp, top = 10.dp),
                HeadingTextFontWeight = FontWeight.Normal
            )
        }
        val boxmodifier: Modifier = Modifier
            .size(60.dp)
            .clip(RoundedCornerShape(25.dp))

        //Bike , Car , Health , Accident
        //Insurance Section Icon Row 1
        Row(modifier = Modifier.padding(top = 15.dp)) {
            val surfacemodifier: Modifier = Modifier.weight(1f)

            //Bike Insurance
            DrawIconInRow(
                SurfaceModifier = surfacemodifier,
                BoxModifier = boxmodifier.clickable {

                },
                IconSize = 55,
                IconResource = R.drawable.motorcycle_svgrepo_com
            )

            //Car Insurance
            DrawIconInRow(
                SurfaceModifier = surfacemodifier,
                BoxModifier = boxmodifier.clickable {

                },
                IconSize = 55,
                IconResource = R.drawable.hatchback_5035167
            )

            //Health
            DrawIconInRow(
                SurfaceModifier = surfacemodifier,
                BoxModifier = boxmodifier.clickable {

                },
                IconSize = 45,
                IconResource = R.drawable.heart_logo
            )

            //Accident
            DrawIconInRow(
                SurfaceModifier = surfacemodifier,
                BoxModifier = boxmodifier.clickable {

                },
                IconSize = 50,
                IconResource = R.drawable.patient_469444
            )
        }

        Row {

            val surfacemodifier: Modifier = Modifier.weight(1f)

            //Bike
            WriteLabelInRow(modifier = surfacemodifier, label = "Bike")

            //Car
            WriteLabelInRow(modifier = surfacemodifier, label = "Car")

            //Health
            WriteLabelInRow(modifier = surfacemodifier, label = "Health")

            //Accident
            WriteLabelInRow(modifier = surfacemodifier, label = "Accident")
        }


        //Term Life , Travel , Insurance Renewal , See All
        //Insurance Section Icon Row 2
        Row(modifier = Modifier.padding(top = 15.dp)) {
            val surfacemodifier: Modifier = Modifier.weight(1f)

            //Term Life
            DrawIconInRow(
                SurfaceModifier = surfacemodifier,
                BoxModifier = boxmodifier.clickable {

                },
                IconSize = 45,
                IconResource = R.drawable.hands
            )

            //Travel Insurance
            DrawIconInRow(
                SurfaceModifier = surfacemodifier,
                BoxModifier = boxmodifier.clickable {

                },
                IconSize = 55,
                IconResource = R.drawable.reshot_icon_travel_abroad_uhrq52ydg4
            )


            //Insurance Renewal
            DrawIconInRow(
                SurfaceModifier = surfacemodifier,
                BoxModifier = boxmodifier.clickable {

                },
                IconSize = 50,
                IconResource = R.drawable.reshot_icon_repeat_egdzcp9q2s
            )


            //See All Button
            Surface(
                modifier = surfacemodifier
                    .padding(start = 20.dp, end = 20.dp),
                color = Color.Transparent
            )
            {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = boxmodifier,
                        contentAlignment = Alignment.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .size(45.dp)
                                .clip(RoundedCornerShape(15.dp))
                                .background(colorResource(id = R.color.TMS_Icon))
                                .clickable { mainNavController.navigateTo(Route = Insurance.ROUTE) },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                modifier = Modifier
                                    .height(20.dp)
                                    .width(20.dp),
                                painter = painterResource(R.drawable.chevron_right_solid),
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    }
                }
            }
        }

        Row {

            val surfacemodifier: Modifier = Modifier.weight(1f)
            //Term \n Life
            WriteLabelInRow(modifier = surfacemodifier, label = "Term Life")

            //Travel
            WriteLabelInRow(modifier = surfacemodifier, label = "Travel")

            //Insurance \n Renewal
            WriteLabelInRow(modifier = surfacemodifier, label = "Insurance Renewal")

            //See All
            WriteLabelInRow(modifier = surfacemodifier, label = "See All")
        }
    }
}


@Preview
@Composable
fun PreviewInsuranceScreen()
{
    PhonepeCloneTheme {
        InsuranceSection()
    }
}
