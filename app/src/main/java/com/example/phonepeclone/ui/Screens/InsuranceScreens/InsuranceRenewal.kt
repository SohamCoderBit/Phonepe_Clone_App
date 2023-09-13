package com.example.phonepeclone.ui.Screens.InsuranceScreens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.phonepeclone.HeadingTextInSurfaceView
import com.example.phonepeclone.R
import com.example.phonepeclone.SurfaceInView
import com.example.phonepeclone.topAppBarWithSearchBar
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme

@Composable
fun InsuranceRenewalScreen()
{

    var searchtextfromuser by remember {
        mutableStateOf("")
    }

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = colorResource(id = R.color.background)
    ){

        Column(modifier = Modifier.padding(top = 70.dp)){
            SurfaceInView {
                HeadingTextInSurfaceView(HeadingText = "All billers")
            }
        }

        searchtextfromuser = topAppBarWithSearchBar(PlaceHolder = "Search bu insurance provider")
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewInsuranceScreen()
{
    PhonepeCloneTheme {
        InsuranceRenewalScreen()
    }
}