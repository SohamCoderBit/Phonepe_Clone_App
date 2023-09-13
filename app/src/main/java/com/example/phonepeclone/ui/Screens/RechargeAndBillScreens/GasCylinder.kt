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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.phonepeclone.BlueTopAppBar
import com.example.phonepeclone.HeadingTextInSurfaceView
import com.example.phonepeclone.R
import com.example.phonepeclone.RowWithDividerElements
import com.example.phonepeclone.SurfaceInView
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme


@Composable
fun GasCylinderProviderList() {
    val iconboxmodifier: Modifier = Modifier
        .size(45.dp)
        .clip(CircleShape)
        .background(Color.White)

    RowWithDividerElements(
        Content = "Bharat Gas",
        IconSource = R.drawable.building_columns_solid,
        IconBoxModifier = iconboxmodifier
    )
    RowWithDividerElements(
        Content = "Bharat Gas - Commercial",
        IconSource = R.drawable.building_columns_solid,
        IconBoxModifier = iconboxmodifier
    )
    RowWithDividerElements(
        Content = "HP Gas",
        IconSource = R.drawable.building_columns_solid,
        IconBoxModifier = iconboxmodifier
    )
    RowWithDividerElements(
        Content = "Indane Gas (Indian Oil)",
        IconSource = R.drawable.building_columns_solid,
        IconBoxModifier = iconboxmodifier
    )
}


@Composable
fun GasCylinderScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = colorResource(id = R.color.background)
    ) {


        Column(modifier = Modifier.padding(top = 70.dp)) {
            SurfaceInView(Height = 380) {
                Column {
                    Row {
                        HeadingTextInSurfaceView(
                            HeadingText = "All Billers",
                            SurfacePadding = PaddingValues(start = 20.dp, top = 10.dp)
                        )
                    }

                    GasCylinderProviderList()
                }
            }
        }

        BlueTopAppBar(Heading = "Select Your Gas Provider")
    }
}


@Preview
@Composable
fun PreviewGas() {
    PhonepeCloneTheme {
        GasCylinderScreen()
    }
}
