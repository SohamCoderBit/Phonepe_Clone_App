package com.example.phonepeclone.ui.Screens.WealthScreens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.phonepeclone.R
import com.example.phonepeclone.ViewModels.TopCompaniesViewModel
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme

@Composable
fun DynamicScreen(topCompaniesViewModel: TopCompaniesViewModel) {

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = colorResource(id = R.color.background)
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = topCompaniesViewModel.getString(), color = Color.White , fontSize = 30.sp)
        }
    }
}


@Preview
@Composable
fun PreviewDynamicScreen() {
    PhonepeCloneTheme {
        DynamicScreen(viewModel())
    }
}

