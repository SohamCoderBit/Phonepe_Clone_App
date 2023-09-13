package com.example.phonepeclone.ui.theme.Units

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.phonepeclone.R
import com.example.phonepeclone.SurfaceInView
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme


@Composable
fun StoreUnit() {
    SurfaceInView(Height = 300) {
        Text(
            modifier = Modifier.padding(top = 40.dp),
            text = "Store Unit",
            color = Color.White,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
    }

}


@Preview
@Composable
fun PreviewStoreUnit() {
    PhonepeCloneTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = colorResource(id = R.color.background)
        ) {
            Column(
                modifier = Modifier
                    .verticalScroll(
                        rememberScrollState()
                    )
                    .padding(top = 70.dp, bottom = 80.dp)
            ) {
                StoreUnit()
            }

        }
    }
}