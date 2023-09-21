package com.example.phonepeclone.ui.theme.Units

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.phonepeclone.DrawIconInRow
import com.example.phonepeclone.R
import com.example.phonepeclone.SurfaceInView
import com.example.phonepeclone.WriteLabelInRow
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme


@Composable
fun SurfaceInCarousel(
    Height: Int,
    Width: Int,
    StartPadding: Int,
    Endpadding: Int
) {
    Surface(
        modifier = Modifier
            .padding(start = StartPadding.dp, end = Endpadding.dp)
            .width(Width.dp)
            .height(Height.dp)
            .clickable(indication = null, interactionSource = MutableInteractionSource()) {
                println(
                    "Clicked Carousel Surface"
                )
            },
        color = Color.Transparent,
        shape = RoundedCornerShape(15.dp),
        border = BorderStroke(1.dp, Color(70, 61, 80, 255))


    ) {
        Box {
            Column {
                Row {
                    Image(
                        modifier = Modifier
                            .padding(top = 10.dp, start = 10.dp)
                            .height(70.dp),
                        painter = painterResource(id = R.mipmap.icici_fund_foreground),
                        contentDescription = null
                    )


                    Surface(
                        color = Color.Transparent
                    ) {
                        Column {
                            Text(
                                modifier = Modifier.padding(top = 20.dp),
                                text = "ICICI Prudential Value Discovery Fund",
                                color = Color.White,
                                lineHeight = 20.sp
                            )
                            Text(
                                modifier = Modifier.padding(top = 5.dp),
                                text = "Equity - Value",
                                fontSize = 12.sp,
                                color = Color.LightGray
                            )
                        }

                    }

                }
                Row(modifier = Modifier.padding(top = 20.dp)) {
                    Column(
                        modifier = Modifier.padding(start = 20.dp)
                    ) {
                        Text(text = "3Y Return", color = Color.White, fontSize = 13.sp)
                        Row {
                            Text(
                                modifier = Modifier.padding(end = 2.dp),
                                text = "30.20%",
                                color = Color(53, 146, 100, 255),
                                fontSize = 23.sp
                            )

                            Text(
                                modifier = Modifier.padding(top = 10.dp),
                                text = "p.a",
                                color = Color.LightGray,
                                fontSize = 13.sp,
                                textAlign = TextAlign.Start
                            )


                        }

                    }
                    Divider(
                        modifier = Modifier
                            .padding(start = 10.dp, top = 2.dp)
                            .height(48.dp)
                            .width(0.5.dp)
                    )
                    Column(modifier = Modifier.padding(start = 10.dp)) {
                        Text(text = "Min. Amount", fontSize = 13.sp, color = Color.White)
                        Text(text = "₹100", fontSize = 23.sp, color = Color.White)
                    }
                    Icon(
                        modifier = Modifier
                            .padding(top = 15.dp, start = 25.dp)
                            .height(15.dp),
                        painter = painterResource(id = R.drawable.chevron_right_solid),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = "as on 31-07-2023",
                    color = Color.White,
                    fontSize = 9.sp
                )
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WealthUnit() {

    var searchtextfromuser by remember {
        mutableStateOf("")
    }


    Column(
        modifier = Modifier
            .verticalScroll(
                rememberScrollState()
            )
    ) {


        //-------------------Search Bar At the (Top)--------------------
        OutlinedTextField(
            modifier = Modifier
                .padding(start = 10.dp, top = 10.dp, end = 10.dp)
                .height(55.dp)
                .fillMaxWidth(),
            value = searchtextfromuser,
            onValueChange = { searchtextfromuser = it },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.White,
                containerColor = Color(33, 24, 43, 255),
            ),
            placeholder = {
                Text(
                    modifier = Modifier.padding(start = 10.dp),
                    text = "Search by fund category",
                    fontSize = 18.sp,
                    lineHeight = 20.sp
                )
            },
            maxLines = 1,
            textStyle = LocalTextStyle.current.copy(fontSize = 15.sp),
            shape = RoundedCornerShape(50),
            singleLine = true,
            leadingIcon = {
                Icon(
                    modifier = Modifier
                        .size(30.dp)
                        .padding(start = 10.dp),
                    painter = painterResource(id = R.drawable.loupe),
                    contentDescription = null,
                    tint = Color.White
                )
            }

        )

        //Toggle Surface in view With Height Between 95 to 300
        var surfaceHeight by remember { mutableIntStateOf(95) }
        val iconSource =
            if (surfaceHeight == 95) R.drawable.arrow_down_sign_to_navigate else R.drawable.up_arrow
        SurfaceInView(Height = surfaceHeight)
        {
            Column {

                Row {
                    //------------------This Surface is Clickable------------------
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable(
                                indication = null,
                                interactionSource = MutableInteractionSource()
                            ) {
                                surfaceHeight = if (surfaceHeight == 95) 280 else 95
                            },
                        color = Color.Transparent,
                    ) {
                        Row {
                            Row(
                                modifier = Modifier.width(320.dp)
                            ) {
                                if (surfaceHeight == 95) {
                                    Icon(
                                        modifier = Modifier
                                            .padding(top = 23.dp, start = 20.dp)
                                            .size(40.dp),
                                        painter = painterResource(id = R.drawable.user_regular),
                                        contentDescription = null,
                                        tint = Color(144, 93, 198, 255)
                                    )
                                }

                                Column(
                                    modifier = Modifier
                                        .padding(top = 15.dp, start = 20.dp)
                                ) {
                                    Text(
                                        text = "Need help to get Started?",
                                        color = Color.White,
                                        fontWeight = FontWeight.SemiBold
                                    )

                                    Text(
                                        modifier = Modifier.padding(top = 2.dp),
                                        text = "Join 2.5 Cr+ mutual fund investors to grow your wealth",
                                        color = Color.White,
                                        fontSize = 13.sp,
                                        lineHeight = 14.sp
                                    )


                                }
                            }



                            Icon(
                                modifier = Modifier
                                    .padding(top = 35.dp, start = 15.dp)
                                    .size(15.dp),
                                painter = painterResource(id = iconSource),
                                contentDescription = null,
                                tint = Color.White
                            )


                        }
                    }
                }


                if (surfaceHeight == 280) {

                    //Set up a New SIP
                    Row(
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .height(70.dp)
                    )
                    {

                        Box(
                            modifier = Modifier
                                .weight(0.35f)
                                .fillMaxHeight(),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(45.dp),
                                painter = painterResource(id = R.drawable.calendar),
                                contentDescription = null,
                                tint = Color(144, 93, 198, 255)
                            )

                        }

                        Box(
                            modifier = Modifier
                                .weight(0.7f)
                                .fillMaxHeight(),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Column {
                                Text(
                                    text = "Set up a new SIP",
                                    color = Color.White,
                                    fontWeight = FontWeight.SemiBold
                                )
                                Text(
                                    modifier = Modifier.padding(top = 2.dp),
                                    text = "We'll help you choose a fund \nfor your investment",
                                    color = Color.White,
                                    fontSize = 13.sp,
                                    lineHeight = 15.sp
                                )
                            }
                        }

                        Box(
                            modifier = Modifier
                                .weight(0.4f)
                                .fillMaxHeight(),
                            contentAlignment = Alignment.Center
                        ) {
                            Button(
                                modifier = Modifier
                                    .height(30.dp),
                                onClick = {},
                                contentPadding = PaddingValues(
                                    start = 15.dp,
                                    end = 15.dp,
                                    top = 2.dp,
                                    bottom = 2.dp
                                ),
                                colors = ButtonDefaults.outlinedButtonColors(
                                    Color(
                                        163,
                                        99,
                                        235,
                                        255
                                    )
                                ),
                                shape = RoundedCornerShape(50)
                            ) {
                                Text(text = "START", color = Color.Black, fontSize = 13.sp)
                            }
                        }

                    }

                    //Learn More on Mutual Funds
                    Row(
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .height(70.dp)
                    )
                    {

                        Box(
                            modifier = Modifier
                                .weight(0.35f)
                                .fillMaxHeight(),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(52.dp),
                                painter = painterResource(id = R.drawable.book_bookmark_icon),
                                contentDescription = null,
                                tint = Color(144, 93, 198, 255)
                            )

                        }

                        Box(
                            modifier = Modifier
                                .weight(0.7f)
                                .fillMaxHeight(),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Column {
                                Text(
                                    text = "Learn More on Mutual\nFunds",
                                    color = Color.White,
                                    fontWeight = FontWeight.SemiBold
                                )
                                Text(
                                    modifier = Modifier.padding(top = 2.dp),
                                    text = "Basics on investments",
                                    color = Color.White,
                                    fontSize = 13.sp,
                                    lineHeight = 15.sp
                                )
                            }
                        }

                        Box(
                            modifier = Modifier
                                .weight(0.4f)
                                .fillMaxHeight(),
                            contentAlignment = Alignment.Center
                        ) {
                            Button(
                                modifier = Modifier
                                    .height(30.dp),
                                onClick = {},
                                contentPadding = PaddingValues(
                                    start = 15.dp,
                                    end = 15.dp,
                                    top = 2.dp,
                                    bottom = 2.dp
                                ),
                                colors = ButtonDefaults.outlinedButtonColors(
                                    Color(
                                        163,
                                        99,
                                        235,
                                        255
                                    )
                                ),
                                shape = RoundedCornerShape(50)
                            ) {
                                Text(text = "LEARN", color = Color.Black, fontSize = 13.sp)
                            }
                        }

                    }

                }

            }
        }



        SurfaceInView(Height = 285) {
            val boxmodifier: Modifier = Modifier
                .size(60.dp)
            Column {
                Surface(
                    modifier = Modifier.padding(start = 20.dp, top = 10.dp),
                    color = Color.Transparent
                )
                {
                    Text(text = "Investment Ideas", color = Color.White)
                }
                //Investment Ideas Section Row 1 (Icons)
                Row(modifier = Modifier.padding(top = 15.dp)) {
                    val surfacemodifier: Modifier = Modifier.weight(1f)

                    //Gold
                    DrawIconInRow(
                        SurfaceModifier = surfacemodifier,
                        BoxModifier = boxmodifier.clickable {
                        },
                        IconSize = 45,
                        IconResource = R.drawable.gold_inget,
                    )

                    //Top Companies
                    DrawIconInRow(
                        SurfaceModifier = surfacemodifier,
                        BoxModifier = boxmodifier.clickable {

                        },
                        IconSize = 45,
                        IconResource = R.drawable.fluctuation,
                    )

                    //Tax Saving Funds
                    DrawIconInRow(
                        SurfaceModifier = surfacemodifier,
                        BoxModifier = boxmodifier.clickable {

                        },
                        IconSize = 45,
                        IconResource = R.drawable.piggy_bank,
                    )

                    //Start with ₹100
                    DrawIconInRow(
                        SurfaceModifier = surfacemodifier,
                        BoxModifier = boxmodifier.clickable {
                        },
                        IconSize = 45,
                        IconResource = R.drawable.rupee_100,
                    )
                }

                //Investment Ideas Section Row 1 (Label Texts)
                Row(modifier = Modifier.padding(top = 5.dp)) {
                    val surfacemodifier: Modifier = Modifier.weight(1f)

                    //Gold
                    WriteLabelInRow(modifier = surfacemodifier, label = "Gold")

                    //Top \n Companies
                    WriteLabelInRow(modifier = surfacemodifier, label = "Top\nCompanies")

                    //Tax Saving \n Funds
                    WriteLabelInRow(modifier = surfacemodifier, label = "Tax Saving\nFunds")

                    //Start With\n ₹100
                    WriteLabelInRow(modifier = surfacemodifier, label = "Start With\n₹100")

                }

                //Investment Ideas Section Row 2 (Icons)
                Row(modifier = Modifier.padding(top = 15.dp)) {
                    val surfacemodifier: Modifier = Modifier.weight(1f)

                    //Best SIP Funds
                    DrawIconInRow(
                        SurfaceModifier = surfacemodifier,
                        BoxModifier = boxmodifier.clickable {
                        },
                        IconSize = 45,
                        IconResource = R.drawable.growth_846173,
                    )

                    //3-in-1 Funds
                    DrawIconInRow(
                        SurfaceModifier = surfacemodifier,
                        BoxModifier = boxmodifier.clickable {
                        },
                        IconSize = 45,
                        IconResource = R.drawable.arrow_4161661,
                    )

                    //Trending Themes
                    DrawIconInRow(
                        SurfaceModifier = surfacemodifier,
                        BoxModifier = boxmodifier.clickable {
                        },
                        IconSize = 45,
                        IconResource = R.drawable.bulb,
                    )

                    //High Return Funds
                    DrawIconInRow(
                        SurfaceModifier = surfacemodifier,
                        BoxModifier = boxmodifier.clickable {
                        },
                        IconSize = 45,
                        IconResource = R.drawable.high_return_funds,
                    )
                }

                //Investment Ideas Section Row 2 (Label Texts)
                Row(modifier = Modifier.padding(top = 5.dp)) {
                    val surfacemodifier: Modifier = Modifier.weight(1f)

                    //Best SIP \n Funds
                    WriteLabelInRow(modifier = surfacemodifier, label = "Best SIP \nFunds")

                    //3 in-1 Funds
                    WriteLabelInRow(modifier = surfacemodifier, label = "3 in-1 Funds")

                    //Trending \n Themes
                    WriteLabelInRow(modifier = surfacemodifier, label = "Trending \nThemes")

                    //High Return\n Funds
                    WriteLabelInRow(modifier = surfacemodifier, label = "High Return\n Funds")

                }
            }
        }

        SurfaceInView(Height = 290) {
            Column {
                Text(
                    modifier = Modifier.padding(start = 20.dp, top = 15.dp),
                    text = "Top Funds in focus",
                    color = Color.White
                )
                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = "Fund ideas to boost yout wealth journey",
                    color = Color.White,
                    fontSize = 13.sp
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 80.dp)
                    .horizontalScroll(
                        rememberScrollState()
                    )
            ) {

                SurfaceInCarousel(Height = 180, Width = 280, StartPadding = 20, Endpadding = 5)
                SurfaceInCarousel(Height = 180, Width = 280, StartPadding = 5, Endpadding = 5)
                SurfaceInCarousel(Height = 180, Width = 280, StartPadding = 5, Endpadding = 5)
                SurfaceInCarousel(Height = 180, Width = 280, StartPadding = 5, Endpadding = 20)

            }
        }


        val modifier: Modifier = Modifier.clickable { println("Explore all funds") }
        SurfaceInView(Height = 79, modifier = modifier) {


            Row {
                Icon(
                    modifier = Modifier
                        .padding(start = 20.dp, top = 17.dp, end = 20.dp)
                        .size(35.dp),
                    painter = painterResource(id = R.drawable.four_dots_squared),
                    contentDescription = null,
                    tint = Color(144, 93, 198, 255)
                )

                Column(
                    modifier = Modifier.padding(top = 13.dp)
                ) {
                    Text(
                        text = "Explore all funds",
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        modifier = Modifier.padding(top = 2.dp),
                        text = "Pick a fund on your own",
                        fontSize = 13.sp,
                        color = Color.White
                    )
                }

                Icon(
                    modifier = Modifier
                        .padding(start = 100.dp, top = 24.dp)
                        .size(20.dp),
                    painter = painterResource(id = R.drawable.chevron_right_solid),
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }


        SurfaceInView(Height = 170) {

            val boxmodifier: Modifier = Modifier
                .size(60.dp)

            Column {
                Surface(
                    modifier = Modifier.padding(start = 20.dp, top = 10.dp),
                    color = Color.Transparent
                )
                {
                    Text(text = "Mutual Fund Categories", color = Color.White)
                }


                Row(modifier = Modifier.padding(top = 10.dp)) {
                    val surfacemodifier: Modifier = Modifier.weight(1f)

                    //Large Cap Funds
                    DrawIconInRow(
                        SurfaceModifier = surfacemodifier,
                        BoxModifier = boxmodifier.clickable {
                        },
                        IconSize = 45,
                        IconResource = R.drawable.gold_inget,
                    )

                    //Mid Cap Funds
                    DrawIconInRow(
                        SurfaceModifier = surfacemodifier,
                        BoxModifier = boxmodifier.clickable {
                        },
                        IconSize = 45,
                        IconResource = R.drawable.fluctuation,
                    )

                    //Small Cap Funds
                    DrawIconInRow(
                        SurfaceModifier = surfacemodifier,
                        BoxModifier = boxmodifier.clickable {
                        },
                        IconSize = 45,
                        IconResource = R.drawable.piggy_bank,
                    )

                    //Index Funds
                    DrawIconInRow(
                        SurfaceModifier = surfacemodifier,
                        BoxModifier = boxmodifier.clickable {
                        },
                        IconSize = 45,
                        IconResource = R.drawable.rupee_100,
                    )
                }

                Row(modifier = Modifier.padding(top = 5.dp)) {
                    val surfacemodifier: Modifier = Modifier.weight(1f)

                    //Large Cap \n Funds
                    WriteLabelInRow(modifier = surfacemodifier, label = "Large Cap\nFunds")

                    //Mid Cap \n Funds
                    WriteLabelInRow(modifier = surfacemodifier, label = "Mid Cap\nFunds")

                    //Small Cap \n Themes
                    WriteLabelInRow(modifier = surfacemodifier, label = "Small Cap\nFunds")

                    //Index \n Funds
                    WriteLabelInRow(modifier = surfacemodifier, label = "Index\nFunds")

                }
            }
        }
    }
}


@Preview
@Composable
fun PreviewWealthUnit() {
    PhonepeCloneTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = colorResource(id = R.color.background)
        ) {
            Column(
                modifier = Modifier
                    .verticalScroll(
                        rememberScrollState()
                    )
                    .padding(top = 70.dp, bottom = 80.dp)
            ) {
                WealthUnit()
            }
        }
    }
}