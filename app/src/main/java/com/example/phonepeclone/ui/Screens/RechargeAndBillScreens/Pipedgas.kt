package com.example.phonepeclone.ui.Screens.RechargeAndBillScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.phonepeclone.DataListLayout
import com.example.phonepeclone.ViewModels.PipedgasViewModel

@Composable
fun PipedGasScreen(pipedgasViewModel: PipedgasViewModel) {

    val iconboxmodifier: Modifier = Modifier
        .size(45.dp)
        .clip(RoundedCornerShape(percent = 20))
        .background(Color.White)

    DataListLayout(
        topAppBarPlaceHolder = "Select Provider",
        billersList = pipedgasViewModel.getPipedGasBillerList(LocalContext.current),
        iconBoxModifier = iconboxmodifier
    )
}