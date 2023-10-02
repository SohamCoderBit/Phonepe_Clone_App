package com.example.phonepeclone.ui.Screens.RechargeAndBillScreens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.phonepeclone.BlueTopAppBar
import com.example.phonepeclone.HeadingTextInSurfaceView
import com.example.phonepeclone.R
import com.example.phonepeclone.SurfaceInView
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme

@Composable
fun ApartmentScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = colorResource(id = R.color.background)
    ) {

        Column(modifier = Modifier.padding(top = 70.dp)) {
            SurfaceInView(Height = 300) {
                HeadingTextInSurfaceView(HeadingText = "Select state and city", TextFontSize = 18)
            }


        }

        BlueTopAppBar(Heading = "Apartments")
    }
}

@Preview
@Composable
fun PreviewApartmentScreen() {
    PhonepeCloneTheme {
        ApartmentScreen()
    }
}

