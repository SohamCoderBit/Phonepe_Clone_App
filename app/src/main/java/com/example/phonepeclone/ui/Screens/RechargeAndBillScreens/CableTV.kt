package com.example.phonepeclone.ui.Screens.RechargeAndBillScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.phonepeclone.DataListLayout
import com.example.phonepeclone.ViewModels.CableTvViewModel
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme

@Composable
fun CableTVScreen(cableTvViewModel: CableTvViewModel)
{

    val iconboxmodifier: Modifier = Modifier
        .size(45.dp)
        .clip(RoundedCornerShape(percent = 20))
        .background(Color.White)

    DataListLayout(
        topAppBarPlaceHolder = "Type your Cable Tv Operator's Name",
        billersList = cableTvViewModel.getList(LocalContext.current),
        iconBoxModifier = iconboxmodifier
    )
}


@Preview
@Composable
fun PreviewCabelTvScreen()
{
    PhonepeCloneTheme {
        CableTVScreen(cableTvViewModel = viewModel())
    }
}
