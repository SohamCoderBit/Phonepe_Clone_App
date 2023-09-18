package com.example.phonepeclone.ui.theme.HomeUnitSections

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.phonepeclone.NavigationDestinations
import com.example.phonepeclone.R
import com.example.phonepeclone.navController


@Composable
fun DrawIconInTransferMoneySection(
    modifier: Modifier,
    BoxModifier: Modifier,
    Size:Int,
    StartPadding: Int,
    Endpadding: Int,
    IconTint:Color ,
    IconResource: Int,
    IconDecription: String,
    ClickEventAction: () -> Unit
) {
    Surface(
        modifier = modifier
            .padding(start = StartPadding.dp, end = Endpadding.dp),
        color = Color.Transparent
    )
    {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = BoxModifier
                    .clickable { ClickEventAction() },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier
                        .height(Size.dp)
                        .width(Size.dp),
                    painter = painterResource(IconResource),
                    contentDescription = null,
                    tint = IconTint
                )
            }



                Box(
                    modifier = Modifier.fillMaxWidth()
                        .padding(top = 3.dp),
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = IconDecription,
                        lineHeight = 14.sp,
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                }
        }
    }
}


@Composable
fun TransferMoneysection() {

    val boxmodifier: Modifier = Modifier
        .size(60.dp)
        .clip(RoundedCornerShape(25.dp))
        .background(colorResource(id = R.color.TMS_Icon))

    Row(modifier = Modifier.padding(top = 15.dp)){
        val modifier = Modifier.weight(1f)

        //To Mobile Number
        DrawIconInTransferMoneySection(
            modifier = modifier,
            BoxModifier = boxmodifier,
            Size = 30,
            StartPadding = 20,
            Endpadding = 15,
            IconTint = Color.White,
            IconResource = R.drawable.user_regular,
            IconDecription = "To Mobile Number",
            ClickEventAction = { navController.navigateTo(Route = NavigationDestinations.MOBILE_NUMBER_SCREEN_ROUTE) }
        )

        //To Bank
        DrawIconInTransferMoneySection(
            modifier = modifier,
            BoxModifier = boxmodifier,
            Size = 30,
            StartPadding = 20,
            Endpadding = 15,
            IconTint = Color.White,
            IconResource = R.drawable.building_columns_solid,
            IconDecription = "To Bank/UPI ID",
            ClickEventAction = { navController.navigateTo(Route = NavigationDestinations.BANK_SCREEN_ROUTE) }
        )

        //To Self Account
        DrawIconInTransferMoneySection(
            modifier = modifier,
            BoxModifier = boxmodifier,
            Size = 30,
            StartPadding = 20,
            Endpadding = 15,
            IconTint = Color.White,
            IconResource = R.drawable.arrow_down_to_arc,
            IconDecription = "To Self Account",
            ClickEventAction = { navController.navigateTo(Route = NavigationDestinations.SELF_ACCOUNT_ROUTE) }
        )

        //Check Balance
        DrawIconInTransferMoneySection(
            modifier = modifier,
            BoxModifier = boxmodifier,
            Size = 30,
            StartPadding = 15,
            Endpadding = 20,
            IconTint = Color.White,
            IconResource = R.drawable.money_bill_solid,
            IconDecription = "Check Balance",
            ClickEventAction = { navController.navigateTo(Route = NavigationDestinations.CHECK_BALANCE_SCREEN_ROUTE) }
        )
    }

}
