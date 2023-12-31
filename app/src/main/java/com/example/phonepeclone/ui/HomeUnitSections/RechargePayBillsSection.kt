package com.example.phonepeclone.ui.theme.HomeUnitSections

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.phonepeclone.DrawIconInRow
import com.example.phonepeclone.HeadingText
import com.example.phonepeclone.Home
import com.example.phonepeclone.R
import com.example.phonepeclone.SeeAllButton
import com.example.phonepeclone.SurfaceInView
import com.example.phonepeclone.WriteLabelInRow
import com.example.phonepeclone.mainNavController
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme


@Composable
fun RechargePayBillSectionIcon() {

    val boxmodifier: Modifier = Modifier
        .size(60.dp)


    //Mobile Recharge , FASTag Recharge , Electricity , Credit Card Bill Payment
    //Recharge & Pay Bill Section Icon Row 1
    Row(modifier = Modifier.padding(top = 15.dp)) {
        val surfacemodifier: Modifier = Modifier.weight(1f)

        //Mobile Recharge
        DrawIconInRow(
            SurfaceModifier = surfacemodifier,
            BoxModifier = boxmodifier.clickable {
                mainNavController.navigateTo(Route = Home.MOBILE_RECHARGE_SCREEN)
            },
            IconSize = 45,
            IconResource = R.drawable.mobile,
        )

        //DTH Recharge
        DrawIconInRow(
            SurfaceModifier = surfacemodifier,
            BoxModifier = boxmodifier.clickable {
                mainNavController.navigateTo(Route = Home.DTH_SCREEN)
            },
            IconSize = 45,
            IconResource = R.drawable.dth_recharge,
        )

        //Electricity
        DrawIconInRow(
            SurfaceModifier = surfacemodifier,
            BoxModifier = boxmodifier.clickable {
                mainNavController.navigateTo(Route = Home.ELECTRICITY_SCREEN)
            },
            IconSize = 45,
            IconResource = R.drawable.bulb,
        )

        //Credit Card Bill Payment
        DrawIconInRow(
            SurfaceModifier = surfacemodifier,
            BoxModifier = boxmodifier.clickable {
                mainNavController.navigateTo(Route = Home.CREDIT_CARD_BILL_PAYMENT_SCREEN)
            },
            IconSize = 45,
            IconResource = R.drawable.credit_card,
        )
    }

    Row(modifier = Modifier.padding(top = 5.dp)) {

        val surfacemodifier: Modifier = Modifier.weight(1f)
        //Mobile Recharge
        WriteLabelInRow(modifier = surfacemodifier, label = "Mobile Recharge")

        //DTH
        WriteLabelInRow(modifier = surfacemodifier, label = "DTH")

        //Electricity
        WriteLabelInRow(modifier = surfacemodifier, label = "Electricity")

        //Credit Card  Bill Payment
        WriteLabelInRow(modifier = surfacemodifier, label = "Credit Card Bill Payment")
    }


    //Rent Payment , Loan Payment , Postpaid , See All
    //Recharge & Pay Bill Section Icon Row 2
    Row(modifier = Modifier.padding(top = 15.dp)) {
        val surfacemodifier: Modifier = Modifier.weight(1f)

        //Rent Payment
        DrawIconInRow(
            SurfaceModifier = surfacemodifier,
            BoxModifier = boxmodifier.clickable() {
                mainNavController.navigateTo(Route = Home.RENT_PAYMENT_SCREEN)
            },
            IconSize = 50,
            IconResource = R.drawable.building,
        )

        //Loan Payment
        DrawIconInRow(
            SurfaceModifier = surfacemodifier,
            BoxModifier = boxmodifier.clickable {
                mainNavController.navigateTo(Route = Home.LOAN_PAYMENT_SCREEN)
            },
            IconSize = 45,
            IconResource = R.drawable.rupee,
        )


        //Book A Cylinder
        DrawIconInRow(
            SurfaceModifier = surfacemodifier,
            BoxModifier = boxmodifier.clickable {
                mainNavController.navigateTo(Route = Home.BOOK_A_CYLINDER_SCREEN)
            },
            IconSize = 50,
            IconResource = R.drawable.gas_cylinder,
        )

        //See All Button
        SeeAllButton(modifier = surfacemodifier, boxmodifier = boxmodifier, onClick = {
            mainNavController.navigateTo(Route = Home.RECHARGE_PAY_BILL_SCREEN)
        })

    }

    Row(modifier = Modifier.padding(top = 5.dp)) {

        val surfacemodifier: Modifier = Modifier.weight(1f)

        //Rent Payment
        WriteLabelInRow(modifier = surfacemodifier, label = "Rent Payment")

        //Loan Payment
        WriteLabelInRow(modifier = surfacemodifier, label = "Loan Payment")

        //Book A Cylinder
        WriteLabelInRow(modifier = surfacemodifier, label = "Book A Cylinder")

        //See All
        WriteLabelInRow(modifier = surfacemodifier, label = "See All")

    }

}

@Composable
fun RechargePayBillSection() {
    Column {
        Row {
            HeadingText(
                HeadingText = "Recharge & Pay Bills",
                SurfacePadding = PaddingValues(start = 20.dp, top = 10.dp),
                HeadingTextFontWeight = FontWeight.Normal
            )


            //My Bills Button Section
            Button(
                modifier = Modifier
                    .padding(start = 125.dp, top = 12.dp, end = 15.dp)
                    .height(20.dp),
                onClick = { /*TODO*/ },
                contentPadding = PaddingValues(
                    start = 10.dp,
                    end = 10.dp
                ),
                colors = ButtonDefaults.outlinedButtonColors(Color(44, 35, 56, 255)),
                border = BorderStroke(1.dp, Color(49, 40, 61, 255))
            ) {
                Text(
                    text = "My Bills",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.White
                )
            }
        }

        RechargePayBillSectionIcon()


    }
}


@Preview(showSystemUi = true)
@Composable
fun Preview() {
    PhonepeCloneTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = colorResource(id = R.color.background)
        ) {
            Column {
                SurfaceInView(Height = 285) {
                    RechargePayBillSection()
                }
            }
        }
    }
}
