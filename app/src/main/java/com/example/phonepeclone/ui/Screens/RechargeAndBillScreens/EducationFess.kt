package com.example.phonepeclone.ui.Screens.RechargeAndBillScreens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.phonepeclone.BlueTopAppBar
import com.example.phonepeclone.HeadingText
import com.example.phonepeclone.R
import com.example.phonepeclone.SurfaceInView
import com.example.phonepeclone.ThreeBoxRow
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme

@Composable
fun EducationFeesScreen()
{

    val iconboxmodifier: Modifier = Modifier
        .size(50.dp)
        .border(0.5.dp, Color(72, 60, 80, 255), RoundedCornerShape(30))

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = colorResource(id = R.color.background)
    ) {

        Column(modifier = Modifier.padding(top = 70.dp)) {
            SurfaceInView {
                Column{
                    HeadingText(HeadingText = "Select to proceed", TextFontSize = 18)

                    ThreeBoxRow(
                        firstBoxContent = {
                            Box(
                                modifier = iconboxmodifier,
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    modifier = Modifier.size(30.dp),
                                    painter = painterResource(id = R.drawable.building_columns_solid),
                                    contentDescription = null,
                                    tint = colorResource(id = R.color.icon_tint)
                                )
                            }
                        },
                        secondBoxContent = {
                            //MySelf Text
                            Text(
                                text = stringResource(id = R.string.education_fees_row_1),
                                color = Color.White,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold
                            )
                        },
                        thirdBoxContent = {
                            Icon(
                                modifier = Modifier.size(20.dp),
                                painter = painterResource(id = R.drawable.chevron_right_solid_2),
                                contentDescription = null,
                                tint = Color.White
                            )
                        },
                        boxWeightList = listOf(0.3f , 0.7f , 0.2f),
                        alignmentList = listOf(
                            Alignment.Center,
                            Alignment.CenterStart,
                            Alignment.Center
                        ),
                        onClick = {

                        }
                    )
                    ThreeBoxRow(
                        firstBoxContent = {
                            Box(
                                modifier = iconboxmodifier,
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    modifier = Modifier.size(30.dp),
                                    painter = painterResource(id = R.drawable.building_columns_solid),
                                    contentDescription = null,
                                    tint = colorResource(id = R.color.icon_tint)
                                )
                            }
                        },
                        secondBoxContent = {
                            //MySelf Text
                            Text(
                                text = stringResource(id = R.string.education_fees_row_2),
                                color = Color.White,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold
                            )
                        },
                        thirdBoxContent = {
                            Icon(
                                modifier = Modifier.size(20.dp),
                                painter = painterResource(id = R.drawable.chevron_right_solid_2),
                                contentDescription = null,
                                tint = Color.White
                            )
                        },
                        boxWeightList = listOf(0.3f , 0.7f , 0.2f),
                        alignmentList = listOf(
                            Alignment.Center,
                            Alignment.CenterStart,
                            Alignment.Center
                        ),
                        onClick = {

                        }
                    )
                }
            }
        }
        BlueTopAppBar(Heading = "Education Fees")
    }
}


@Preview
@Composable
fun PreviewEducationFeeScreen()
{
    PhonepeCloneTheme {
        EducationFeesScreen()
    }
}

