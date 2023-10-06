package com.example.phonepeclone.ui.theme.HomeUnitSections

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.phonepeclone.DrawIconInRow
import com.example.phonepeclone.HeadingText
import com.example.phonepeclone.R
import com.example.phonepeclone.SurfaceInView
import com.example.phonepeclone.WriteLabelInRow
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme


@Composable
fun TravelBookingSection()
{
    val boxmodifier: Modifier = Modifier
        .size(60.dp)
    Column {
        HeadingText(
            HeadingText = "Travel Booking",
            SurfacePadding = PaddingValues(start = 20.dp, top = 10.dp),
            HeadingTextFontWeight = FontWeight.Normal
        )


        //Travel Booking Section Icons in Row
        Row(modifier = Modifier.padding(top = 10.dp)){
            val surfacemodifier:Modifier = Modifier.weight(1f)
            //Flights
            DrawIconInRow(
                SurfaceModifier = surfacemodifier,
                BoxModifier = boxmodifier,
                IconSize = 40,
                IconResource = R.drawable.plane_solid
            )

            //Bus
            DrawIconInRow(
                SurfaceModifier = surfacemodifier,
                BoxModifier = boxmodifier,
                IconSize = 40,
                IconResource = R.drawable.bus_solid
            )


            //Trains
            DrawIconInRow(
                SurfaceModifier = surfacemodifier,
                BoxModifier = boxmodifier,
                IconSize = 40,
                IconResource = R.drawable.train_solid
            )

            //Hotels
            DrawIconInRow(
                SurfaceModifier = surfacemodifier,
                BoxModifier = boxmodifier,
                IconSize = 40,
                IconResource = R.drawable.hotel_solid
            )
        }


        //Text Under their Icons
        Row{
            val surfacemodifier:Modifier = Modifier.weight(1f)

            //Flights
            WriteLabelInRow(modifier = surfacemodifier, label = "Flights")

            //Bus
            WriteLabelInRow(modifier = surfacemodifier, label = "Bus")

            //Trains
            WriteLabelInRow(modifier = surfacemodifier, label = "Trains")

            //Hotels
            WriteLabelInRow(modifier = surfacemodifier, label = "Hotels")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewTravel()
{
    PhonepeCloneTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = colorResource(id = R.color.background)
        ) {
            Column {
                SurfaceInView(Height = 300) {
                    TravelBookingSection()
                }
            }

        }
    }
}

