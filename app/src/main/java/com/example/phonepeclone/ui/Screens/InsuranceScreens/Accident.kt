package com.example.phonepeclone.ui.theme.Screens.InsuranceScreens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
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
import com.example.phonepeclone.BlueTopAppBar
import com.example.phonepeclone.BottomAppBarAsButton
import com.example.phonepeclone.HeadingTextInSurfaceView
import com.example.phonepeclone.R
import com.example.phonepeclone.SurfaceInView
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme


data class Sums(
    val InsuranceMoney: String,
    val InsurancePrice: String,
    var isSelected: MutableState<Boolean>
)


@Composable
fun RowWithDividerRadioButton(
    FirstContent: String,
    SecondContent: String,
    RadioButtonOnClick: () -> Unit = {},
    IconResource: Int,
    IconTint: Color
) {
    Row(
        modifier = Modifier.height(35.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.80f),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                modifier = Modifier.padding(start = 20.dp),
                text = FirstContent,
                color = Color.White,
                fontSize = 15.sp,
                textAlign = TextAlign.Center
            )
        }

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.40f),
            contentAlignment = Alignment.CenterEnd
        ) {
            Text(
                text = SecondContent,
                color = Color.White,
                fontSize = 15.sp
            )
        }

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.30f),
            contentAlignment = Alignment.CenterStart
        ) {
            Icon(
                modifier = Modifier
                    .padding(start = 15.dp)
                    .size(24.dp)
                    .clickable {
                        RadioButtonOnClick()
                    },
                painter = painterResource(id = IconResource),
                contentDescription = null,
                tint = IconTint
            )
        }


    }

    Divider(
        modifier = Modifier.padding(
            start = 20.dp,
            end = 20.dp,
            top = 10.dp,
            bottom = 10.dp
        ),
        color = Color(46, 37, 56, 255),
        thickness = 2.dp
    )
}


@Composable
fun AccidentScreen() {

    val SumsList = arrayListOf<Sums>()

    SumsList.add(
        Sums("₹50,000", "₹25", rememberSaveable { mutableStateOf(false) })
    )
    SumsList.add(
        Sums("₹1,00,000", "₹49", rememberSaveable { mutableStateOf(true) })
    )
    SumsList.add(
        Sums("₹5,00,000", "₹249", rememberSaveable { mutableStateOf(false) })
    )
    SumsList.add(
        Sums("₹10,00,000", "₹549", rememberSaveable { mutableStateOf(false) })
    )
    SumsList.add(
        Sums("₹20,00,000", "₹1099", rememberSaveable { mutableStateOf(false) })
    )

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = colorResource(id = R.color.background)
    ) {


        Column(modifier = Modifier.padding(top = 70.dp)) {
            SurfaceInView(Height = 150) {
                HeadingTextInSurfaceView(
                    HeadingText = "Accident Insurance",
                    HeadingTextFontWeight = FontWeight.Normal
                )
            }

            SurfaceInView(
                Height = 360,
                surfaceColor = colorResource(id = R.color.scrollable_view),
            ) {
                Column {
                    HeadingTextInSurfaceView(
                        HeadingText = "Select sum insured",
                        SurfacePadding = PaddingValues(start = 20.dp, top = 15.dp, bottom = 20.dp)
                    )

                    SumsList.forEach { item ->

                        val iconResource: Int =
                            if (item.isSelected.value) R.drawable.true_sign else R.drawable.radio_button

                        val iconTint: Color =
                            if (item.isSelected.value) Color.Unspecified else Color.White

                        RowWithDividerRadioButton(

                            FirstContent = item.InsuranceMoney,

                            SecondContent = item.InsurancePrice,

                            RadioButtonOnClick = {
                                SumsList.forEach { CurrentItem ->
                                    CurrentItem.isSelected.value =
                                        CurrentItem.InsurancePrice == item.InsurancePrice
                                }
                            },

                            IconResource = iconResource,

                            IconTint = iconTint
                        )
                    }

                }

            }
        }
        BlueTopAppBar(Heading = "Accident Insurance")

        BottomAppBarAsButton(Content = {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "GET POLICY",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontSize = 15.sp
                )
                Text(
                    text = "in just 2 minutes",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp
                )
            }
        })
    }
}

@Preview
@Composable
fun PreviewAccidentScreen() {
    PhonepeCloneTheme {
        AccidentScreen()
    }
}

