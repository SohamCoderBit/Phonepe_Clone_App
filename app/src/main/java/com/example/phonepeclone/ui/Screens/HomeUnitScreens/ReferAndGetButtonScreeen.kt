package com.example.phonepeclone.ui.Screens.HomeUnitScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.phonepeclone.BlueTopAppBar
import com.example.phonepeclone.DrawIconInRow
import com.example.phonepeclone.R
import com.example.phonepeclone.SearchBar
import com.example.phonepeclone.WriteLabelInRow
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme
import com.example.phonepeclone.ui.theme.Screens.TransferMoneyScreens.ContactList

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ReferAndGetButtonScreen() {

    var searchtextfromuser by remember {
        mutableStateOf("")
    }

    val sheetState = rememberBottomSheetState(
        initialValue = BottomSheetValue.Collapsed
    )
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = sheetState
    )

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetShape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp),

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
                        Text(
                            modifier = Modifier.padding(top = 10.dp),
                            text = "Invite",
                            color = Color.White,
                            fontSize = 25.sp,
                            textAlign = TextAlign.Center
                        )
                    }


                    Row(modifier = Modifier.padding(top = 40.dp)) {
                        val surfaceModifier: Modifier = Modifier.weight(1f)

                        //Whatsapp Logo Icon
                        DrawIconInRow(
                            SurfaceModifier = surfaceModifier,
                            IconSize = 50,
                            IconTint = Color.Unspecified,
                            IconResource = R.drawable.whatsapp_logo
                        )

                        //Twitter Logo Icon
                        DrawIconInRow(
                            SurfaceModifier = surfaceModifier,
                            IconSize = 50,
                            IconTint = Color.Unspecified,
                            IconResource = R.drawable.twitter_logo
                        )

                        //Instagram Logo Icon
                        DrawIconInRow(
                            SurfaceModifier = surfaceModifier,
                            IconSize = 50,
                            IconTint = Color.Unspecified,
                            IconResource = R.drawable.instagram_logo
                        )

                        //More Button Logo Icon
                        DrawIconInRow(
                            SurfaceModifier = surfaceModifier,
                            IconSize = 55,
                            IconTint = Color.LightGray,
                            IconResource = R.drawable.more_logo
                        )
                    }

                    Row(modifier = Modifier.padding(bottom = 20.dp)) {
                        val surfacemodifier: Modifier = Modifier.weight(1f)
                        //Whatsapp
                        WriteLabelInRow(modifier = surfacemodifier, label = "Whatsapp")

                        //Twitter
                        WriteLabelInRow(modifier = surfacemodifier, label = "Twitter")

                        //Instagram
                        WriteLabelInRow(modifier = surfacemodifier, label = "Instagram")

                        //More Button
                        WriteLabelInRow(modifier = surfacemodifier, label = "More")
                    }

                    Text(
                        modifier = Modifier.padding(top = 10.dp, start = 10.dp),
                        text = "Contact not yet on PhonePe",
                        color = Color.White,
                        fontSize = 20.sp
                    )

                    //Search Bar
                    searchtextfromuser = SearchBar(PlaceHolder = "Search by Number or Name")

                    ContactList()

                }
            }
        },
        sheetBackgroundColor = colorResource(id = R.color.background),
        sheetPeekHeight = 300.dp
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(170, 100, 200, 255)),
            contentAlignment = Alignment.TopCenter
        ) {
            BlueTopAppBar(Heading = "")
        }
    }
}


@Preview
@Composable
fun PreviewReferAndGetButton() {
    PhonepeCloneTheme {
        ReferAndGetButtonScreen()
    }
}

