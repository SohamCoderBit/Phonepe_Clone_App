package com.example.phonepeclone.ui.Screens.InsuranceScreens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.phonepeclone.BlueTopAppBar
import com.example.phonepeclone.FullPurpleButton
import com.example.phonepeclone.HeadingText
import com.example.phonepeclone.R
import com.example.phonepeclone.SurfaceInView
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme

@Composable
fun TravelScreen()
{
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = colorResource(id = R.color.background)
    ){

        Column(modifier = Modifier.padding(top = 70.dp)) {
            SurfaceInView {
                Column{
                    HeadingText(HeadingText = "Stay Secure on your next trip abroad")

                    HeadingText(
                        HeadingText = "Includes Covid-19 coverage & 24/7 customer support with Allianz Assist",
                        TextFontSize = 14,
                        HeadingTextFontWeight = FontWeight.Light,
                        HeadingTextLineHeight = 14.sp,
                        SurfacePadding = PaddingValues(start = 20.dp ,top = 5.dp)
                    )

                    FullPurpleButton(
                        ButtonPadding = PaddingValues(20.dp),
                        ButtonLabel = "GET A QUOTE",
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
            }
        }

        BlueTopAppBar(Heading = "International Travel In...")
    }
}

@Preview
@Composable
fun PreviewTravelScreen()
{
    PhonepeCloneTheme {
        TravelScreen()
    }
}
