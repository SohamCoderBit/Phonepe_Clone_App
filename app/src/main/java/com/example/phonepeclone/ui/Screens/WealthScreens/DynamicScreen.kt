package com.example.phonepeclone.ui.Screens.WealthScreens

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Divider
import androidx.compose.material.LocalTextStyle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Observer
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.phonepeclone.BlueTopAppBar
import com.example.phonepeclone.ClickableSurface
import com.example.phonepeclone.HeadingTextInSurfaceView
import com.example.phonepeclone.R
import com.example.phonepeclone.SurfaceInView
import com.example.phonepeclone.ViewModels.DynamicScreenViewModel
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme

@Composable
fun RadioButton(
    Label: String,
    IconSource: Int,
    IconTint: Color = Color.Unspecified,
) {
    Row(
        modifier = Modifier.padding(start = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .padding(start = 5.dp)
                .size(23.dp),
            painter = painterResource(id = IconSource),
            contentDescription = null,
            tint = IconTint
        )

        Text(
            modifier = Modifier.padding(start = 5.dp),
            text = Label,
            color = Color.White,
            fontSize = 15.sp,
            textAlign = TextAlign.Center
        )
    }
}


data class IconConfig(val IconSource: Int, val IconTint: Color)

fun setIconConfiguration(isSelected: Boolean): IconConfig {
    if (isSelected) {
        return IconConfig(IconSource = R.drawable.true_sign, IconTint = Color.Unspecified)
    }
    return IconConfig(IconSource = R.drawable.radio_button, IconTint = Color.White)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DynamicScreen(dynamicScreenViewModel:DynamicScreenViewModel) {
    var heading = ""
    val headingTextObserver = Observer<String> {newHeading -> heading = newHeading}
    dynamicScreenViewModel.HeadingText.observeForever(headingTextObserver)

    var Type1 by remember {
        mutableStateOf(true)
    }

    var Type2 by remember {
        mutableStateOf(false)
    }

    var investmentAmount by remember {
        mutableStateOf("100")
    }

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = colorResource(id = R.color.background)
    ) {

        Column(modifier = Modifier.padding(top = 70.dp)) {
            SurfaceInView(Height = 450) {
                Column {
                    Row {

                        //Biller Icon
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(80.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                modifier = Modifier
                                    .height(60.dp),
                                painter = painterResource(id = R.mipmap.icici_fund_foreground),
                                contentDescription = null
                            )
                        }

                        //Biller Name
                        Box(
                            modifier = Modifier
                                .weight(3f)
                                .height(80.dp),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Column {
                                Text(
                                    text = heading,
                                    color = Color.White,
                                    fontSize = 16.sp
                                )
                            }
                        }

                        //Info Icon
                        Box(
                            modifier = Modifier
                                .weight(0.8f)
                                .height(80.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                modifier = Modifier
                                    .height(15.dp),
                                painter = painterResource(id = R.drawable.info_logo),
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    }

                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 10.dp),
                        color = Color(42, 33, 52, 255)
                    )

                    HeadingTextInSurfaceView(
                        HeadingText = "Investment type",
                        SurfacePadding = PaddingValues(start = 10.dp, top = 10.dp),
                        TextFontSize = 12,
                        HeadingTextFontWeight = FontWeight.Light,
                        HeadingTextColor = Color.LightGray
                    )

                    //Investment Type
                    Row(modifier = Modifier.height(50.dp)) {

                        val boxModifier: Modifier = Modifier
                            .fillMaxHeight()

                        //Monthly SIP Button
                        Box(
                            modifier = boxModifier
                                .weight(0.7f)
                                .clickable(
                                    indication = null,
                                    interactionSource = MutableInteractionSource()
                                ) {
                                    if (!Type1) {
                                        Type1 = true
                                        Type2 = !Type2
                                    }
                                },
                            contentAlignment = Alignment.CenterStart
                        ) {

                            val iconConfig = setIconConfiguration(Type1)
                            RadioButton(
                                Label = "Monthly SIP",
                                IconSource = iconConfig.IconSource,
                                IconTint = iconConfig.IconTint
                            )
                        }

                        //One Time Button
                        Box(
                            modifier = boxModifier
                                .weight(1f)
                                .clickable(
                                    indication = null,
                                    interactionSource = MutableInteractionSource()
                                ) {
                                    if (!Type2) {
                                        Type1 = !Type1
                                        Type2 = true
                                    }
                                },
                            contentAlignment = Alignment.CenterStart
                        ) {
                            val iconConfig = setIconConfiguration(Type2)
                            RadioButton(
                                Label = "One Time",
                                IconSource = iconConfig.IconSource,
                                IconTint = iconConfig.IconTint
                            )
                        }
                    }

                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 10.dp, top = 10.dp),
                        color = Color(42, 33, 52, 255)
                    )

                    HeadingTextInSurfaceView(
                        HeadingText = "Investment Amount",
                        SurfacePadding = PaddingValues(start = 10.dp, top = 10.dp),
                        TextFontSize = 12,
                        HeadingTextFontWeight = FontWeight.Light,
                        HeadingTextColor = Color.LightGray
                    )


                    OutlinedTextField(
                        modifier = Modifier
                            .padding(start = 15.dp, end = 15.dp, top = 10.dp, bottom = 10.dp)
                            .height(65.dp)
                            .fillMaxWidth(),
                        value = investmentAmount,
                        onValueChange = {
                            investmentAmount = it
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            textColor = Color.White,
                            containerColor = Color.Transparent,
                            cursorColor = Color(163, 99, 235, 255)
                        ),
                        placeholder = {},
                        maxLines = 1,
                        textStyle = LocalTextStyle.current.copy(fontSize = 25.sp),
                        shape = RoundedCornerShape(15),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.NumberPassword
                        ),
                        leadingIcon = {
                           Icon(
                                modifier = Modifier.size(30.dp),
                                painter = painterResource(
                                    id = R.drawable.rupee_logo
                                ),
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    )


                    HeadingTextInSurfaceView(
                        HeadingText = "Popular amounts",
                        SurfacePadding = PaddingValues(start = 10.dp, top = 10.dp , bottom = 10.dp),
                        TextFontSize = 12,
                        HeadingTextColor = Color.LightGray
                    )

                    //Popular Amount
                    Row(modifier = Modifier.padding(start = 15.dp, bottom = 15.dp)) {
                        ClickableSurface(Label = "₹200" , SurfaceHeight = 35 , SurfaceWidth =  70) {
                            investmentAmount = "200"
                        }

                        ClickableSurface(Label = "₹500" , SurfaceHeight = 35 , SurfaceWidth =  70) {
                            investmentAmount = "500"
                        }

                        ClickableSurface(Label = "₹1000" , SurfaceHeight = 35 , SurfaceWidth =  70) {
                            investmentAmount = "1000"
                        }
                    }
                }
            }
        }

        BlueTopAppBar(Heading = "Invest Amount")
    }
}


@Preview
@Composable
fun PreviewDynamicScreen() {
    PhonepeCloneTheme {
        DynamicScreen(viewModel())
    }
}

