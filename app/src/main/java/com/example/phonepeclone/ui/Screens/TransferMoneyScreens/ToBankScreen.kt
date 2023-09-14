package com.example.phonepeclone.ui.theme.Screens.TransferMoneyScreens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.TabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.phonepeclone.BlueTopAppBar
import com.example.phonepeclone.R
import com.example.phonepeclone.SearchBar
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

data class TabRowItem(
    val title: String,
    val screen: @Composable () -> Unit,
)

//Tab Layout Screen 1
@Composable
fun BankAccount() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp),
        color = Color.Transparent
    )
    {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Send money to any bank \n account number",
                color = Color.White,
                lineHeight = 23.sp,
                fontSize = 23.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold
            )


            Button(
                modifier = Modifier
                    .padding(top = 130.dp)
                    .width(280.dp)
                    .height(50.dp),
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(50),
                contentPadding = PaddingValues(
                    start = 35.dp,
                    end = 35.dp,
                    top = 5.dp,
                    bottom = 5.dp
                ),
                colors = ButtonDefaults.outlinedButtonColors(Color(163, 99, 235, 255))
            ) {
                Text(
                    text = "ADD  RECIEPINT BANK \nACCOUNT",
                    textAlign = TextAlign.Center,
                    lineHeight = 18.sp,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                )
            }


            Text(
                modifier = Modifier.padding(top = 30.dp),
                text = "Don't have bank account detailes ?",
                color = Color.White,
                fontSize = 10.sp
            )
            Text(
                modifier = Modifier.padding(top = 5.dp),
                text = "SEND MONEY VIA MOBILE NUMBER",
                color = Color(134, 94, 181, 255),
                fontSize = 11.sp
            )
        }
    }

}

//Tab Layout Screen 2
@Composable
fun UPIID() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp),
        color = Color.Transparent
    )
    {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Send money to any UPI ID \n across any app",
                color = Color.White,
                lineHeight = 23.sp,
                fontSize = 23.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold
            )


            Button(
                modifier = Modifier
                    .padding(top = 130.dp)
                    .width(280.dp)
                    .height(50.dp),
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(50),
                contentPadding = PaddingValues(
                    start = 35.dp,
                    end = 35.dp,
                    top = 5.dp,
                    bottom = 5.dp
                ),
                colors = ButtonDefaults.outlinedButtonColors(Color(163, 99, 235, 255))
            ) {
                Text(
                    text = "ADD UPI ID",
                    textAlign = TextAlign.Center,
                    lineHeight = 18.sp,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                )
            }


            Text(
                modifier = Modifier.padding(top = 30.dp),
                text = "Don't have UPI ID details ?",
                color = Color.White,
                fontSize = 10.sp
            )
            Text(
                modifier = Modifier.padding(top = 5.dp),
                text = "SEND MONEY VIA MOBILE NUMBER",
                color = Color(134, 94, 181, 255),
                fontSize = 11.sp
            )
        }
    }

}

//Tab Layout Screen 3
@Composable
fun UPINUMBER() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 150.dp),
        color = Color.Transparent
    )
    {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(top = 30.dp),
                text = "Send money using UPI Number",
                color = Color.White,
                fontSize = 20.sp
            )
            Button(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .width(280.dp)
                    .height(50.dp),
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(50),
                contentPadding = PaddingValues(
                    start = 35.dp,
                    end = 35.dp,
                    top = 5.dp,
                    bottom = 5.dp
                ),
                colors = ButtonDefaults.outlinedButtonColors(Color(163, 99, 235, 255))
            ) {
                Text(
                    text = "ADD UPI NUMBER",
                    textAlign = TextAlign.Center,
                    lineHeight = 18.sp,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                )
            }

        }
    }

}

@OptIn(
    ExperimentalPagerApi::class
)
@Composable
fun BankScreen() {

    val tabRowItems = listOf(
        TabRowItem(
            title = "Bank\nAccount",
            screen = { BankAccount() }
        ),
        TabRowItem(
            title = "UPI ID",
            screen = { UPIID() }
        ),
        TabRowItem(
            title = "UPI NUMBER",
            screen = { UPINUMBER() }
        )
    )

    var searchtextfromuser by remember {
        mutableStateOf("")
    }


    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = colorResource(id = R.color.background)
    ) {
        Column(
            modifier = Modifier.padding(top = 70.dp)
        ) {

            //Search Bar
            searchtextfromuser = SearchBar(PlaceHolder = "Search Bank Account , UPI ID")

            val pagerState = rememberPagerState(pageCount = 3)

            Surface(
                modifier = Modifier
                    .padding(10.dp)
                    .clip(RoundedCornerShape(15.dp)),
                color = colorResource(id = R.color.scrollable_view)
            ) {

                Column {
                    TabRow(
                        modifier = Modifier.height(70.dp),
                        selectedTabIndex = pagerState.currentPage,
                        indicator = { tabPositions ->
                            TabRowDefaults.Indicator(
                                Modifier.pagerTabIndicatorOffset(
                                    pagerState,
                                    tabPositions
                                ),
                                height = 5.dp,
                                color = Color(144, 93, 198, 255)
                            )
                        },
                        backgroundColor = Color.Transparent
                    ) {
                        val scope = rememberCoroutineScope()
                        tabRowItems.forEachIndexed { index, item ->
                            Tab(
                                selected = pagerState.currentPage == index,
                                onClick = {
                                    scope.launch {
                                        pagerState.animateScrollToPage(index)
                                    }
                                },
                                text = {
                                    Text(
                                        text = item.title,
                                        maxLines = 2,
                                        fontSize = 16.sp,
                                        color = if (pagerState.currentPage == index) Color(
                                            144,
                                            93,
                                            198,
                                            255
                                        ) else Color.White,
                                        lineHeight = 14.sp
                                    )
                                }
                            )
                        }
                    }

                    //Using Index Lambda , But why was pagerState.currentpage was lacking
                    //tabRowItems[pagerState.current].screen() was lacking
                    HorizontalPager(
                        state = pagerState
                    ) { index ->
                        tabRowItems[index].screen()
                    }
                }
            }
        }
    }


    //Top App Bar 
    BlueTopAppBar(Heading = "Transfer Money")


}


@Preview(
    showSystemUi = true
)
@Composable
fun ToBank() {
    PhonepeCloneTheme {
        BankScreen()
    }
}