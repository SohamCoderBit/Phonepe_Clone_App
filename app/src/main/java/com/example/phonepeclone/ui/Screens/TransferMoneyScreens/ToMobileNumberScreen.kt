package com.example.phonepeclone.ui.theme.Screens.TransferMoneyScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.phonepeclone.R
import com.example.phonepeclone.RowWithDividerElements
import com.example.phonepeclone.SearchBar
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme


@Composable
fun ContactListElements(PersonName: String, PersonContactNumber: String) {
    RowWithDividerElements(
        Content = PersonName + "\n" + PersonContactNumber,
        IconSource = R.drawable.user_regular,
        IconBoxModifier = Modifier
            .size(45.dp)
            .clip(CircleShape)
            .background(Color.White)
    )
}


@Composable
fun ContactList() {
    for (i in 0 until 20) {
        ContactListElements(PersonName = "Person " + (i + 1), PersonContactNumber = "9090909090")
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MobileNumberScreen() {


    var searchtextfromuser by remember {
        mutableStateOf("")
    }

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = colorResource(id = R.color.background)
    ) {

        val sheetState = rememberBottomSheetState(
            initialValue = BottomSheetValue.Collapsed
        )
        val scaffoldState = rememberBottomSheetScaffoldState(
            bottomSheetState = sheetState
        )

        val corner = if (sheetState.isCollapsed) 7 else 0

        BottomSheetScaffold(
            scaffoldState = scaffoldState,
            sheetShape = RoundedCornerShape(topStart = corner.dp, topEnd = corner.dp),

            //Sheet Content
            sheetContent = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    contentAlignment = Alignment.TopCenter
                ) {

                    Column(
                        modifier = Modifier.verticalScroll(rememberScrollState())
                    ) {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Divider(
                                modifier = Modifier
                                    .padding(top = 10.dp)
                                    .width(100.dp)
                                    .clip(RoundedCornerShape(50)),
                                thickness = 5.dp,
                                color = Color(70, 54, 90, 255)
                            )
                        }

                        Text(
                            modifier = Modifier.padding(start = 20.dp, top = 10.dp),
                            text = "Select Contact",
                            color = Color.White,
                            fontSize = 25.sp
                        )

                        //Search Bar
                        searchtextfromuser = SearchBar(PlaceHolder = "Search any mobile number")

                        Row(
                            modifier = Modifier.padding(top = 20.dp)
                        ) {
                            Surface(
                                modifier = Modifier.weight(0.7f),
                                color = Color.Transparent
                            ) {
                                Row {
                                    Box(
                                        modifier = Modifier
                                            .padding(start = 15.dp)
                                            .size(45.dp)
                                            .clip(CircleShape)
                                            .background(Color(161, 100, 234, 255)),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Icon(
                                            modifier = Modifier.size(25.dp),
                                            painter = painterResource(id = R.drawable.dial_keys),
                                            contentDescription = null
                                        )
                                    }

                                    Text(
                                        modifier = Modifier.padding(top = 7.dp, start = 9.dp),
                                        text = "New Mobile\nNumber",
                                        color = Color.White,
                                        fontSize = 12.sp
                                    )
                                }
                            }


                            Divider(
                                modifier = Modifier
                                    .width(1.dp)
                                    .height(47.dp),
                                thickness = 0.5.dp,
                                color = Color(51, 42, 61, 255)
                            )
                            Surface(
                                modifier = Modifier.weight(0.8f),
                                color = Color.Transparent
                            ) {
                                Row {
                                    Box(
                                        modifier = Modifier
                                            .padding(start = 15.dp)
                                            .size(45.dp)
                                            .clip(CircleShape)
                                            .background(Color(161, 100, 234, 255)),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Icon(
                                            modifier = Modifier.size(35.dp),
                                            painter = painterResource(id = R.drawable.new_group),
                                            contentDescription = null
                                        )
                                    }

                                    Text(
                                        modifier = Modifier.padding(top = 13.dp, start = 9.dp),
                                        text = "Create New Group",
                                        color = Color.White,
                                        fontSize = 12.sp
                                    )
                                }

                            }

                        }

                        Divider(
                            modifier = Modifier.padding(top = 10.dp),
                            thickness = 1.dp,
                            color = Color(51, 42, 61, 255)
                        )

                        Text(
                            modifier = Modifier.padding(top = 10.dp, start = 10.dp , bottom = 10.dp),
                            text = "Phone Contacts",
                            color = Color.White
                        )

                        ContactList()

                    }
                }
            },
            sheetBackgroundColor = colorResource(id = R.color.background),
            sheetPeekHeight = 700.dp
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(170, 100, 200, 255)),
                contentAlignment = Alignment.TopCenter
            ) {

            }
        }


    }
}


@Preview(
    showSystemUi = true
)
@Composable
fun ToMobile() {
    PhonepeCloneTheme {
        MobileNumberScreen()
    }
}