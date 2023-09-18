package com.example.phonepeclone.ui.Screens.HomeUnitScreens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.phonepeclone.BlueTopAppBar
import com.example.phonepeclone.ClickableSurface
import com.example.phonepeclone.FullPurpleButton
import com.example.phonepeclone.HeadingTextInSurfaceView
import com.example.phonepeclone.R
import com.example.phonepeclone.SurfaceInView
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UPILiteScreen() {


    var moneyAmountFromUser by remember {
        mutableStateOf("")
    }
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = colorResource(id = R.color.background)
    ) {

        Column(modifier = Modifier.padding(top = 70.dp)) {
            SurfaceInView(Height = 320) {
                Column {
                    HeadingTextInSurfaceView(
                        HeadingText = "Add money",
                        SurfacePadding = PaddingValues(start = 20.dp, top = 10.dp, bottom = 10.dp)
                    )

                    OutlinedTextField(
                        modifier = Modifier
                            .padding(start = 15.dp, end = 15.dp, top = 10.dp, bottom = 10.dp)
                            .height(65.dp)
                            .fillMaxWidth(),
                        value = moneyAmountFromUser,
                        onValueChange = {
                            moneyAmountFromUser = it
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

                    Row(modifier = Modifier.padding(start = 15.dp, bottom = 15.dp)) {
                        ClickableSurface(Label = "₹200") {
                            moneyAmountFromUser = "200"
                        }

                        ClickableSurface(Label = "₹1000") {
                            moneyAmountFromUser = "1000"
                        }

                        ClickableSurface(Label = "₹2000") {
                            moneyAmountFromUser = "2000"
                        }
                    }

                    FullPurpleButton(
                        ButtonPadding = PaddingValues(start = 15.dp, end = 15.dp),
                        ButtonLabel = "ADD MONEY",
                        ButtonLabelFontSize = 18,
                        ButtonHeight = 60,
                        ButtonColor = Color(163, 99, 235, 255),
                        ContentPadding = PaddingValues(
                            start = 35.dp,
                            end = 35.dp,
                            top = 5.dp,
                            bottom = 5.dp
                        )
                    ) {

                    }

                    Box(
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = buildAnnotatedString {
                                withStyle(style = SpanStyle(Color.LightGray)) {
                                    append(stringResource(id = R.string.T_an_C_Agreement))
                                }
                                append(" ")
                                withStyle(style = SpanStyle(Color(148, 110, 197, 255))) {
                                    append(stringResource(id = R.string.Phonepe_T_an_C))
                                }
                            },
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }

        BlueTopAppBar(Heading = "UPI Lite")
    }
}


@Preview
@Composable
fun PreviewUPILiteScreen() {
    PhonepeCloneTheme {
        UPILiteScreen()
    }
}

