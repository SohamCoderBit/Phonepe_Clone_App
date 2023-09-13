package com.example.phonepeclone.ui.Screens.HomeUnitScreens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.phonepeclone.R
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme

@Composable
fun PhonepeWalletScreen() {


    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = colorResource(id = R.color.background)
    ) {
        BlueTopAppBar(Heading = "Phonepe Wallet")

        Column(modifier = Modifier.padding(top = 70.dp)) {
            Box(
                modifier = Modifier
                    .padding(top = 200.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {

                Column(
                    modifier = Modifier.fillMaxWidth(0.80f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        modifier = Modifier.size(150.dp),
                        painter = painterResource(id = R.drawable.wallet),
                        contentDescription = null,
                        tint = Color(144, 93, 198, 255)
                    )
                    Text(
                        modifier = Modifier.padding(top = 40.dp),
                        text = "Balance :",
                        color = Color.White
                    )
                    Text(text = "₹0" , color = Color.White , fontWeight = FontWeight.Medium , fontSize = 40.sp)
                }

            }

        }

        BottomAppBarAsButton(Content = {
            Text(
                text = "ACTIVATE WALLET",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 15.sp
            )
        })
    }


}

@Preview
@Composable
fun PreviewPhonepeWalletScreen() {
    PhonepeCloneTheme {
        PhonepeWalletScreen()
    }
}

