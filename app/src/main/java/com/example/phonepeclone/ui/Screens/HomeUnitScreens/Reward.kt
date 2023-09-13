package com.example.phonepeclone.ui.Screens.HomeUnitScreens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.phonepeclone.BlueTopAppBar
import com.example.phonepeclone.R
import com.example.phonepeclone.SelectionButton
import com.example.phonepeclone.SurfaceInView
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme


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
        ButtonModifier = Modifier.fillMaxWidth(),
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


    var favouriteButtonClicked by remember { mutableStateOf(false) }
    val buttonBorderColor: Color =
        if (!favouriteButtonClicked) Color(49, 40, 61, 255) else Color(76, 132, 103, 255)
    val buttonBackgroundColor: Color =
        if (!favouriteButtonClicked) Color.Transparent else Color(40, 51, 48, 255)


    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = colorResource(id = R.color.background)
    ) {

        Column(modifier = Modifier.padding(top = 70.dp)) {
            SurfaceInView(Height = 150, surfaceColor = Color.Red) {

            }

            SurfaceInView(Height = 70) {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Row(modifier = Modifier.fillMaxWidth()) {

                        //Validity Button
                        Box(modifier = Modifier.weight(1.2f)) {
                            SelectionButtonInRewardScreen(
                                buttonPadding = PaddingValues(start = 10.dp, end = 10.dp),
                                buttonContentPadding = PaddingValues(
                                    start = 10.dp,
                                    end = 15.dp,
                                    top = 2.dp,
                                    bottom = 2.dp
                                ),
                                onClick = { },
                                buttonLabel = "Validity",
                                buttonBackGroundColor = Color.Transparent,
                                buttonBorderColor = Color(49, 40, 61, 255),
                                leadingIconSource = R.drawable.validity_logo
                            )
                        }

                        //Filter Button
                        Box(modifier = Modifier.weight(1f)) {
                            SelectionButtonInRewardScreen(
                                buttonPadding = PaddingValues(end = 10.dp),
                                buttonContentPadding = PaddingValues(
                                    start = 10.dp,
                                    end = 15.dp,
                                    top = 2.dp,
                                    bottom = 2.dp
                                ),
                                onClick = {},
                                buttonLabel = "Filter",
                                buttonBackGroundColor = Color.Transparent,
                                buttonBorderColor = Color(49, 40, 61, 255),
                                leadingIconSource = R.drawable.filter_logo
                            )
                        }

                        //Favourites Button
                        Box(modifier = Modifier.weight(1.2f)) {
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

        BlueTopAppBar(Heading = "Rewards")
    }


}

@Preview
@Composable
fun PreviewRewardScreen() {
    PhonepeCloneTheme {
        RewardScreen()
    }
}

