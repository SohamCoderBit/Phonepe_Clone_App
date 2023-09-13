package com.example.phonepeclone.ui.theme.Screens.RechargeAndBillScreens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.phonepeclone.BlueTopAppBar
import com.example.phonepeclone.HeadingTextInSurfaceView
import com.example.phonepeclone.R
import com.example.phonepeclone.RowWithDividerElements
import com.example.phonepeclone.SurfaceInView
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme


@Composable
fun RentalList() {
    val iconboxmodifier: Modifier = Modifier
        .padding(start = 15.dp)
        .size(45.dp)
        .border(0.5.dp, Color(72, 60, 80, 255), RoundedCornerShape(20))

    val IconColor: Color = Color(144, 93, 198, 255)

    RowWithDividerElements(
        Content = "Society Maintenance",
        IconSource = R.drawable.building_columns_solid,
        IconBoxModifier = iconboxmodifier,
        IconTint = IconColor
    )

    RowWithDividerElements(
        Content = "Home/Shop Rent",
        IconSource = R.drawable.building_columns_solid,
        IconBoxModifier = iconboxmodifier,
        IconTint = IconColor
    )

    RowWithDividerElements(
        Content = "Broker Payment",
        IconSource = R.drawable.building_columns_solid,
        IconBoxModifier = iconboxmodifier,
        IconTint = IconColor
    )

    RowWithDividerElements(
        Content = "Property Deposit",
        IconSource = R.drawable.building_columns_solid,
        IconBoxModifier = iconboxmodifier,
        IconTint = IconColor
    )
}


@Composable
fun RentPaymentScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = colorResource(id = R.color.background)
    ) {

        Column(modifier = Modifier.padding(top = 70.dp)) {

            SurfaceInView(Height = 150) {

            }
            SurfaceInView(Height = 340) {


                Column {

                    HeadingTextInSurfaceView(
                        HeadingText = "Pay for Rentals",
                        SurfacePadding = PaddingValues(start = 15.dp, top = 10.dp),
                        HeadingTextFontWeight = FontWeight.Normal
                    )

                    RentalList()
                }
            }
        }


    }


    //Top App Bar
    BlueTopAppBar(Heading = "Rent Payment")
}

@Preview
@Composable
fun PreviewRentPayment() {
    PhonepeCloneTheme {
        RentPaymentScreen()
    }
}