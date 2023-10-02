package com.example.phonepeclone.ui.Screens.WealthScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.phonepeclone.BlueTopAppBar
import com.example.phonepeclone.HeadingTextInSurfaceView
import com.example.phonepeclone.R
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme

sealed class ExploreAllFundsBottomSheetScreens {
    object Category : ExploreAllFundsBottomSheetScreens()
    object Filter : ExploreAllFundsBottomSheetScreens()
    object Returns : ExploreAllFundsBottomSheetScreens()
}


@Composable
fun CategoryBottomSheetScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.fillMaxHeight(0.09f)) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.4f),
                contentAlignment = Alignment.Center
            ) {
                HeadingTextInSurfaceView(
                    HeadingText = "Category",
                    TextFontSize = 30,
                    HeadingTextFontWeight = FontWeight.Bold,
                    SurfacePadding = PaddingValues(0.dp)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.5f)
            ) {
                //CLEAR ALL Button
            }

        }

        Divider(color = colorResource(id = R.color.divider_color))

        Row(modifier = Modifier.fillMaxHeight(0.9f)) {
            Box(modifier = Modifier
                .weight(0.4f)
                .fillMaxHeight()
                .background(colorResource(id = R.color.layout_color_light_grey))) {
                    LazyColumn(userScrollEnabled = false){

                    }
            }
            Box(
                modifier = Modifier
                    .weight(0.5f)
                    .fillMaxHeight()
                    .background(colorResource(id = R.color.scrollable_view))
            ) {

            }
        }

        Divider(color = colorResource(id = R.color.divider_color))

        Row(modifier = Modifier.fillMaxHeight()) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.5f),
                contentAlignment = Alignment.Center
            ) {
                HeadingTextInSurfaceView(
                    HeadingText = "Category",
                    TextFontSize = 30,
                    HeadingTextFontWeight = FontWeight.Bold,
                    SurfacePadding = PaddingValues(0.dp)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.5f)
            ) {
                //CLEAR ALL Button
            }

        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExploreAllFundsScreen() {

    var currentBottomSheetScreen: ExploreAllFundsBottomSheetScreens? by remember {
        mutableStateOf(null)
    }

    val sheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Expanded)

    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetBackgroundColor = Color(33, 24, 43, 255),
        //Sheet Content
        sheetContent = {
            CategoryBottomSheetScreen()
        }
    ) {
        BlueTopAppBar(Heading = "All Funds")
    }

}

@Preview
@Composable
fun PreviewExploreAllFund() {
    PhonepeCloneTheme {
        ExploreAllFundsScreen()
    }
}

