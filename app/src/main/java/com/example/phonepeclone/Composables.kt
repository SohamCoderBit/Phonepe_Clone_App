package com.example.phonepeclone

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.phonepeclone.Data.FundBillers
import com.example.phonepeclone.ui.Screens.WealthScreens.FundsFacilityBoxs



@Composable
fun ClickableSurface(
    Label: String,
    LabelColor:Color = Color(148, 110, 197, 255),
    RoundedCornerPercentage: Int = 20,
    SurfaceColor: Color = Color.Transparent,
    SurfaceBorderColor:Color = Color(148, 110, 197, 255),
    SurfaceWidth:Int = 90,
    SurfaceHeight:Int = 45,
    onClick: () -> Unit
) {

    Surface(
        modifier = Modifier
            .padding(end = 10.dp)
            .width(SurfaceWidth.dp)
            .height(SurfaceHeight.dp)
            .clickable(
                indication = null,
                interactionSource = MutableInteractionSource()
            ) {
                onClick()
            },
        color = SurfaceColor,
        shape = RoundedCornerShape(RoundedCornerPercentage),
        border = BorderStroke(1.dp, SurfaceBorderColor)
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            androidx.compose.material.Text(
                text = Label,
                color = LabelColor,
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium
            )
        }

    }
}


@Composable
fun FundsSurface(
    FundProvider: FundBillers,
    SurfaceOnClick: () -> Unit = {},
    MoreDetailesOnClick: () -> Unit = {}
) {
    Surface(
        modifier = Modifier
            .padding(top = 10.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth()
            .height(190.dp)
            .clickable { SurfaceOnClick() },
        shape = RoundedCornerShape(10),
        color = Color(33, 24, 43, 255)
    ) {

        Column {

            Row {

                Box(
                    modifier = Modifier
                        .weight(1.2f)
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

                Box(
                    modifier = Modifier
                        .weight(3f)
                        .height(80.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Column {
                        androidx.compose.material.Text(
                            text = FundProvider.FundProviderName,
                            color = Color.White,
                            fontSize = 16.sp
                        )
                        androidx.compose.material.Text(
                            text = "Equity : Large Cap",
                            color = Color.White
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .weight(0.8f)
                        .height(80.dp),
                    contentAlignment = Alignment.Center
                ) {
                    androidx.compose.material3.Icon(
                        modifier = Modifier
                            .height(15.dp),
                        painter = painterResource(id = R.drawable.chevron_right_solid),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }

            androidx.compose.material.Divider(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                thickness = 2.dp,
                color = Color(46, 37, 56, 255)
            )

            Row {
                Box(
                    modifier = Modifier
                        .weight(0.9f)
                        .height(70.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Column(modifier = Modifier.padding(start = 20.dp)) {
                        androidx.compose.material.Text(
                            text = "Last 3Y",
                            fontSize = 13.sp,
                            color = Color.White
                        )
                        Row(modifier = Modifier.padding(top = 2.dp)) {
                            androidx.compose.material.Text(
                                text = FundProvider.Last3Year + "%",
                                fontSize = 17.sp,
                                color = Color.White
                            )
                            androidx.compose.material.Text(
                                modifier = Modifier.padding(top = 8.dp),
                                text = " p.a",
                                fontSize = 10.sp,
                                color = Color.White
                            )
                        }
                    }
                }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(70.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column {
                        androidx.compose.material.Text(text = "Min Invest.", color = Color.White)
                        androidx.compose.material.Text(
                            text = FundProvider.MinInvest,
                            fontSize = 17.sp,
                            color = Color.White
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .weight(1.3f)
                        .height(70.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Column(modifier = Modifier.padding(start = 25.dp)) {
                        androidx.compose.material.Text(text = "Fund Size", color = Color.White)
                        androidx.compose.material.Text(
                            text = "₹" + FundProvider.FundSize + "Cr",
                            fontSize = 17.sp,
                            color = Color.White
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp)
                    .fillMaxWidth()

            ) {
                androidx.compose.material.Text(
                    modifier = Modifier.clickable(
                        indication = null,
                        interactionSource = MutableInteractionSource()
                    ) {
                        MoreDetailesOnClick()
                    },
                    text = "More Details",
                    color = Color(146, 111, 198, 255),
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Composable
fun FundsScreenLayout(
    TopBarHeading: String,
    Heading: String,
    SemiHeading: String,
    ParaGraphStringID: Int,
    SmallBoxsRow: List<String>,
    Content: @Composable () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = colorResource(id = R.color.background)
    ) {

        Column(
            modifier = Modifier
                .padding(top = 70.dp)
                .verticalScroll(rememberScrollState())
        ) {

            Box(
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .background(colorResource(id = R.color.scrollable_view))
            ) {


                Box(modifier = Modifier.align(alignment = Alignment.TopStart)) {
                    Row {
                        Box(
                            modifier = Modifier
                                .weight(2.5f)
                                .fillMaxHeight()
                        ) {
                            Column {
                                Text(
                                    modifier = Modifier.padding(
                                        start = 15.dp,
                                        top = 10.dp,
                                        bottom = 10.dp
                                    ),
                                    text = Heading,
                                    color = Color.White,
                                    fontWeight = FontWeight.Medium
                                )

                                Text(
                                    modifier = Modifier.padding(start = 15.dp, bottom = 5.dp),
                                    text = SemiHeading,
                                    fontSize = 20.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.SemiBold
                                )
                                Text(
                                    modifier = Modifier.padding(start = 15.dp),
                                    text = stringResource(id = ParaGraphStringID),
                                    color = Color.White,
                                    lineHeight = 18.sp
                                )
                            }
                        }
                        Box(modifier = Modifier.weight(1f)) {

                        }
                    }
                }

                Box(modifier = Modifier.align(alignment = Alignment.BottomStart)) {
                    Row(
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .horizontalScroll(rememberScrollState())
                    ) {
                        SmallBoxsRow.forEachIndexed { index, _ ->
                            val startPadding = if (index == 0) 10 else 2
                            val endPadding = if (index == SmallBoxsRow.size - 1) 10 else 2
                            FundsFacilityBoxs(
                                Label = SmallBoxsRow[index],
                                StartPadding = startPadding,
                                EndPadding = endPadding
                            )
                        }
                    }
                }
            }

            Content()
        }

        BlueTopAppBar(Heading = TopBarHeading)
    }
}


@Composable
fun animatedLabelTextField(
    BoxPadding: PaddingValues,
    BoxHeight: Int = 36,
    Label: String,
    PlaceHolder: String
): String {
    var textFromUser by remember {
        mutableStateOf("")
    }

    val purpleColor: Color = colorResource(id = R.color.button_purple)
    var isFocused by remember { mutableStateOf(false) }
    val labelOffset by animateDpAsState(targetValue = if (isFocused || !textFromUser.isEmpty()) 23.dp else 0.dp)
    val fontSize by animateFloatAsState(targetValue = if (isFocused || !textFromUser.isEmpty()) 13f else 20f)
    val BorderColor = if (isFocused) purpleColor else Color(157, 149, 162, 255)

    Box(
        modifier = Modifier
            .padding(BoxPadding)
            .height(BoxHeight.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = Label,
            color = if (isFocused) purpleColor else Color(159, 144, 174, 255),
            modifier = Modifier
                .offset(y = -labelOffset)
                .clickable { isFocused = true },
            fontSize = fontSize.sp
        )

        if (isFocused && textFromUser.isEmpty()) {
            Text(
                text = PlaceHolder,
                color = Color(159, 144, 174, 255),
                modifier = Modifier,
                fontSize = 20.sp
            )
        }

        BasicTextField(
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged { isFocused = it.isFocused },
            value = textFromUser,
            onValueChange = { newText: String ->
                textFromUser = newText
            },
            maxLines = 1,
            keyboardActions = KeyboardActions(onDone = {
                isFocused = false
            }),
            cursorBrush = SolidColor(purpleColor),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.NumberPassword
            ),
            textStyle = TextStyle(fontSize = 20.sp, color = Color.White)
        )

        Spacer(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(if (isFocused) 2.dp else 1.dp)
                .background(BorderColor)
        )
    }
    return textFromUser
}


/**
 * Button with Full Width Size in SurfaceInView Function And
 * It uses the modifier.fillMaxWidth() function
 */
@Composable
fun FullPurpleButton(
    ButtonPadding: PaddingValues,
    ButtonLabel: String,
    ButtonLabelFontSize: Int,
    ButtonHeight: Int,
    ButtonColor: Color,
    ContentPadding: PaddingValues,
    OnClick: () -> Unit
) {
    Button(
        modifier = Modifier
            .padding(ButtonPadding)
            .fillMaxWidth()
            .height(ButtonHeight.dp),
        onClick = { OnClick() },
        shape = RoundedCornerShape(50),
        contentPadding = ContentPadding,
        colors = ButtonDefaults.outlinedButtonColors(ButtonColor)
    ) {
        Text(
            text = ButtonLabel,
            textAlign = TextAlign.Center,
            fontSize = ButtonLabelFontSize.sp,
            color = Color.White,
        )
    }
}


@Composable
fun SelectionButton(
    ButtonModifier: Modifier = Modifier,
    ButtonPadding: PaddingValues,
    ButtonContentPadding: PaddingValues,
    ButtonHeight: Int,
    ButtonBackGroundColor: Color,
    ButtonBorderColor: Color,
    ButtonLabel: String,
    IconSize: Int,
    IconResource: Int,
    IconPadding: PaddingValues,
    OnClick: () -> Unit,
    LeadingContent: @Composable () -> Unit = {},
    EndingContent: @Composable () -> Unit = {}
) {
    Button(
        modifier = ButtonModifier
            .padding(ButtonPadding)
            .height(ButtonHeight.dp),
        onClick = { OnClick() },
        shape = CircleShape,
        contentPadding = ButtonContentPadding,
        colors = ButtonDefaults.outlinedButtonColors(ButtonBackGroundColor),
        border = BorderStroke(1.dp, ButtonBorderColor),
        interactionSource = MutableInteractionSource()
    ) {

        LeadingContent()

        Text(
            text = ButtonLabel,
            fontSize = 12.sp,
            letterSpacing = 1.sp,
            color = Color.White
        )
        Icon(
            modifier = Modifier
                .padding(IconPadding)
                .size(IconSize.dp),
            painter = painterResource(id = IconResource),
            contentDescription = null,
            tint = Color.White
        )

        EndingContent()
    }
}


/**
 * Returns The Text typed by the user In Texfield
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun textfield(
    placeHolder: String,
    placeHolderColor: Color = Color(0xAACCCCCC),
    checkError : (String) -> Boolean
): String {

    var textfromuser by remember {
        mutableStateOf("")
    }

    var isError by remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp, top = 10.dp, bottom = 10.dp)
            .height(65.dp)
            .fillMaxWidth(),
        value = textfromuser,
        onValueChange = {
            textfromuser = it
            isError = checkError(it)
            if(it == "") isError = true

        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            containerColor = Color.Transparent,
            cursorColor = Color(163, 99, 235, 255)
        ),
        placeholder = {
            Text(
                text = placeHolder,
                fontSize = 25.sp,
                lineHeight = 20.sp,
                color = placeHolderColor
            )
        },
        maxLines = 1,
        textStyle = LocalTextStyle.current.copy(fontSize = 25.sp),
        shape = RoundedCornerShape(15),
        singleLine = true,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.NumberPassword
            ),
        isError = isError
    )

    return textfromuser
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(PlaceHolder: String): String {
    var SearchTextFromUser by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        modifier = Modifier
            .padding(start = 10.dp, top = 10.dp, end = 10.dp)
            .height(55.dp)
            .fillMaxWidth(),
        value = SearchTextFromUser,
        onValueChange = { SearchTextFromUser = it },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.White,
            containerColor = Color(33, 24, 43, 255),
        ),
        placeholder = {
            Text(
                modifier = Modifier.padding(start = 10.dp),
                text = PlaceHolder,
                fontSize = 18.sp,
                lineHeight = 20.sp
            )
        },
        maxLines = 1,
        textStyle = LocalTextStyle.current.copy(fontSize = 15.sp),
        shape = RoundedCornerShape(50),
        singleLine = true,
        leadingIcon = {
            Icon(
                modifier = Modifier
                    .size(30.dp)
                    .padding(start = 10.dp),
                painter = painterResource(id = R.drawable.loupe),
                contentDescription = null,
                tint = Color.White
            )
        }
    )

    return SearchTextFromUser
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun topAppBarWithSearchBar(PlaceHolder: String): String {

    var searchtextfromuser by remember {
        mutableStateOf("")
    }
    Box {
        TopAppBar(
            backgroundColor = colorResource(id = R.color.top_nav),
            modifier = Modifier.height(70.dp)
        ) {
            TextField(
                modifier = Modifier
                    .padding(start = 5.dp, top = 5.dp, end = 5.dp, bottom = 5.dp)
                    .height(55.dp)
                    .fillMaxWidth(),
                value = searchtextfromuser,
                onValueChange = { searchtextfromuser = it },
                placeholder = {
                    Text(
                        modifier = Modifier.padding(start = 10.dp),
                        text = PlaceHolder,
                        fontSize = 18.sp,
                        lineHeight = 20.sp,
                        color = Color.LightGray
                    )
                },
                maxLines = 1,
                textStyle = LocalTextStyle.current.copy(fontSize = 20.sp, color = Color.White),
                singleLine = true,
                leadingIcon = {
                    androidx.compose.material3.Icon(
                        modifier = Modifier
                            .size(30.dp)
                            .padding(start = 10.dp)
                            .clickable(
                                indication = null,
                                interactionSource = MutableInteractionSource()
                            )
                            {
                                navController.goBack()
                            },
                        painter = painterResource(id = R.drawable.back_button),
                        contentDescription = null,
                        tint = Color.White
                    )
                },
                shape = RoundedCornerShape(10),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color(33, 24, 43, 255),
                    focusedIndicatorColor = Color.Unspecified,
                    unfocusedIndicatorColor = Color.Unspecified
                )
            )
        }
    }

    return searchtextfromuser
}

@Composable
fun ButtonsInView(modifier: Modifier, Start: Int, End: Int, IconID: Int, OnClick: () -> Unit = {}) {


    Button(
        modifier = modifier
            .padding(start = Start.dp, end = End.dp, top = 10.dp),
        onClick = { OnClick() },
        shape = RoundedCornerShape(15.dp),
        colors = ButtonDefaults.outlinedButtonColors(colorResource(id = R.color.scrollable_view_button))
    ) {

        Icon(
            modifier = Modifier
                .height(45.dp)
                .padding(bottom = 15.dp),
            painter = painterResource(IconID),
            contentDescription = null,
            tint = Color.White

        )

    }
}

@Composable
fun SurfaceInView(
    Height: Int = 90,
    modifier: Modifier = Modifier,
    surfaceColor: Color = colorResource(id = R.color.scrollable_view),
    InternalContent: @Composable () -> Unit,
) {
    Surface(
        color = surfaceColor,
        modifier = modifier
            .height(Height.dp)
            .fillMaxWidth()
            .padding(top = 10.dp, start = 10.dp, end = 10.dp),
        shape = RoundedCornerShape(15.dp)
    ) {
        InternalContent()
    }
}


@Composable
fun DrawIconInRow(
    SurfaceModifier: Modifier,
    BoxModifier: Modifier = Modifier,
    IconBoxColor: Color = Color.Unspecified,
    IconBoxModifier: Modifier = Modifier,
    IconSize: Int,
    IconTint: Color = colorResource(id = R.color.icon_tint),
    IconResource: Int
) {


    //Surface->Box->Box->Icon
    Surface(
        modifier = SurfaceModifier
            .padding(start = 20.dp, end = 20.dp),
        color = Color.Transparent
    )
    {

        Box(
            modifier = BoxModifier,
            contentAlignment = Alignment.Center
        ) {


            /*TODO*/
//            Keep This Box And Use it for Button Click Animation
//            Box(
//                modifier = Modifier.size(50.dp)
//                    .clip(CircleShape)
//            )
//            {
//
//            }
            Box(
                modifier = IconBoxModifier.background(IconBoxColor),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier
                        .height(IconSize.dp)
                        .width(IconSize.dp),
                    painter = painterResource(IconResource),
                    contentDescription = null,
                    tint = IconTint
                )
            }
        }
    }
}


/**
 * To Write the label beneath Icons in Sections in Home Screen.
 * Use parameter [label] to Write
 */
@Composable
fun WriteLabelInRow(modifier: Modifier, label: String) {
    Surface(
        modifier = modifier, color = Color.Transparent
    ) {
        Box(
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = label,
                color = Color.White,
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                lineHeight = 15.sp
            )
        }
    }
}


@Composable
fun SeeAllButton(modifier: Modifier, boxmodifier: Modifier) {

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp),
        color = Color.Transparent
    )
    {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = boxmodifier,
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(45.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .background(colorResource(id = R.color.TMS_Icon))
                        .clickable {
                            println("See All Button Clicked")
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier = Modifier
                            .height(20.dp)
                            .width(20.dp),
                        painter = painterResource(R.drawable.chevron_right_solid),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        }
    }
}


/**
 *To Draw Icon in Button (Reward , Phonepe Wallet , Refer & Get ₹100 => This are the buttons On A Screen)
 */
@Composable
fun DrawIconInButton(IconID: Int) {
    Icon(
        modifier = Modifier
            .height(28.dp)
            .padding(start = 5.dp, end = 10.dp),
        painter = painterResource(id = IconID),
        contentDescription = null,
        tint = Color.White
    )
}


/**
 * Bottom App Bar Composable As A Button At the Bottom Of the Screen
 */
@Composable
fun BottomAppBarAsButton(Content: @Composable () -> Unit = {}, OnClick: () -> Unit = {}) {
    Box {
        BottomAppBar(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .height(60.dp)
                .clickable {
                    OnClick()
                },
            containerColor = colorResource(id = R.color.bottom_nav)
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Content()
            }

        }
    }
}


@Composable
fun RowWithDividerElements(
    Content: String,
    IconSource: Int,
    IconBoxModifier: Modifier,
    IconTint: Color = Color.Unspecified,
    OnClick: () -> Unit = { }
) {
    Row(
        modifier = Modifier
            .height(70.dp)
            .clickable { OnClick() }
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            contentAlignment = Alignment.Center
        ) {

            Box(
                modifier = IconBoxModifier,
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier.size(25.dp),
                    painter = painterResource(id = IconSource),
                    contentDescription = null,
                    tint = IconTint
                )
            }

        }
        Box(
            modifier = Modifier
                .weight(4f)
                .fillMaxHeight()
                .height(50.dp),
            contentAlignment = Alignment.CenterStart
        ) {

            Text(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 5.dp),
                text = Content,
                color = Color.White
            )

            Divider(
                modifier = Modifier
                    .padding(end = 30.dp)
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                color = Color(51, 42, 61, 255)
            )

        }
    }

}


@Composable
fun BlueTopAppBar(Heading: String, BackArrowClick: () -> Unit = { navController.goBack() }) {
    Box {
        TopAppBar(
            backgroundColor = colorResource(id = R.color.top_nav),
            modifier = Modifier.height(70.dp)
        ) {
            Icon(
                modifier = Modifier
                    .padding(start = 15.dp, end = 30.dp)
                    .size(20.dp)
                    .clickable(
                        indication = null,
                        interactionSource = MutableInteractionSource()
                    ) {
                        BackArrowClick()
                    },
                painter = painterResource(id = R.drawable.back_button),
                contentDescription = null,
                tint = Color.White
            )
            Text(text = Heading, fontSize = 22.sp, color = Color.White)

        }
    }
}


/**
 * Heading Text Usually inside the function SurfaceInView Function Calls
 */
@Composable
fun HeadingTextInSurfaceView(
    HeadingText: String,
    HeadingTextColor: Color = Color.White,
    TextFontSize: Int = 16,
    HeadingTextFontWeight: FontWeight = FontWeight.Medium,
    SurfacePadding: PaddingValues = PaddingValues(start = 20.dp, top = 10.dp)
) {
    Surface(
        modifier = Modifier.padding(SurfacePadding),
        color = Color.Transparent
    )
    {
        Text(
            text = HeadingText,
            color = HeadingTextColor,
            fontSize = TextFontSize.sp,
            fontWeight = HeadingTextFontWeight
        )
    }
}


@Composable
fun ScrollableBoxs(Label: String, StartPadding: Int = 10, EndPadding: Int = 10) {
    Box(
        modifier = Modifier
            .padding(start = StartPadding.dp, end = EndPadding.dp)
            .clip(RoundedCornerShape(30))
            .background(colorResource(id = R.color.background))
            .border(1.dp, Color(49, 40, 61, 255), RoundedCornerShape(30))
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {

            Icon(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .size(15.dp),
                painter = painterResource(id = R.drawable.four_dots_squared),
                contentDescription = null,
                tint = Color(144, 93, 198, 255)
            )


            Text(
                modifier = Modifier.padding(
                    start = 10.dp,
                    end = 10.dp,
                    top = 5.dp,
                    bottom = 5.dp
                ),
                text = Label,
                color = Color.White,
                fontSize = 12.sp
            )
        }
    }
}


