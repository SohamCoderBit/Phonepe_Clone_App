package com.example.phonepeclone.ui.theme.HomeUnitSections

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.phonepeclone.DrawIconInRow
import com.example.phonepeclone.HeadingText
import com.example.phonepeclone.R
import com.example.phonepeclone.SeeAllButton
import com.example.phonepeclone.SurfaceInView
import com.example.phonepeclone.WriteLabelInRow
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme


@Composable
fun SwitchSection() {
    val boxmodifier: Modifier = Modifier
        .size(60.dp)

    val iconboxModifier: Modifier = Modifier
        .size(45.dp)
        .clip(RoundedCornerShape(15.dp))
    Column {
        HeadingText(
            HeadingText = "Switch",
            SurfacePadding = PaddingValues(start = 20.dp, top = 10.dp),
            HeadingTextFontWeight = FontWeight.Normal
        )

        //Switch Section Icon in Row
        Row(modifier = Modifier.padding(top = 10.dp)) {
            val surfacemodifier: Modifier = Modifier.weight(1f)

            //Swiggy
            DrawIconInRow(
                SurfaceModifier = surfacemodifier,
                BoxModifier = boxmodifier,
                IconBoxModifier = iconboxModifier.clickable {
                    println("Swiggy")
                },
                IconBoxColor = Color(245, 120, 30, 255),
                IconSize = 35,
                IconTint = Color.White,
                IconResource = R.drawable.swiggy_1
            )

            //Tata 1mg
            DrawIconInRow(
                SurfaceModifier = surfacemodifier,
                BoxModifier = boxmodifier,
                IconBoxModifier = iconboxModifier.clickable {
                    println("Tata 1mg")
                },
                IconBoxColor = Color(251, 112, 99, 255),
                IconSize = 40,
                IconTint = Color.Black,
                IconResource = R.drawable._mg_logo_vector
            )


            //Pharmaeasy
            DrawIconInRow(
                SurfaceModifier = surfacemodifier,
                BoxModifier = boxmodifier,
                IconBoxModifier = iconboxModifier.clickable {
                    println("Pharmeasy")
                },
                IconBoxColor = Color(16, 132, 124, 255),
                IconSize = 40,
                IconTint = Color.White,
                IconResource = R.drawable.pharmaeasy
            )

            SeeAllButton(modifier = surfacemodifier, boxmodifier = boxmodifier)
        }

        //Text Under Their Icons Which Are in The Row
        Row {

            val surfacemodifier: Modifier = Modifier.weight(1f)

            //Swiggy
            WriteLabelInRow(modifier = surfacemodifier, label = "Swiggy")

            //Tata 1mg
            WriteLabelInRow(modifier = surfacemodifier, label = "Tata 1mg")

            //Pharmeasy
            WriteLabelInRow(modifier = surfacemodifier, label = "Pharmeasy")

            //See All
            WriteLabelInRow(modifier = surfacemodifier, label = "See All")
        }
    }
}


@Preview
@Composable
fun PreviewSwitchSection() {
    PhonepeCloneTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = colorResource(id = R.color.background)
        ) {
            Column {
                SurfaceInView(Height = 150) {
                    SwitchSection()
                }
            }
        }
    }
}

