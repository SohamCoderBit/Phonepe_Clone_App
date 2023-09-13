package com.example.phonepeclone.ui.theme.Screens.RechargeAndBillScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.phonepeclone.HeadingTextInSurfaceView
import com.example.phonepeclone.R
import com.example.phonepeclone.RowWithDividerElements
import com.example.phonepeclone.SelectionButton
import com.example.phonepeclone.SurfaceInView
import com.example.phonepeclone.ViewModels.LoanPaymentViewModel
import com.example.phonepeclone.topAppBarWithSearchBar
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme
import kotlinx.coroutines.launch


data class CategoryItem(val Content: String, var isSelected: MutableState<Boolean>)




@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LoanPaymentScreen(loanPaymentViewModel: LoanPaymentViewModel) {

    val categoryItemList = arrayListOf<CategoryItem>()

    categoryItemList.add(
        CategoryItem(
            Content = "Microfianance Institutions (MFI)",
            isSelected = rememberSaveable { mutableStateOf(false) }
        )
    )
    categoryItemList.add(
        CategoryItem(
            Content = "Vehicle Loan",
            isSelected = rememberSaveable { mutableStateOf(false) }
        )
    )
    categoryItemList.add(
        CategoryItem(
            Content = "Gold Loan",
            isSelected = rememberSaveable { mutableStateOf(false) }
        )
    )
    categoryItemList.add(
        CategoryItem(
            Content = "Small Finance Bank",
            isSelected = rememberSaveable { mutableStateOf(false) }
        )
    )
    categoryItemList.add(
        CategoryItem(
            Content = "Consumer Loan",
            isSelected = rememberSaveable { mutableStateOf(false) }
        )
    )
    categoryItemList.add(
        CategoryItem(
            Content = "Bank",
            isSelected = rememberSaveable { mutableStateOf(false) }
        )
    )
    categoryItemList.add(
        CategoryItem(
            Content = "Home Loan",
            isSelected = rememberSaveable { mutableStateOf(false) }
        )
    )
    categoryItemList.add(
        CategoryItem(
            Content = "Others",
            isSelected = rememberSaveable { mutableStateOf(false) }
        )
    )


    fun listCheck(): Int {
        categoryItemList.forEachIndexed { index, _ ->
            if (categoryItemList[index].isSelected.value) return index
        }
        return -1
    }


    var searchtextfromuser by remember {
        mutableStateOf("")
    }

    val sheetState = rememberBottomSheetState(
        initialValue = BottomSheetValue.Collapsed
    )

    val bottomsheetState = rememberBottomSheetScaffoldState(
        bottomSheetState = sheetState
    )

    val coroutineScope = rememberCoroutineScope()

    BottomSheetScaffold(
        scaffoldState = bottomsheetState,
        sheetShape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp),
        sheetBackgroundColor = Color(33, 24, 43, 255),
        sheetPeekHeight = 0.dp,
        drawerBackgroundColor = Color.Blue,
        content = {
            Surface(
                color = colorResource(id = R.color.background),
                modifier = Modifier
                    .fillMaxHeight()
                    .clickable(indication = null, interactionSource = MutableInteractionSource()) {
                        coroutineScope.launch {
                            bottomsheetState.bottomSheetState.collapse()
                        }
                    }
            ) {


                val index: Int = listCheck()
                val buttonLabel: String =
                    if (index == -1) "Filter by category" else categoryItemList[index].Content
                val surfaceLabel: String =
                    if (index == -1) "All Loan Billers" else categoryItemList[index].Content
                val buttonBorderColor: Color =
                    if (index == -1) Color(49, 40, 61, 255) else Color(76, 132, 103, 255)
                val buttonBackgroundColor: Color =
                    if (index == -1) Color.Transparent else Color(40, 51, 48, 255)

                Column(
                    modifier = Modifier
                        .padding(top = 70.dp)
                        .fillMaxHeight()
                        .verticalScroll(rememberScrollState())

                ) {


                    SurfaceInView(Height = 150) {

                    }

                    SurfaceInView(Height = 80) {
                        Row {
                            Box(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .fillMaxWidth(0.75f),
                                contentAlignment = Alignment.CenterStart
                            ) {

                                SelectionButton(
                                    ButtonPadding = PaddingValues(start = 20.dp),
                                    ButtonContentPadding = PaddingValues(
                                        start = 10.dp,
                                        end = 15.dp,
                                        top = 2.dp,
                                        bottom = 2.dp
                                    ),
                                    ButtonHeight = 28,
                                    ButtonBackGroundColor = buttonBackgroundColor,
                                    ButtonBorderColor = buttonBorderColor,
                                    ButtonLabel = buttonLabel,
                                    IconSize = 12,
                                    IconResource = R.drawable.caret_down_solid,
                                    IconPadding = PaddingValues(start = 5.dp),
                                    OnClick = {
                                        coroutineScope.launch {
                                            if (sheetState.isCollapsed) {
                                                bottomsheetState.bottomSheetState.expand()
                                            } else {
                                                bottomsheetState.bottomSheetState.collapse()
                                            }
                                        }
                                    }
                                )


                            }
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {

                                if (index != -1) {
                                    Text(
                                        modifier = Modifier.clickable(
                                            indication = null,
                                            interactionSource = MutableInteractionSource()
                                        ) {
                                            categoryItemList.forEach { item ->
                                                item.isSelected.value = false
                                            }
                                        },
                                        text = "CLEAR",
                                        color = Color(140, 108, 181, 255)
                                    )
                                }
                            }
                        }
                    }


                    //Have to use the Custom Surface Because of the Vertical Scroll Isuue

                    Surface(
                        color = colorResource(id = R.color.scrollable_view),
                        modifier = Modifier
                            .padding(top = 10.dp, start = 10.dp, end = 10.dp)
                            .fillMaxHeight()
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(15.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(start = 5.dp)
                                .fillMaxHeight()
                        ) {

                            HeadingTextInSurfaceView(
                                HeadingText = surfaceLabel,
                                SurfacePadding = PaddingValues(
                                    start = 20.dp,
                                    top = 10.dp,
                                    bottom = 15.dp
                                )
                            )

                            val iconboxmodifier: Modifier = Modifier
                                .size(45.dp)
                                .clip(RoundedCornerShape(percent = 20))
                                .background(Color.White)

                            loanPaymentViewModel.getParsedJson(LocalContext.current).forEach { item ->
                                if (item.BillerType.Index == index) {
                                    RowWithDividerElements(
                                        Content = item.BillerName,
                                        IconSource = R.drawable.user_regular,
                                        IconBoxModifier = iconboxmodifier
                                    )
                                } else {
                                    if (index == -1) {
                                        RowWithDividerElements(
                                            Content = item.BillerName,
                                            IconSource = R.drawable.user_regular,
                                            IconBoxModifier = iconboxmodifier
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        },

        sheetContent = {
            //Heading In Bottom Sheet
            Row(
                modifier = Modifier
                    .padding(top = 20.dp, start = 20.dp, bottom = 30.dp)
                    .height(35.dp)
            ) {

                Text(
                    modifier = Modifier.weight(1.5f),
                    text = "Filter by category",
                    color = Color.White,
                    fontSize = 25.sp
                )

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(), contentAlignment = Alignment.CenterEnd
                ) {
                    Icon(
                        modifier = Modifier
                            .padding(end = 20.dp)
                            .size(20.dp)
                            .clickable(
                                indication = null,
                                interactionSource = MutableInteractionSource()
                            ) {
                                coroutineScope.launch {
                                    bottomsheetState.bottomSheetState.collapse()
                                }
                            },
                        painter = painterResource(id = R.drawable.close_button),
                        contentDescription = null,
                        tint = Color.White
                    )
                }


            }


            Column {
                categoryItemList.forEach { categoryItem ->
                    Row(
                        modifier = Modifier.height(35.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .width(307.dp),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Text(
                                modifier = Modifier.padding(start = 20.dp),
                                text = categoryItem.Content,
                                color = Color.White,
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center
                            )
                        }


                        val iconResource: Int =
                            if (categoryItem.isSelected.value) R.drawable.true_sign else R.drawable.radio_button

                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .width(63.dp),
                            contentAlignment = Alignment.CenterEnd
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(24.dp)
                                    .clickable(
                                        indication = null,
                                        interactionSource = MutableInteractionSource()
                                    ) {
                                        categoryItemList.forEach { item ->
                                            item.isSelected.value =
                                                item.Content == categoryItem.Content
                                        }

                                        coroutineScope.launch {
                                            bottomsheetState.bottomSheetState.collapse()
                                        }
                                    },
                                painter = painterResource(id = iconResource),
                                contentDescription = null,
                                tint = Color.Unspecified
                            )
                        }


                    }

                    Divider(
                        modifier = Modifier.padding(
                            start = 20.dp,
                            end = 20.dp,
                            top = 15.dp,
                            bottom = 15.dp
                        ),
                        color = Color(46, 37, 56, 255),
                        thickness = 2.dp
                    )
                }
            }


        }
    )


    //Top App Bar
    searchtextfromuser = topAppBarWithSearchBar("Search by lender")
}


@Preview
@Composable
fun PreviewLoan() {
    PhonepeCloneTheme {
        LoanPaymentScreen(loanPaymentViewModel = viewModel())
    }
}


