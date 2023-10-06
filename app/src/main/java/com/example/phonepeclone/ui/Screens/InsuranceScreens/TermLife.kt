package com.example.phonepeclone.ui.Screens.InsuranceScreens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.phonepeclone.BlueTopAppBar
import com.example.phonepeclone.BottomAppBarAsButton
import com.example.phonepeclone.ClickableSurface
import com.example.phonepeclone.HeadingText
import com.example.phonepeclone.R
import com.example.phonepeclone.SurfaceInView
import com.example.phonepeclone.animatedLabelTextField
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme


data class Genders(val Gender: String)
data class ButtonConfigs(
    val surfaceColor: Color,
    val surfaceBorderColor: Color,
    val labelColor: Color
)

@Composable
fun TermLifeScreen() {

    val GendersList = arrayListOf<Genders>()

    val purpleColor: Color = colorResource(id = R.color.button_purple)
    val greenColor: Color = colorResource(id = R.color.button_green)

    var currentlySelectedOptionGender by remember { mutableStateOf("") }
    GendersList.add(Genders(Gender = "Male"))
    GendersList.add(Genders(Gender = "Female"))
    GendersList.add(Genders(Gender = "Others"))

    var currentlySelectedChoice by remember { mutableStateOf("") }
    val ChoiceList = arrayListOf<String>()
    ChoiceList.add("Yes")
    ChoiceList.add("No")


    val ButtonColorChange: (Boolean) -> ButtonConfigs = { isSelected: Boolean ->
        val surfaceColor =
            if (isSelected) greenColor else Color.Transparent

        val surfaceBorderColor =
            if (isSelected) greenColor else purpleColor

        val labelColor =
            if (isSelected) Color.White else purpleColor

        ButtonConfigs(
            surfaceColor = surfaceColor,
            surfaceBorderColor = surfaceBorderColor,
            labelColor = labelColor
        )
    }

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = colorResource(id = R.color.background)
    ) {

        Column(modifier = Modifier.padding(top = 70.dp)) {
            SurfaceInView(Height = 450) {
                Column {
                    HeadingText(HeadingText = "Personal Details")


                    var dob_Date by remember {
                        mutableStateOf("")
                    }

                    var pin_Code by remember {
                        mutableStateOf("")
                    }


                    //Text Field Of Date Of Birth
                    dob_Date = animatedLabelTextField(
                        BoxPadding = PaddingValues(top = 40.dp, start = 20.dp, end = 20.dp),
                        Label = "Date of birth",
                        PlaceHolder = "DD/MM/YYYY"
                    )

                    //Text Field Of PIN Code Number
                    pin_Code = animatedLabelTextField(
                        BoxPadding = PaddingValues(
                            start = 20.dp,
                            end = 20.dp,
                            top = 40.dp,
                            bottom = 20.dp
                        ),
                        Label = "PIN Code (as per Govt ID)",
                        PlaceHolder = ""
                    )

                    HeadingText(HeadingText = "Gender")

                    Row(modifier = Modifier.padding(start = 20.dp, top = 10.dp)) {
                        GendersList.forEach { gender ->
                            val isCurrentlySelected =
                                currentlySelectedOptionGender == gender.Gender
                            val buttonColor = ButtonColorChange(isCurrentlySelected)

                            ClickableSurface(
                                Label = gender.Gender,
                                SurfaceHeight = 35,
                                SurfaceWidth = 80,
                                SurfaceColor = buttonColor.surfaceColor,
                                SurfaceBorderColor = buttonColor.surfaceBorderColor,
                                LabelColor = buttonColor.labelColor
                            ) {
                                currentlySelectedOptionGender = gender.Gender
                            }
                        }
                    }


                    HeadingText(
                        HeadingText = "Smoked / consumed tobacco in last 12 months ?",
                        SurfacePadding = PaddingValues(start = 20.dp, top = 20.dp)
                    )

                    Row(modifier = Modifier.padding(start = 20.dp, top = 10.dp)) {
                        ChoiceList.forEach { choiceItem ->

                            val isCurrentlySelected = currentlySelectedChoice == choiceItem
                            val buttonColor = ButtonColorChange(isCurrentlySelected)

                            ClickableSurface(
                                Label = choiceItem,
                                SurfaceHeight = 35,
                                SurfaceWidth = 80,
                                SurfaceColor = buttonColor.surfaceColor,
                                SurfaceBorderColor = buttonColor.surfaceBorderColor,
                                LabelColor = buttonColor.labelColor
                            ) {
                                currentlySelectedChoice = choiceItem
                            }
                        }
                    }
                }
            }
        }

        BlueTopAppBar(Heading = "Get Started")

        BottomAppBarAsButton(Content = {
            Text(text = "CONTINUE", color = Color.White, fontWeight = FontWeight.Medium , fontSize = 20.sp)
        })

    }

}

@Preview
@Composable
fun PreviewTermLifeScreen() {
    PhonepeCloneTheme {
        TermLifeScreen()
    }
}
