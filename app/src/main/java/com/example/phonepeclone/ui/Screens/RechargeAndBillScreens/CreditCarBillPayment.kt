package com.example.phonepeclone.ui.theme.Screens.RechargeAndBillScreens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LocalTextStyle
import androidx.compose.material3.BottomAppBar
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.phonepeclone.BlueTopAppBar
import com.example.phonepeclone.HeadingTextInSurfaceView
import com.example.phonepeclone.R
import com.example.phonepeclone.SurfaceInView
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreditCardBillPayment() {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = colorResource(id = R.color.background)
    ) {

        var CreditCardNumber by remember {
            mutableStateOf("")
        }
        Column(modifier = Modifier.padding(top = 70.dp)) {
            SurfaceInView(Height = 150) {
                Column {

                    HeadingTextInSurfaceView(
                        HeadingText = "Enter the credit card number to pay your bill",
                        TextFontSize = 15,
                        HeadingTextFontWeight = FontWeight.Normal
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .padding(start = 20.dp, end = 20.dp, top = 15.dp)
                            .height(65.dp)
                            .fillMaxWidth(),
                        value = CreditCardNumber,
                        onValueChange = { CreditCardNumber = it.take(10).uppercase() },
                        colors = TextFieldDefaults.textFieldColors(
                            textColor = Color.White,
                            containerColor = Color(33, 24, 43, 255),
                            focusedIndicatorColor = Color(163, 99, 235, 255),
                            cursorColor = Color(163, 99, 235, 255)
                        ),
                        maxLines = 1,
                        textStyle = LocalTextStyle.current.copy(fontSize = 25.sp),
                        shape = RoundedCornerShape(15),
                        singleLine = true
                    )
                }
            }
        }

        BlueTopAppBar(Heading = "Bike Insurance")

        Box {
            BottomAppBar(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .height(60.dp)
                    .clickable{

                    },
                containerColor = colorResource(id = R.color.bottom_nav)
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ){
                    Text(text = "CONFIRM", color = Color.White , textAlign = TextAlign.Center)
                }

            }
        }

    }
}

@Preview
@Composable
fun PreviewCreditCard() {
    PhonepeCloneTheme {
        CreditCardBillPayment()
    }
}
