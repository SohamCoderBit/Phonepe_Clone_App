package com.example.phonepeclone.ui.theme.Screens.InsuranceScreens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
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
import com.example.phonepeclone.BlueTopAppBarScrollStateManaged
import com.example.phonepeclone.HeadingText
import com.example.phonepeclone.R
import com.example.phonepeclone.SurfaceInView
import com.example.phonepeclone.textfield
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme

data class MemberListItem(val Label: String, var isSelected: MutableState<Boolean>)


@Composable
fun CounterTextArea(UpdateTheCount: (Int) -> Unit, LowerBound: Int, UpperBound: Int) {

    var counterState by remember {
        mutableIntStateOf(LowerBound)
    }

    val purpleColor = Color(144, 93, 198, 255)
    Row(
        modifier = Modifier.padding(end = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        val minusSignColor: Color =
            if (counterState == LowerBound) Color.LightGray else purpleColor
        val plusSignColor: Color =
            if (counterState == UpperBound) Color.LightGray else purpleColor

        //Minus Sign
        Icon(
            modifier = Modifier
                .size(20.dp)
                .clickable(
                    indication = null,
                    interactionSource = MutableInteractionSource()
                ) {
                    if (counterState != LowerBound)
                        counterState--
                },
            painter = painterResource(id = R.drawable.minus_sign),
            contentDescription = null,
            tint = minusSignColor
        )

        //Box Container
        Box(
            modifier = Modifier
                .width(50.dp)
                .height(40.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(35.dp)
                    .border(1.dp, Color.LightGray, RoundedCornerShape(30)),
                contentAlignment = Alignment.Center
            ) {
                Text(text = counterState.toString(), color = Color.White, fontSize = 20.sp)
            }
        }

        //Plus Sign
        Icon(
            modifier = Modifier
                .size(20.dp)
                .clickable(
                    indication = null,
                    interactionSource = MutableInteractionSource()
                ) {
                    if (counterState != UpperBound) {
                        counterState++
                    }
                },
            painter = painterResource(id = R.drawable.plus_sign),
            contentDescription = null,
            tint = plusSignColor
        )
    }

    UpdateTheCount(counterState)
}


@Composable
fun CounterArea(PlaceHolder: String, Counter: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .padding(top = 15.dp, start = 15.dp, end = 15.dp)
            .height(65.dp)
            .fillMaxWidth()
            .border(1.dp, Color(63, 53, 80, 255), RoundedCornerShape(20)),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.padding(start = 20.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = PlaceHolder, color = Color.White,
                    fontSize = 25.sp
                )
            }

            Spacer(modifier = Modifier.width(40.dp))

            Box(
                modifier = Modifier
                    .padding(end = 10.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                Counter()
            }

        }

    }
}


enum class Members(val Index: Int) {
    MySelf(0), // MySelf
    Spouse(1), // Spouse
    SD(2), // Son/Daughter
    PI(3) // Parents/In-laws
}


@Composable
fun HealthScreen() {
    val scrollState = rememberScrollState()

    val memeberList = arrayListOf<MemberListItem>()

    fun checkIfSelected(members: Members): Boolean {
        return memeberList[members.Index].isSelected.value
    }

    memeberList.add(
        MemberListItem(
            Label = "MySelf",
            isSelected = remember { mutableStateOf(true) }
        )
    )
    memeberList.add(
        MemberListItem(
            Label = "Spouse",
            isSelected = remember { mutableStateOf(false) }
        )
    )
    memeberList.add(
        MemberListItem(
            Label = "Son/Daughter",
            isSelected = remember { mutableStateOf(false) }
        )
    )
    memeberList.add(
        MemberListItem(
            Label = "Parents/In-Laws",
            isSelected = remember { mutableStateOf(false) }
        )
    )


    //Counting How many True Values Are in the list
    var clickCount by remember {
        mutableIntStateOf(0)
    }
    clickCount = memeberList.count { it.isSelected.value }

    //parent Count Including the Parent and the In-laws Store Variable
    var parentsCount by rememberSaveable {
        mutableIntStateOf(1)
    }

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = colorResource(id = R.color.background)
    ) {
        Column(
            modifier = Modifier.verticalScroll(scrollState)
        ) {

            //Top Big Surface with Blue Type Color
            Surface(
                modifier = Modifier
                    .height(230.dp)
                    .fillMaxWidth(),
                color = colorResource(id = R.color.top_nav)
            ) {

            }
            Surface(
                color = colorResource(id = R.color.scrollable_view),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(top = 10.dp, start = 10.dp, end = 10.dp),

                shape = RoundedCornerShape(15.dp)
            ) {

                var age by remember {
                    mutableStateOf("")
                }
                Column {

                    HeadingText(
                        HeadingText = "Select the members you want to insure",
                        TextFontSize = 15,
                        HeadingTextFontWeight = FontWeight.SemiBold,
                        SurfacePadding = PaddingValues(start = 15.dp, top = 15.dp)
                    )

                    Row(
                        modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 20.dp)
                    ) {
                        val modifier = Modifier.weight(1f)

                        val selectedBorderColor = Color(76, 132, 103, 255)
                        val normalBorderColor = Color(74, 65, 86, 255)
                        val selectedSurfaceColor = Color(40, 51, 48, 255)
                        //Drawing the Memeber List
                        memeberList.forEach { item ->
                            val isSelected = item.isSelected.value
                            val borderColor: Color =
                                if (isSelected) selectedBorderColor else normalBorderColor
                            val surfaceColor: Color =
                                if (isSelected) selectedSurfaceColor else Color.Transparent

                            Surface(
                                modifier = modifier
                                    .padding(start = 5.dp, end = 5.dp)
                                    .height(105.dp)
                                    .clickable(
                                        indication = null,
                                        interactionSource = MutableInteractionSource()
                                    ) {

                                        if (clickCount > 1) {
                                            item.isSelected.value = !item.isSelected.value
                                        }
                                        if (clickCount == 1) {
                                            item.isSelected.value = true
                                        }
                                    },
                                color = surfaceColor,
                                shape = RoundedCornerShape(20),
                                border = BorderStroke(1.dp, borderColor)
                            ) {

                                Column(
                                    modifier = Modifier.padding(top = 13.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Icon(
                                        modifier = Modifier
                                            .padding(bottom = 12.dp)
                                            .size(32.dp),
                                        painter = painterResource(id = R.drawable.user_regular),
                                        contentDescription = null,
                                        tint = colorResource(id = R.color.icon_tint)
                                    )
                                    Text(
                                        text = item.Label,
                                        color = Color.White,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        }
                    }

                    //If Two are selected
                    if (checkIfSelected(Members.MySelf) && checkIfSelected(Members.Spouse)) {

                        HeadingText(
                            HeadingText = "age of the elder member (among self & spouse)",
                            TextFontSize = 15,
                            HeadingTextFontWeight = FontWeight.Medium,
                            SurfacePadding = PaddingValues(start = 15.dp, top = 20.dp)
                        )

                        age = textfield(placeHolder = "Eg:35", checkError = {
                            it != "" && (it.toInt() > 101 || it.toInt() < 18)
                        })
                    }


                    //If Only MySelf is selcted
                    if (checkIfSelected(Members.MySelf) && !checkIfSelected(Members.Spouse)) {
                        HeadingText(
                            HeadingText = "Your age",
                            TextFontSize = 15,
                            HeadingTextFontWeight = FontWeight.Medium,
                            SurfacePadding = PaddingValues(start = 15.dp, top = 20.dp)
                        )

                        age = textfield(placeHolder = "Eg:56", checkError = {
                            it != "" && (it.toInt() > 101 || it.toInt() < 18)
                        })
                    }


                    //If Only Spouse is selcted
                    if (checkIfSelected(Members.Spouse) && !checkIfSelected(Members.MySelf)) {
                        HeadingText(
                            HeadingText = "age of your spouse",
                            TextFontSize = 15,
                            HeadingTextFontWeight = FontWeight.Medium,
                            SurfacePadding = PaddingValues(start = 15.dp, top = 20.dp)
                        )

                        age = textfield(placeHolder = "Eg:56", checkError = {
                            it != "" && (it.toInt() > 101 || it.toInt() < 18)
                        })

                    }


                    HeadingText(
                        HeadingText = "Your pincode",
                        TextFontSize = 15,
                        HeadingTextFontWeight = FontWeight.Medium,
                        SurfacePadding = PaddingValues(start = 15.dp, top = 20.dp)
                    )

                    //PinCode Store Variable
                    var pinCode by remember {
                        mutableStateOf("")
                    }

                    //PinCode TextField
                    pinCode = textfield(placeHolder = "Eg:560102", checkError = { it.length < 6 })

                    //Childern Count Store Variable
                    var childernCount by remember {
                        mutableIntStateOf(1)
                    }

                    //Son / Daughter Selected
                    if (checkIfSelected(Members.SD)) {

                        CounterArea(PlaceHolder = "Childerns") {
                            CounterTextArea(
                                UpdateTheCount = { count -> childernCount = count },
                                LowerBound = 1,
                                UpperBound = 8
                            )
                        }
                    }


                    //Ages of Parents/In-laws Store Array
                    val AgesPI: Array<MutableState<String>> = Array(4) {
                        mutableStateOf("")
                    }


                    //Parents / In-laws Selected
                    if (checkIfSelected(Members.PI)) {
                        CounterArea(PlaceHolder = "Parents/In-Laws") {
                            CounterTextArea(
                                UpdateTheCount = { count -> parentsCount = count },
                                LowerBound = 1,
                                UpperBound = 4
                            )
                        }

                        for (i in 1..parentsCount) {
                            HeadingText(
                                HeadingText = "Age of Parent/In-laws $i",
                                TextFontSize = 15,
                                HeadingTextFontWeight = FontWeight.Normal,
                                SurfacePadding = PaddingValues(start = 15.dp, top = 20.dp)
                            )
                            AgesPI[i - 1].value = textfield(placeHolder = "Eg: 56", checkError = {
                                it != "" && (it.toInt() > 101 || it.toInt() < 18)
                            })
                        }
                    }


                    //View Plans Button
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Button(
                            modifier = Modifier
                                .padding(start = 15.dp, end = 15.dp)
                                .fillMaxWidth()
                                .height(60.dp),
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
                                text = "VIEW PLANS ",
                                textAlign = TextAlign.Center,
                                lineHeight = 18.sp,
                                color = Color.White,
                            )
                        }

                    }
                }
            }

            SurfaceInView(Height = 100) {

            }

            Surface(modifier = Modifier.height(300.dp))
            {

            }
        }


        BlueTopAppBarScrollStateManaged(Heading = "Health Insurance", scrollstate = { scrollState.value.toFloat() })
    }



}


@Preview
@Composable
fun PreviewHealth() {
    PhonepeCloneTheme {
        HealthScreen()
    }
}

