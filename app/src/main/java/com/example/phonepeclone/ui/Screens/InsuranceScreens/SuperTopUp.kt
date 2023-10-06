package com.example.phonepeclone.ui.Screens.InsuranceScreens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Surface
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.phonepeclone.BlueTopAppBar
import com.example.phonepeclone.HeadingText
import com.example.phonepeclone.R
import com.example.phonepeclone.SurfaceInView
import com.example.phonepeclone.ThreeBoxRow
import com.example.phonepeclone.animatedLabelTextField
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme
import com.example.phonepeclone.ui.theme.Screens.InsuranceScreens.CounterTextArea

@Composable
fun SuperTopUpScreen() {

    var isSpouseSelected by remember {
        mutableStateOf(false)
    }

    var isMyselfSelected by remember {
        mutableStateOf(false)
    }

    //Weight of the Row Boxs inside the row
    val boxWeightList = listOf(0.3f, 0.7f, 0.2f)

    val checkBoxColors = CheckboxDefaults.colors(
        checkedColor = Color.Green,
        uncheckedColor = Color.White,
        checkmarkColor = colorResource(id = R.color.background)
    )
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
            SurfaceInView {
                Column {

                    HeadingText(HeadingText = "Select the persons you want to insure")

                    ThreeBoxRow(
                        firstBoxContent = {
                            //MySelf Icon
                            Icon(
                                modifier = Modifier.size(30.dp),
                                painter = painterResource(id = R.drawable.myself_logo),
                                contentDescription = null,
                                tint = Color(124, 84, 238, 255)
                            )
                        },
                        secondBoxContent = {
                            //MySelf Text
                            Text(
                                text = "Myself",
                                color = Color.White,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        },
                        thirdBoxContent = {
                            //MySelf CheckBox
                            Checkbox(
                                checked = isMyselfSelected,
                                onCheckedChange = { isMyselfSelected = it },
                                colors = checkBoxColors
                            )
                        },
                        boxWeightList = boxWeightList,
                        alignmentList = listOf(
                            Alignment.Center,
                            Alignment.CenterStart,
                            Alignment.Center
                        )
                    )

                    //Birth Date Textfield for Myself Insurance
                    if (isMyselfSelected) {
                        var mySelfdateOfBirth by remember {
                            mutableStateOf("")
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                        {
                            Box(modifier = Modifier.weight(0.3f)) {
                                //Spacer At the Start
                            }
                            Box(modifier = Modifier.weight(0.9f)) {
                                mySelfdateOfBirth = animatedLabelTextField(
                                    BoxPadding = PaddingValues(
                                        top = 20.dp,
                                        end = 20.dp,
                                        bottom = 20.dp
                                    ),
                                    Label = "Date of birth",
                                    PlaceHolder = "DD/MM/YYYY"
                                )
                            }
                        }

                    }

                    //Spouse Row
                    ThreeBoxRow(
                        firstBoxContent = {
                            //Spouse Icon
                            Icon(
                                modifier = Modifier.size(30.dp),
                                painter = painterResource(id = R.drawable.spouse_logo),
                                contentDescription = null,
                                tint = Color.Unspecified
                            )
                        },
                        secondBoxContent = {
                            //Spouse Text
                            Text(
                                text = "Spouse",
                                color = Color.White,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        },
                        thirdBoxContent = {
                            //Spouse Checkbox
                            Checkbox(
                                checked = isSpouseSelected,
                                onCheckedChange = { isSpouseSelected = it },
                                colors = checkBoxColors
                            )
                        },
                        boxWeightList = boxWeightList,
                        alignmentList = listOf(
                            Alignment.Center,
                            Alignment.CenterStart,
                            Alignment.Center
                        )
                    )

                    //Birth Date Textfield for Spouse Insurance
                    if (isSpouseSelected) {
                        var spousedateOfBirth by remember {
                            mutableStateOf("")
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                        {
                            Box(modifier = Modifier.weight(0.3f)) {
                                //Spacer At the Start
                            }
                            Box(modifier = Modifier.weight(0.9f)) {
                                spousedateOfBirth = animatedLabelTextField(
                                    BoxPadding = PaddingValues(
                                        top = 20.dp,
                                        end = 20.dp,
                                        bottom = 20.dp
                                    ),
                                    Label = "Date of birth",
                                    PlaceHolder = "DD/MM/YYYY"
                                )
                            }
                        }

                    }

                    var showChildrenInsuranceSection by remember {
                        mutableStateOf(false)
                    }

                    val toggleIcon: (Boolean) -> Int =
                        { isSelectd -> if (isSelectd) R.drawable.up_arrow else R.drawable.arrow_down_sign_to_navigate }

                    var iconSource = toggleIcon(showChildrenInsuranceSection)

                    //Children Insurance
                    Box{
                        ThreeBoxRow(
                            firstBoxContent = {
                                //Children Icon
                                Icon(
                                    modifier = Modifier.size(40.dp),
                                    painter = painterResource(id = R.drawable.children_logo),
                                    contentDescription = null,
                                    tint = Color(240, 186, 149, 255)
                                )
                            },
                            secondBoxContent = {
                                //Children Text
                                Column {
                                    Text(
                                        text = "Children",
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    )

                                    Text(
                                        text = "Dependent children from 3 months to 25 years",
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Light,
                                        color = Color.White
                                    )

                                }
                            },
                            thirdBoxContent = {
                                //Children dropdown Icon
                                Icon(
                                    modifier = Modifier
                                        .size(15.dp),
                                    painter = painterResource(id = iconSource),
                                    contentDescription = null,
                                    tint = Color.White
                                )
                            },
                            boxWeightList = boxWeightList,
                            alignmentList = listOf(
                                Alignment.Center,
                                Alignment.CenterStart,
                                Alignment.Center
                            ),
                            onClick = {
                                showChildrenInsuranceSection = !showChildrenInsuranceSection
                            }
                        )
                    }

                    var daughterCount by remember {
                        mutableIntStateOf(0)
                    }

                    //If Show Children is Selected
                    if (showChildrenInsuranceSection) {
                        ThreeBoxRow(
                            firstBoxContent = {},
                            secondBoxContent = {
                                Text(
                                    text = "Daughter(s)",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Normal,
                                    color = Color.White
                                )
                            },
                            thirdBoxContent = {
                                CounterTextArea(
                                    UpdateTheCount = { value -> daughterCount = value },
                                    UpperBound = 6,
                                    LowerBound = 0
                                )
                            },
                            boxWeightList = listOf(0.3f, 0.5f, 0.4f),
                            alignmentList = listOf(
                                Alignment.Center,
                                Alignment.CenterStart,
                                Alignment.Center
                            )
                        )
                    }

                    var showParentsInsuranceSection by remember {
                        mutableStateOf(false)
                    }

                    iconSource = toggleIcon(showParentsInsuranceSection)

                    //Parents Insurance
                    Box{
                        ThreeBoxRow(
                            firstBoxContent = {
                                //Parents Icon
                                Icon(
                                    modifier = Modifier.size(30.dp),
                                    painter = painterResource(id = R.drawable.parents_logo),
                                    contentDescription = null,
                                    tint = Color(240, 186, 149, 255)
                                )
                            },
                            secondBoxContent = {
                                //Parents Text
                                Text(
                                    text = "Parents and In Laws",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            },
                            thirdBoxContent = {
                                //Parents dropdown Icon
                                Icon(
                                    modifier = Modifier
                                        .size(15.dp),
                                    painter = painterResource(id = iconSource),
                                    contentDescription = null,
                                    tint = Color.White
                                )
                            },
                            boxWeightList = boxWeightList,
                            alignmentList = listOf(
                                Alignment.Center,
                                Alignment.CenterStart,
                                Alignment.Center
                            ),
                            onClick = {
                                showParentsInsuranceSection = !showParentsInsuranceSection
                            }
                        )
                    }

                    if (showParentsInsuranceSection) {
                        Column {
                            CheckBoxs(Label = "Mother")
                            CheckBoxs(Label = "Father")
                            CheckBoxs(Label = "Mother in Law")
                            CheckBoxs(Label = "Father in Law")
                        }
                    }


                }
            }
            SurfaceInView(Height = 100) {}
        }

        BlueTopAppBar(Heading = "Super Top-Up")
    }

}


@Composable
fun CheckBoxs(Label: String) {

    val checkBoxColors = CheckboxDefaults.colors(
        checkedColor = Color.Green,
        uncheckedColor = Color.White,
        checkmarkColor = colorResource(id = R.color.background)
    )

    var birthDate by remember {
        mutableStateOf("")
    }
    var isCheckBoxSelected by remember {
        mutableStateOf(false)
    }
    ThreeBoxRow(
        firstBoxContent = {},
        secondBoxContent = {
            Text(
                text = Label,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = Color.White
            )
        },
        thirdBoxContent = {
            Checkbox(
                checked = isCheckBoxSelected,
                onCheckedChange = { isCheckBoxSelected = it },
                colors = checkBoxColors
            )
        },
        boxWeightList = listOf(0.3f, 0.7f, 0.2f),
        alignmentList = listOf(
            Alignment.Center,
            Alignment.CenterStart,
            Alignment.Center
        )
    )

    if (isCheckBoxSelected) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        )
        {
            Box(modifier = Modifier.weight(0.3f)) {
                //Spacer At the Start
            }
            Box(modifier = Modifier.weight(0.9f)) {
                birthDate = animatedLabelTextField(
                    BoxPadding = PaddingValues(
                        top = 20.dp,
                        end = 20.dp,
                        bottom = 20.dp
                    ),
                    Label = "Date of birth",
                    PlaceHolder = "DD/MM/YYYY"
                )
            }
        }
    }

}


@Preview
@Composable
fun PreviewSuperTopUpScreen() {
    PhonepeCloneTheme {
        SuperTopUpScreen()
    }
}
