package com.example.phonepeclone.ui.theme.Screens.RechargeAndBillScreens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.phonepeclone.BlueTopAppBar
import com.example.phonepeclone.R
import com.example.phonepeclone.SearchBar
import com.example.phonepeclone.SurfaceInView
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme
import com.example.phonepeclone.ui.theme.Screens.TransferMoneyScreens.ContactList

@Composable
fun MobileRechargeScreen() {


    var searchtextfromuser by remember {
        mutableStateOf("")
    }
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = colorResource(id = R.color.background)
    ) {

        Column(
            modifier = Modifier
                .padding(top = 70.dp)
                .verticalScroll(rememberScrollState())
        ) {
            SurfaceInView(Height = 100) {

            }
            searchtextfromuser =  SearchBar(PlaceHolder = "Search by Number or Name")

            Surface(
                color = colorResource(id = R.color.scrollable_view),
                modifier = Modifier
                    .padding(top = 10.dp, start = 10.dp, end = 10.dp)
                    .fillMaxHeight()
                    .fillMaxWidth(),
                shape = RoundedCornerShape(15.dp)
            ) {
                Column{
                    ContactList()
                }
            }
        }

        BlueTopAppBar(Heading = "Mobile Recharge")
    }
}


@Preview
@Composable
fun PreviewMobileRechargeScreen() {

    PhonepeCloneTheme {
        MobileRechargeScreen()
    }
}

