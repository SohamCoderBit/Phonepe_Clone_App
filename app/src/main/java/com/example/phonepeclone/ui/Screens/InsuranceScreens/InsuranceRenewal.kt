package com.example.phonepeclone.ui.Screens.InsuranceScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.phonepeclone.HeadingTextInSurfaceView
import com.example.phonepeclone.R
import com.example.phonepeclone.RowWithDividerElements
import com.example.phonepeclone.SurfaceInView
import com.example.phonepeclone.ViewModels.InsuranceRenewalViewModel
import com.example.phonepeclone.topAppBarWithSearchBar
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme

@Composable
fun InsuranceRenewalScreen(insuranceRenewalViewModel: InsuranceRenewalViewModel) {

    var searchtextfromuser by remember {
        mutableStateOf("")
    }

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = colorResource(id = R.color.background)
    ) {

        Column(modifier = Modifier.padding(top = 70.dp)) {
            SurfaceInView(modifier = Modifier.fillMaxHeight()) {
                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                    HeadingTextInSurfaceView(
                        HeadingText = "All billers",
                        SurfacePadding = PaddingValues(start = 20.dp, top = 10.dp, bottom = 10.dp)
                    )

                    val iconboxmodifier: Modifier = Modifier
                        .size(45.dp)
                        .clip(RoundedCornerShape(percent = 20))
                        .background(Color.White)

                    insuranceRenewalViewModel.getInsuranceRenewalBillersList(LocalContext.current)
                        .forEach { item ->
                            RowWithDividerElements(
                                Content = item.BillerName,
                                IconSource = R.drawable.building_columns_solid,
                                IconBoxModifier = iconboxmodifier,
                                IconTint = Color.LightGray
                            )
                        }
                }

            }
        }

        searchtextfromuser = topAppBarWithSearchBar(PlaceHolder = "Search by insurance provider")
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewInsuranceScreen() {
    PhonepeCloneTheme {
        InsuranceRenewalScreen(viewModel())
    }
}