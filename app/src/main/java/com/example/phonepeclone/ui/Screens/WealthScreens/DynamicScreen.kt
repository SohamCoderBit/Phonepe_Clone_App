package com.example.phonepeclone.ui.Screens.WealthScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.phonepeclone.BlueTopAppBar
import com.example.phonepeclone.R
import com.example.phonepeclone.SurfaceInView
import com.example.phonepeclone.ViewModels.TopCompaniesViewModel
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme

@Composable
fun DynamicScreen(topCompaniesViewModel: TopCompaniesViewModel) {

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = colorResource(id = R.color.background)
    ) {

        Column(modifier = Modifier.padding(top = 70.dp)){
            SurfaceInView {
                Row {

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(80.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            modifier = Modifier
                                .height(60.dp),
                            painter = painterResource(id = R.mipmap.icici_fund_foreground),
                            contentDescription = null
                        )
                    }

                    Box(
                        modifier = Modifier
                            .weight(3f)
                            .height(80.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Column {
                            Text(
                                text = topCompaniesViewModel.getString(),
                                color = Color.White,
                                fontSize = 16.sp
                            )
                        }
                    }

                    Box(
                        modifier = Modifier
                            .weight(0.8f)
                            .height(80.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier
                                .height(15.dp),
                            painter = painterResource(id = R.drawable.info_logo),
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }
            }
        }

        BlueTopAppBar(Heading = "Invest Amount")
    }
}


@Preview
@Composable
fun PreviewDynamicScreen() {
    PhonepeCloneTheme {
        DynamicScreen(viewModel())
    }
}

