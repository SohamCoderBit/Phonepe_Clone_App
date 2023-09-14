package com.example.phonepeclone.ui.theme.Screens.InsuranceScreens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.LocalTextStyle
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.phonepeclone.BlueTopAppBar
import com.example.phonepeclone.R
import com.example.phonepeclone.SurfaceInView
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun textFieldCarAndBikeScreen():String
{

    var textfromuser by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp)
            .height(65.dp)
            .fillMaxWidth(),
        value = textfromuser,
        onValueChange = {
            if (it != " ") {
                textfromuser = it.take(10).uppercase()
            }
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            containerColor = Color(33, 24, 43, 255),
            focusedIndicatorColor = Color(163, 99, 235, 255),
            cursorColor = Color(163, 99, 235, 255)
        ),
        placeholder = {
            Text(
                text = "Eg:KA01BD2525",
                fontSize = 25.sp,
                lineHeight = 20.sp
            )
        },
        maxLines = 1,
        textStyle = LocalTextStyle.current.copy(fontSize = 25.sp),
        shape = RoundedCornerShape(15),
        singleLine = true

    )

    return textfromuser
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarScreen() {

    var enteredCarNumber by remember {
        mutableStateOf("")
    }
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = colorResource(id = R.color.background)
    ) {
        Column(modifier = Modifier.padding(top = 70.dp)) {
            SurfaceInView(Height = 270) {

                Column {
                    Surface(
                        modifier = Modifier.padding(start = 20.dp, top = 20.dp),
                        color = Color.Transparent
                    ) {
                        Column {
                            Text(
                                text = "Enter Your private car number",
                                color = Color.White,
                                fontSize = 18.sp
                            )
                        }

                    }


                    Box(
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .height(80.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        enteredCarNumber = textFieldCarAndBikeScreen()
                    }


                    //Submit Button
                    Box(
                        modifier = Modifier
                            .height(70.dp)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Button(
                            modifier = Modifier
                                .padding(start = 20.dp, end = 20.dp)
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
                                text = "SUBMIT",
                                textAlign = TextAlign.Center,
                                lineHeight = 18.sp,
                                color = Color.White,
                            )
                        }
                    }

                    Box(
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            modifier = Modifier.padding(top = 5.dp),
                            text = "Don't remember your car number?",
                            color = Color(134, 94, 181, 255),
                            fontSize = 11.sp
                        )
                    }

                }
            }
        }


        BlueTopAppBar(Heading = "Car Insurance")
    }
}


@Preview
@Composable
fun PreviewCar() {
    PhonepeCloneTheme {
        CarScreen()
    }
}