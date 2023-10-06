package com.example.phonepeclone.ui.Screens.HomeUnitScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.phonepeclone.BlueTopAppBar
import com.example.phonepeclone.HeadingText
import com.example.phonepeclone.R
import com.example.phonepeclone.SelectionButton
import com.example.phonepeclone.SurfaceInView
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme
import kotlinx.coroutines.launch


data class Choices(val ButtonName: String, val Screen: @Composable () -> Unit)


@Composable
fun SortByScreen(
    onClose: () -> Unit,
    eachChoiceAttachedSelectionClick: () -> Unit,
    updateTheCurrentlySelected: (String) -> Unit
) {

    var currentlySelectedChoice by remember {
        mutableStateOf("Preference")
    }

    val choiceList = arrayListOf<String>()
    choiceList.add("Preference")
    choiceList.add("Latest")
    choiceList.add("Validity")

    Column {
        Row(
            modifier = Modifier
                .padding(start = 20.dp, top = 5.dp)
                .fillMaxWidth()
                .height(70.dp)
        ) {
            Box(modifier = Modifier.weight(0.9f)) {
                HeadingText(
                    HeadingText = "Sort by",
                    HeadingTextFontWeight = FontWeight.Bold,
                    TextFontSize = 30,
                    SurfacePadding = PaddingValues(
                        top = 10.dp,
                        bottom = 20.dp
                    )
                )
            }

            Box(
                modifier = Modifier
                    .weight(0.3f)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier
                        .size(20.dp)
                        .clickable(
                            indication = null,
                            interactionSource = MutableInteractionSource()
                        )
                        {
                            onClose()
                        },
                    painter = painterResource(id = R.drawable.close_button),
                    contentDescription = null,
                    tint = Color.LightGray
                )
            }

        }


        choiceList.forEach { item ->
            Row(modifier = Modifier
                .padding(start = 20.dp, top = 20.dp, bottom = 20.dp)
                .clickable(
                    indication = null,
                    interactionSource = MutableInteractionSource()
                ) {
                    currentlySelectedChoice = item
                    updateTheCurrentlySelected(currentlySelectedChoice)
                    eachChoiceAttachedSelectionClick()

                }) {
                Box(modifier = Modifier.weight(0.9f))
                {
                    Text(text = item, color = Color.White, fontSize = 17.sp)
                }
                Box(modifier = Modifier.weight(0.3f), contentAlignment = Alignment.Center)
                {
                    if (currentlySelectedChoice == item) {
                        Icon(
                            modifier = Modifier.size(20.dp),
                            painter = painterResource(id = R.drawable.true_sign),
                            contentDescription = null,
                            tint = Color.Unspecified
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun SelectionButtonInRewardScreen(
    buttonPadding: PaddingValues,
    buttonContentPadding: PaddingValues,
    buttonBorderColor: Color,
    buttonBackGroundColor: Color,
    buttonLabel: String,
    onClick: () -> Unit,
    leadingIconSource: Int
) {
    SelectionButton(
        ButtonModifier = Modifier,
        ButtonPadding = buttonPadding,
        ButtonContentPadding = buttonContentPadding,
        ButtonHeight = 35,
        ButtonBackGroundColor = buttonBackGroundColor,
        ButtonBorderColor = buttonBorderColor,
        ButtonLabel = buttonLabel,
        IconSize = 12,
        IconResource = R.drawable.caret_down_solid,
        IconPadding = PaddingValues(start = 5.dp),
        OnClick = { onClick() },
        LeadingContent = {
            Icon(
                modifier = Modifier
                    .padding(end = 5.dp)
                    .size(15.dp),
                painter = painterResource(id = leadingIconSource),
                contentDescription = null,
                tint = Color.White
            )
        }
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RewardScreen() {


    val choiceSelectionList = arrayListOf<Choices>()


    var favouriteButtonClicked by remember { mutableStateOf(false) }

    val buttonBorderColor: Color =
        if (!favouriteButtonClicked) Color(49, 40, 61, 255) else Color(76, 132, 103, 255)
    val buttonBackgroundColor: Color =
        if (!favouriteButtonClicked) Color.Transparent else Color(40, 51, 48, 255)

    val sheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    var currentlySelectedChoice by remember {
        mutableStateOf("Preference")
    }

    var currentlySelctedSheetButton by remember {
        mutableStateOf("Filter")
    }
    val coroutineScope = rememberCoroutineScope()


    choiceSelectionList.add(
        Choices(ButtonName = "SortBy", Screen = {
            SortByScreen(
                onClose = {
                    coroutineScope.launch {
                        sheetState.hide()
                    }
                },
                eachChoiceAttachedSelectionClick = {
                    coroutineScope.launch {
                        sheetState.hide()
                    }
                },
                updateTheCurrentlySelected = {
                    currentlySelectedChoice = it
                }
            )
        })
    )
    choiceSelectionList.add(
        Choices(ButtonName = "Filter", Screen = {
            HeadingText(HeadingText = "Select Categories", TextFontSize = 25)
        })
    )

    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetBackgroundColor = Color(33, 24, 43, 255),
        //Sheet Content
        sheetContent = {
            if (currentlySelctedSheetButton == choiceSelectionList[0].ButtonName) {
                choiceSelectionList[0].Screen()
            }
            if (currentlySelctedSheetButton == choiceSelectionList[1].ButtonName) {
                choiceSelectionList[1].Screen()
            }
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.background))
                .clickable(indication = null, interactionSource = MutableInteractionSource()) {
                    coroutineScope.launch {
                        sheetState.hide()
                    }
                },
            contentAlignment = Alignment.TopCenter
        ) {
            Column(modifier = Modifier.padding(top = 70.dp)) {
                SurfaceInView(Height = 150, surfaceColor = Color.Red) {

                }

                SurfaceInView(Height = 70) {
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        Row(modifier = Modifier.fillMaxWidth()) {

                            //Validity Button
                            Box {
                                SelectionButtonInRewardScreen(
                                    buttonPadding = PaddingValues(start = 10.dp, end = 10.dp),
                                    buttonContentPadding = PaddingValues(
                                        start = 10.dp,
                                        end = 10.dp,
                                        top = 2.dp,
                                        bottom = 2.dp
                                    ),
                                    onClick = {
                                        currentlySelctedSheetButton =
                                            choiceSelectionList[0].ButtonName
                                        coroutineScope.launch {
                                            if (sheetState.isVisible) {
                                                sheetState.hide()
                                            } else {
                                                sheetState.show()
                                            }
                                        }
                                    },
                                    buttonLabel = currentlySelectedChoice,
                                    buttonBackGroundColor = Color.Transparent,
                                    buttonBorderColor = Color(49, 40, 61, 255),
                                    leadingIconSource = R.drawable.validity_logo
                                )
                            }

                            //Filter Button
                            Box {
                                SelectionButtonInRewardScreen(
                                    buttonPadding = PaddingValues(end = 10.dp),
                                    buttonContentPadding = PaddingValues(
                                        start = 10.dp,
                                        end = 15.dp,
                                        top = 2.dp,
                                        bottom = 2.dp
                                    ),
                                    onClick = {
                                        currentlySelctedSheetButton =
                                            choiceSelectionList[1].ButtonName

                                        coroutineScope.launch {
                                            if (sheetState.isVisible) {
                                                sheetState.hide()
                                            } else {
                                                sheetState.show()
                                            }
                                        }
                                    },
                                    buttonLabel = "Filter",
                                    buttonBackGroundColor = Color.Transparent,
                                    buttonBorderColor = Color(49, 40, 61, 255),
                                    leadingIconSource = R.drawable.filter_logo
                                )
                            }

                            //Favourites Button
                            Box {
                                SelectionButtonInRewardScreen(
                                    buttonPadding = PaddingValues(end = 10.dp),
                                    buttonContentPadding = PaddingValues(
                                        start = 10.dp,
                                        end = 10.dp,
                                        top = 2.dp,
                                        bottom = 2.dp
                                    ),
                                    onClick = {
                                        favouriteButtonClicked = !favouriteButtonClicked
                                    },
                                    buttonLabel = "Favourites",
                                    buttonBackGroundColor = buttonBackgroundColor,
                                    buttonBorderColor = buttonBorderColor,
                                    leadingIconSource = R.drawable.favourites_logo
                                )
                            }
                        }
                    }

                }

            }
        }


    }

    BlueTopAppBar(Heading = "Rewards")


}

@Preview
@Composable
fun PreviewRewardScreen() {
    PhonepeCloneTheme {
        RewardScreen()
    }
}

