package com.example.phonepeclone.ui.theme.Screens.RechargeAndBillScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.phonepeclone.BlueTopAppBar
import com.example.phonepeclone.HeadingText
import com.example.phonepeclone.R
import com.example.phonepeclone.RowWithDividerElements
import com.example.phonepeclone.SurfaceInView
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme


@Composable
fun DTHBillerList() {
    val iconboxmodifier: Modifier = Modifier
        .size(45.dp)
        .clip(CircleShape)
        .background(Color.White)

    RowWithDividerElements(
        Content = "Airtel Digital TV",
        IconSource = R.drawable.building_columns_solid,
        IconBoxModifier = iconboxmodifier
    )
    RowWithDividerElements(
        Content = "Dish TV",
        IconSource = R.drawable.building_columns_solid,
        IconBoxModifier = iconboxmodifier
    )
    RowWithDividerElements(
        Content = "Sun Direct",
        IconSource = R.drawable.building_columns_solid,
        IconBoxModifier = iconboxmodifier
    )
    RowWithDividerElements(
        Content = "Tata Play (Formerly Tata Sky)",
        IconSource = R.drawable.building_columns_solid,
        IconBoxModifier = iconboxmodifier
    )
    RowWithDividerElements(
        Content = "D2H",
        IconSource = R.drawable.building_columns_solid,
        IconBoxModifier = iconboxmodifier
    )
}


@Composable
fun DTHScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = colorResource(id = R.color.background)
    ) {


        Column(modifier = Modifier.padding(top = 70.dp)) {
            SurfaceInView(Height = 465) {
                Column {
                    Row {
                        HeadingText(
                            HeadingText = "All Billers",
                            TextFontSize = 16,
                            SurfacePadding = PaddingValues(start = 20.dp, top = 10.dp),
                            HeadingTextFontWeight = FontWeight.Normal
                        )
                    }
                    DTHBillerList()
                }
            }
        }

        BlueTopAppBar(Heading = "Select Provider")
    }
}

@Preview
@Composable
fun Previewdth() {
    PhonepeCloneTheme {
        DTHScreen()
    }
}
