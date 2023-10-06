package com.example.phonepeclone.ui.Screens.RechargeAndBillScreens

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.phonepeclone.BlueTopAppBar
import com.example.phonepeclone.FullPurpleButton
import com.example.phonepeclone.HeadingText
import com.example.phonepeclone.R
import com.example.phonepeclone.SurfaceInView
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme
import kotlinx.coroutines.launch

sealed class bottomSheetScreens {
    object stateScreen : bottomSheetScreens()
    object cityScreen : bottomSheetScreens()
}


val stateTocityMap: LinkedHashMap<String, List<String>> = linkedMapOf(
    "Andaman and Nicobar Islands" to listOf("Other"),
    "Andhra Pradesh" to listOf("Other"),
    "Delhi" to listOf("East Delhi"),
    "Gujarat" to listOf("Ahmedabad", "Gandhinagar", "Other"),
    "Harayana" to listOf("Gurgaon"),
    "Kerala" to listOf("Ernakulam", "Other", "Thiruvananthpuram"),
    "Maharashtra" to listOf("Mumbai", "Other", "Pune", "Raigad", "Thane"),
    "Rajasthan" to listOf("Alwar", "Jaipur"),
    "Tamil Nadu" to listOf("Other"),
    "Telangana" to listOf("Hyderabad"),
    "Uttar Pradesh" to listOf("Gautam Budh Nagar", "Ghaziabad", "Noida", "Other"),
    "Uttarakhand" to listOf("Other"),
    "West Bangal" to listOf("Other")
)

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun stateBottomSheetScreen(sheetState: ModalBottomSheetState, onChangeState: (String) -> Unit) {

    val scope = rememberCoroutineScope()
    Row(
        modifier = Modifier
            .padding(top = 20.dp, start = 20.dp, bottom = 30.dp)
            .height(35.dp)
    ) {

        Text(
            modifier = Modifier.weight(1.5f),
            text = "Select State",
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(), contentAlignment = Alignment.CenterEnd
        ) {
            Icon(
                modifier = Modifier
                    .padding(end = 20.dp)
                    .size(20.dp)
                    .clickable(
                        indication = null,
                        interactionSource = MutableInteractionSource()
                    ) {
                        scope.launch {
                            sheetState.hide()
                        }
                    },
                painter = painterResource(id = R.drawable.close_button),
                contentDescription = null,
                tint = Color.White
            )
        }
    }

    Column {
        val states = stateTocityMap.keys
        states.forEachIndexed { index, state ->
            Box(modifier = Modifier
                .padding(top = 10.dp, bottom = 10.dp)
                .fillMaxWidth()
                .clickable(indication = null, interactionSource = MutableInteractionSource()) {
                    onChangeState(state)
                    scope.launch {
                        sheetState.hide()
                    }
                }) {
                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = state,
                    color = Color.White,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Normal
                )
            }

            if (index <= states.size - 2) {
                Box(contentAlignment = Alignment.BottomCenter) {
                    Divider(
                        modifier = Modifier.padding(start = 20.dp),
                        color = colorResource(id = R.color.divider_color_2)
                    )
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun cityBottomSheetScreen(
    sheetState: ModalBottomSheetState,
    cityList: List<String>,
    onChangeState: (String) -> Unit
) {
    val scope = rememberCoroutineScope()
    Row(
        modifier = Modifier
            .padding(top = 20.dp, start = 20.dp, bottom = 30.dp)
            .height(35.dp)
    ) {

        Text(
            modifier = Modifier.weight(1.5f),
            text = "Select City",
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(), contentAlignment = Alignment.CenterEnd
        ) {
            Icon(
                modifier = Modifier
                    .padding(end = 20.dp)
                    .size(20.dp)
                    .clickable(
                        indication = null,
                        interactionSource = MutableInteractionSource()
                    ) {
                        scope.launch {
                            sheetState.hide()
                        }
                    },
                painter = painterResource(id = R.drawable.close_button),
                contentDescription = null,
                tint = Color.White
            )
        }
    }

    Column {
        cityList.forEachIndexed { index, item ->
            Box(modifier = Modifier
                .padding(top = 10.dp, bottom = 10.dp)
                .fillMaxWidth()
                .clickable(indication = null, interactionSource = MutableInteractionSource()) {
                    scope.launch {
                        sheetState.hide()
                    }
                    onChangeState(cityList[index])
                }) {
                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = item,
                    color = Color.White,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Normal
                )
            }

            if (index <= cityList.size - 2) {
                Box(contentAlignment = Alignment.BottomCenter) {
                    Divider(
                        modifier = Modifier.padding(start = 20.dp),
                        color = colorResource(id = R.color.divider_color_2)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ApartmentScreen() {


    val sheetState =
        rememberModalBottomSheetState(ModalBottomSheetValue.Hidden, skipHalfExpanded = true)
    val coroutineScope = rememberCoroutineScope()
    var currentlySelectedScreen: bottomSheetScreens? by remember {
        mutableStateOf(bottomSheetScreens.stateScreen)
    }
    var currentlyselectedState by remember {
        mutableStateOf("Gujarat")
    }
    var currentlyselecetedCity by remember {
        mutableStateOf("")
    }
    var stateName by remember {
        mutableStateOf(currentlyselectedState)
    }
    var cityName by remember {
        mutableStateOf(currentlyselecetedCity)
    }
    val labelUpperOffset = 23
    val labelLowerOffset = 0

    val stateFieldLabelOffset by animateDpAsState(
        targetValue = if (stateName.isNotEmpty()) labelUpperOffset.dp else labelLowerOffset.dp,
        label = "stateField"
    )

    val cityFieldLabelOffset by animateDpAsState(
        targetValue = if (cityName.isNotEmpty()) labelUpperOffset.dp else labelLowerOffset.dp,
        label = "cityField"
    )


    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetBackgroundColor = Color(33, 24, 43, 255),

        //-------------------- Sheet Content--------------------------

        sheetContent = {


            if (currentlySelectedScreen == bottomSheetScreens.stateScreen) {
                stateBottomSheetScreen(sheetState, onChangeState = {
                    currentlyselectedState = it
                    stateName = currentlyselectedState
                    cityName = if (stateTocityMap[currentlyselectedState]?.size  == 1) {
                        stateTocityMap[currentlyselectedState]?.get(0).toString()
                    } else {
                        ""
                    }

                })
            }
            if (currentlySelectedScreen == bottomSheetScreens.cityScreen) {
                stateTocityMap[currentlyselectedState]?.let {
                    cityBottomSheetScreen(
                        sheetState = sheetState,
                        cityList = it,
                        onChangeState = { city ->
                            currentlyselecetedCity = city
                            cityName = currentlyselecetedCity
                        }
                    )
                }
            }
        }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .clickable(indication = null, interactionSource = MutableInteractionSource()) {
                    coroutineScope.launch {
                        sheetState.hide()
                    }
                },
            color = colorResource(id = R.color.background)
        ) {
            Column(modifier = Modifier.padding(top = 70.dp)) {
                SurfaceInView(Height = 300) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 20.dp, end = 20.dp)
                    ) {
                        HeadingText(
                            HeadingText = "Select state and city",
                            TextFontSize = 20,
                            SurfacePadding = PaddingValues(top = 10.dp)
                        )

                        //-------------------Static Text Field--------------------------
                        //-------------------Which is Clickable-------------------------
                        Box(
                            modifier = Modifier
                                .padding(top = 40.dp)
                                .fillMaxWidth()
                        ) {

                            Text(
                                text = "State",
                                color = Color.White,
                                modifier = Modifier
                                    .offset(y = -stateFieldLabelOffset),
                                fontSize = 14.sp
                            )
                            BasicTextField(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(40.dp)
                                    .clickable(
                                        indication = null,
                                        interactionSource = MutableInteractionSource()
                                    ) {
                                        currentlySelectedScreen = bottomSheetScreens.stateScreen
                                        coroutineScope.launch {
                                            sheetState.show()
                                        }
                                    },
                                value = stateName,
                                enabled = false,
                                onValueChange = { newText: String ->
                                    stateName = newText
                                },
                                maxLines = 1,
                                textStyle = TextStyle(fontSize = 20.sp, color = Color.White)
                            )

                            Spacer(
                                modifier = Modifier
                                    .align(Alignment.BottomCenter)
                                    .fillMaxWidth()
                                    .height(1.dp)
                                    .background(Color.White)
                            )
                        }

                        //-------------------City Field---------------------------
                        Box(
                            modifier = Modifier
                                .padding(top = 35.dp)
                                .fillMaxWidth()
                        ) {

                            if (cityName.isNotEmpty()) {
                                Text(
                                    text = "City",
                                    color = Color.White,
                                    modifier = Modifier
                                        .offset(y = -cityFieldLabelOffset),
                                    fontSize = 14.sp
                                )
                            }


                            if (cityName.isEmpty()) {
                                Text(
                                    text = "Select City",
                                    color = Color(159, 144, 174, 255),
                                    modifier = Modifier,
                                    fontSize = 20.sp
                                )
                            }

                            BasicTextField(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(40.dp)
                                    .clickable(
                                        indication = null,
                                        interactionSource = MutableInteractionSource()
                                    ) {
                                        currentlySelectedScreen = bottomSheetScreens.cityScreen
                                        coroutineScope.launch {
                                            sheetState.show()
                                        }
                                    },
                                value = cityName,
                                enabled = false,
                                onValueChange = { newText: String ->
                                    cityName = newText
                                },
                                maxLines = 1,
                                textStyle = TextStyle(fontSize = 20.sp, color = Color.White)
                            )

                            Spacer(
                                modifier = Modifier
                                    .align(Alignment.BottomCenter)
                                    .fillMaxWidth()
                                    .height(1.dp)
                                    .background(Color.White)
                            )
                        }



                        FullPurpleButton(
                            ButtonPadding = PaddingValues(
                                top = 20.dp
                            ),
                            ButtonLabel = "CONTINUE",
                            ButtonLabelFontSize = 18,
                            ButtonColor = Color(163, 99, 235, 255),
                            ButtonHeight = 55,
                            ContentPadding = PaddingValues(
                                start = 35.dp,
                                end = 35.dp,
                                top = 5.dp,
                                bottom = 5.dp
                            ),
                            OnClick = {

                            }
                        )
                    }

                }
            }
        }
    }

    BlueTopAppBar(Heading = "Apartments")


}

@Preview
@Composable
fun PreviewApartmentScreen() {
    PhonepeCloneTheme {
        ApartmentScreen()
    }
}

