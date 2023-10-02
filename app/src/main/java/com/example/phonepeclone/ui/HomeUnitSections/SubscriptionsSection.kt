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
import com.example.phonepeclone.HeadingTextInSurfaceView
import com.example.phonepeclone.R
import com.example.phonepeclone.SeeAllButton
import com.example.phonepeclone.SurfaceInView
import com.example.phonepeclone.WriteLabelInRow
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme


@Composable
fun SubscriptionSection() {
    val boxmodifier: Modifier = Modifier
        .size(60.dp)
        .clip(RoundedCornerShape(25.dp))

    val iconboxmodifier: Modifier = Modifier
        .size(45.dp)
        .clip(RoundedCornerShape(15.dp))
    Column {
        HeadingTextInSurfaceView(
            HeadingText = "Subscriptions",
            SurfacePadding = PaddingValues(start = 20.dp, top = 10.dp),
            HeadingTextFontWeight = FontWeight.Normal
        )

        //Switch Section Icon in Row
        Row(modifier = Modifier.padding(top = 5.dp)) {
            val surfacemodifier: Modifier = Modifier.weight(1f)

            //Hotstar
            DrawIconInRow(
                SurfaceModifier = surfacemodifier,
                BoxModifier = boxmodifier,
                IconBoxModifier = iconboxmodifier.clickable {},
                IconBoxColor = Color(28, 58, 131, 255),
                IconSize = 45,
                IconTint = Color.White,
                IconResource = R.drawable.disney__hotstar
            )

            //Amazon Prime
            DrawIconInRow(
                SurfaceModifier = surfacemodifier,
                BoxModifier = boxmodifier,
                IconBoxModifier = iconboxmodifier.clickable {},
                IconBoxColor = Color.White,
                IconSize = 30,
                IconTint = Color.Unspecified,
                IconResource = R.drawable.amazon_prime_icon
            )


            //zee5
            DrawIconInRow(
                SurfaceModifier = surfacemodifier,
                BoxModifier = boxmodifier,
                IconBoxModifier = iconboxmodifier.clickable {},
                IconBoxColor = Color.Black,
                IconSize = 35,
                IconTint = Color.Unspecified,
                IconResource = R.drawable.zee5_seeklogo_com
            )

            //See All Button
            SeeAllButton(modifier = surfacemodifier, boxmodifier = boxmodifier)

        }


        //Text Under Their Icons Which Are in The Row
        Row(modifier = Modifier.padding(bottom = 5.dp)) {

            val surfacemodifier: Modifier = Modifier.weight(1f)

            //Hotstar
            WriteLabelInRow(modifier = surfacemodifier, label = "Hotstar")

            //Amazon\nPrime
            WriteLabelInRow(modifier = surfacemodifier, label = "Amazon\nPrime")

            //Zee5
            WriteLabelInRow(modifier = surfacemodifier, label = "Zee5")

            //See All
            WriteLabelInRow(modifier = surfacemodifier, label = "See All")
        }

    }
}

@Preview
@Composable
fun PreviewSubscriptions() {
    PhonepeCloneTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = colorResource(id = R.color.background)
        ) {
            Column {
                SurfaceInView {
                    SubscriptionSection()
                }
            }

        }
    }
}
