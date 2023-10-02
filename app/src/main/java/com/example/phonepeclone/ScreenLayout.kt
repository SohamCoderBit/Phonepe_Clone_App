package com.example.phonepeclone

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp

@Composable
fun DataListLayout(content: @Composable () -> Unit, topAppBarPlaceHolder: String) {
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
                .padding(top = 70.dp)
                .fillMaxHeight()
                .verticalScroll(rememberScrollState())
        ) {
            SurfaceInView(modifier = Modifier.fillMaxHeight()) {
                Column {
                    HeadingTextInSurfaceView(
                        HeadingText = "Billers In Gujarat",
                        SurfacePadding = PaddingValues(start = 20.dp, top = 10.dp, bottom = 10.dp)
                    )
                    content()
                }

            }
        }

        searchtextfromuser = topAppBarWithSearchBar(PlaceHolder = topAppBarPlaceHolder)
    }
}
