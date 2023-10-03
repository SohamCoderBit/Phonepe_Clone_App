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
import com.example.phonepeclone.ViewModels.WaterViewModel

@Composable
fun WaterScreen(waterViewModel: WaterViewModel)
{

    val iconboxmodifier: Modifier = Modifier
        .size(45.dp)
        .clip(RoundedCornerShape(percent = 20))
        .background(Color.White)

    DataListLayout(
        topAppBarPlaceHolder = "Search By Biller",
        billersList = waterViewModel.getWaterBillerList(LocalContext.current),
        iconBoxModifier = iconboxmodifier
    )
}