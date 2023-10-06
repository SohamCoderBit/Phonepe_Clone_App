package com.example.phonepeclone.ui.theme.Screens.RechargeAndBillScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.phonepeclone.HeadingText
import com.example.phonepeclone.R
import com.example.phonepeclone.RowWithDividerElements
import com.example.phonepeclone.SurfaceInView
import com.example.phonepeclone.topAppBarWithSearchBar
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme


@Composable
fun BillersList() {
    val iconboxmodifier: Modifier = Modifier
        .size(45.dp)
        .clip(CircleShape)
        .background(Color.White)

    RowWithDividerElements(
        Content = "DGVCL Dakshin Gujarat Vij",
        IconSource = R.drawable.building_columns_solid,
        IconBoxModifier = iconboxmodifier
    )
    RowWithDividerElements(
        Content = "Gift Power Companny Limited",
        IconSource = R.drawable.building_columns_solid,
        IconBoxModifier = iconboxmodifier
    )
    RowWithDividerElements(
        Content = "MGVCL Madhya Gujarat Vij",
        IconSource = R.drawable.building_columns_solid,
        IconBoxModifier = iconboxmodifier
    )
    RowWithDividerElements(
        Content = "PGVCL Paschim Gujarat Vij",
        IconSource = R.drawable.building_columns_solid,
        IconBoxModifier = iconboxmodifier
    )
    RowWithDividerElements(
        Content = "Torrent Power",
        IconSource = R.drawable.building_columns_solid,
        IconBoxModifier = iconboxmodifier
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ElectricityScreen() {

    var searchtextfromuser by remember {
        mutableStateOf("")
    }

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = colorResource(id = R.color.background)
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(top = 70.dp)
        ) {
            SurfaceInView(Height = 130) {

            }
            SurfaceInView(Height = 800) {

                Column{
                    HeadingText(
                        HeadingText = "Billers in Gujarat",
                        HeadingTextFontWeight = FontWeight.Normal,
                        SurfacePadding = PaddingValues(start = 15.dp, top = 10.dp)
                    )
                    BillersList()
                }
            }
        }
    }

    searchtextfromuser = topAppBarWithSearchBar(PlaceHolder = "Search by billers")
}


@Preview
@Composable
fun PreviewElectricity() {
    PhonepeCloneTheme {
        ElectricityScreen()
    }
}
