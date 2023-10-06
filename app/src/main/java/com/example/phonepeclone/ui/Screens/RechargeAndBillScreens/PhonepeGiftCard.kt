package com.example.phonepeclone.ui.Screens.RechargeAndBillScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.phonepeclone.BlueTopAppBar
import com.example.phonepeclone.BottomAppBarAsButton
import com.example.phonepeclone.HeadingText
import com.example.phonepeclone.R
import com.example.phonepeclone.SurfaceInView
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme


@Composable
fun basicTextField(label: String, isEmpty: (Boolean) -> Unit): String {

    /**
     * By default Focus using Modifier.focusRequester() function ------- yet to be Implemented --------
     */
    val purpleColor = colorResource(id = R.color.button_purple)

    var textFromUser by remember {
        mutableStateOf("")
    }
    var isFocused by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .padding(top = 20.dp, bottom = 20.dp)
            .fillMaxWidth()
    ) {


        val borderColor = if (isFocused) purpleColor else Color(157, 149, 162, 255)
        Text(
            text = label,
            color = Color.White,
            modifier = Modifier
                .offset(y = (-23).dp),
            fontSize = 14.sp
        )
        BasicTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
                .onFocusChanged {
                    isFocused = it.isFocused
                },
            cursorBrush = SolidColor(purpleColor),
            value = textFromUser,
            onValueChange = { newText: String ->
                textFromUser = newText
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            maxLines = 1,
            textStyle = TextStyle(fontSize = 18.sp, color = Color.White)
        )

        Spacer(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(if (isFocused) 2.dp else 1.dp)
                .background(borderColor)
        )
    }

    isEmpty(textFromUser.isEmpty())

    return textFromUser
}

@Composable
fun ShowDialogBox(
    showDialog: (Boolean) -> Unit
) {

    var giftCardNumber by remember {
        mutableStateOf("")
    }

    var pinNumber by remember {
        mutableStateOf("")
    }

    var isGiftCaradTextEmpty by remember {
        mutableStateOf(true)
    }

    var isPinCardTextEmpty by remember {
        mutableStateOf(true)
    }
    Dialog(onDismissRequest = { showDialog(false) }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(5.dp),
            backgroundColor = colorResource(id = R.color.scrollable_view),
            elevation = 0.dp
        ) {


            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp)
                        .fillMaxWidth()
                ) {

                    HeadingText(
                        HeadingText = "Claim Gift Card",
                        SurfacePadding = PaddingValues(top = 20.dp, bottom = 20.dp),
                        TextFontSize = 20,
                        HeadingTextFontWeight = FontWeight(500)
                    )



                    giftCardNumber = basicTextField(label = "Gift Card Number", isEmpty = {
                        isGiftCaradTextEmpty = it
                    })

                    pinNumber = basicTextField(label = "PIN", isEmpty = {
                        isPinCardTextEmpty = it
                    })
                }

                Divider(
                    color = colorResource(id = R.color.divider_color)
                )


                var isClickable by remember {
                    mutableStateOf(false)
                }

                isClickable = !(isPinCardTextEmpty || isGiftCaradTextEmpty)
                val textColor = if (isClickable) {
                    colorResource(id = R.color.icon_tint)
                } else {
                    colorResource(id = R.color.divider_color)
                }
                Row(modifier = Modifier.height(45.dp)) {
                    val boxmodifier = Modifier
                        .weight(0.5f)
                        .fillMaxHeight()
                    Box(
                        modifier = boxmodifier.clickable(
                            indication = null,
                            interactionSource = MutableInteractionSource()
                        ) { showDialog(false) },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "CANCEL", color = colorResource(id = R.color.icon_tint))

                    }

                    Divider(
                        modifier = Modifier
                            .width(1.dp)
                            .fillMaxHeight(),
                        color = colorResource(id = R.color.divider_color)
                    )

                    Box(
                        modifier = boxmodifier.clickable(
                            indication = null,
                            interactionSource = MutableInteractionSource()
                        ) {
                            if (isClickable) {
                                /**
                                 * Yet to be Discovered
                                 */
                            } else {

                            }
                        }, contentAlignment = Alignment.Center
                    ) {
                        Text(text = "CONFIRM", color = textColor)
                    }
                }
            }


        }
    }
}

@Composable
fun PhonepeGiftCardScreen() {

    var showDialog by remember {
        mutableStateOf(false)
    }

    val boxModifier: Modifier = Modifier
        .padding(top = 20.dp)
        .fillMaxWidth()
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = colorResource(id = R.color.background)
    ) {

        Column(modifier = Modifier.padding(top = 70.dp)) {
            SurfaceInView {
                Column(
                    modifier = Modifier
                        .padding(top = 30.dp, start = 50.dp, end = 50.dp)
                ) {
                    Box(modifier = boxModifier, contentAlignment = Alignment.Center) {
                        Icon(
                            modifier = Modifier.size(100.dp),
                            painter = painterResource(id = R.drawable.gift_card),
                            contentDescription = null,
                            tint = colorResource(
                                id = R.color.icon_tint
                            )
                        )
                    }

                    Box(modifier = boxModifier, contentAlignment = Alignment.Center) {
                        Text(
                            text = stringResource(id = R.string.gift_card),
                            color = Color.White,
                            fontSize = 19.sp,
                            fontWeight = FontWeight.Normal
                        )
                    }

                    Box(modifier = boxModifier, contentAlignment = Alignment.Center) {
                        Text(
                            text = "₹0",
                            color = Color.White,
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }

                    Box(modifier = Modifier.padding(top = 10.dp).fillMaxWidth(), contentAlignment = Alignment.Center) {
                        Text(
                            text = "Updated :  05 Oct 2023",
                            color = Color.LightGray,
                            fontSize = 13.sp
                        )
                    }

                    Box(modifier = Modifier.padding(top = 5.dp).fillMaxWidth(), contentAlignment = Alignment.Center) {
                        Text(
                            text = "Resume Balance",
                            color = colorResource(id = R.color.icon_tint),
                            fontSize = 13.sp
                        )
                    }

                    Box(modifier = boxModifier, contentAlignment = Alignment.Center) {
                        Divider(
                            color = colorResource(id = R.color.divider_color)
                        )
                    }


                    Row(
                        modifier = Modifier
                            .height(90.dp)
                            .fillMaxWidth()
                            .clickable(
                                indication = null,
                                interactionSource = MutableInteractionSource()
                            ) {
                                showDialog = true
                            }
                    ) {
                        Box(
                            modifier = Modifier.fillMaxHeight(),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                modifier = Modifier.size(30.dp),
                                painter = painterResource(id = R.drawable.plus_circle),
                                contentDescription = null,
                                tint = Color.White
                            )
                        }

                        Box(
                            modifier = Modifier.fillMaxHeight(),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(modifier = Modifier.padding(start = 10.dp, end = 10.dp)) {
                                Text(
                                    text = "Claim Gift Card",
                                    color = Color.White,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Medium
                                )
                                Text(
                                    text = "Use Card ID & PIN",
                                    color = Color.LightGray,
                                    fontSize = 12.sp
                                )
                            }
                        }

                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Claim Now",
                                color = colorResource(id = R.color.TMS_Icon)
                            )

                        }
                    }
                }
            }
        }

        BottomAppBarAsButton(Content = {
            Text(
                text = "BUY NEW CARD",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 15.sp
            )
        })
        BlueTopAppBar(Heading = "Phonepe Gift Card")
    }

    if (showDialog) {
        ShowDialogBox(showDialog = { showDialog = it })
    }
}


@Preview
@Composable
fun PreviewGiftCardScreen() {
    PhonepeCloneTheme {
        PhonepeGiftCardScreen()
    }
}
