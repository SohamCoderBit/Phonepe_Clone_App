package com.example.phonepeclone.ui.Units

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.phonepeclone.SurfaceInView



@Composable
fun HistoryUnit() {

    Column(
        modifier = Modifier
            .verticalScroll(
                rememberScrollState()
            )
    ){
        SurfaceInView(Height = 300) {
            Text(
                modifier = Modifier.padding(top = 40.dp),
                text = "History Unit",
                color = Color.White,
                fontSize = 30.sp,
                textAlign = TextAlign.Center
            )
        }
    }


}