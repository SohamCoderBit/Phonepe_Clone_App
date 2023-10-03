package com.example.phonepeclone.ui.Screens.WealthScreens

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.phonepeclone.BlueTopAppBar
import com.example.phonepeclone.HeadingTextInSurfaceView
import com.example.phonepeclone.R
import com.example.phonepeclone.ViewModels.AllFundsViewModel
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme
import kotlinx.coroutines.launch

sealed class ExploreAllFundsBottomSheetScreens {
    object Category : ExploreAllFundsBottomSheetScreens()
    object Filter : ExploreAllFundsBottomSheetScreens()
    object Returns : ExploreAllFundsBottomSheetScreens()
}


data class CategoryElements(
    val CategoryName: String,
    var isSelected: Boolean = false
)


@Composable
fun checkBoxes() {

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CategoryBottomSheetScreen(
    sheetState: ModalBottomSheetState,
    allFundsViewModel: AllFundsViewModel = viewModel()
) {

    var currentContext = LocalContext.current
    var categoryMap = allFundsViewModel.getAllTheCategoryList(currentContext)


    val categoryList = listOf("Equity", "Debt", "Hybrid", "Other Funds")

    var currentlySelectedCategroy by rememberSaveable {
        mutableStateOf(categoryList[0])
    }



    var scope = rememberCoroutineScope()

    val checkBoxColors = CheckboxDefaults.colors(
        checkedColor = Color.Green,
        uncheckedColor = Color.White,
        checkmarkColor = colorResource(id = R.color.scrollable_view)
    )

    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.fillMaxHeight(0.07f)) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.4f),
                contentAlignment = Alignment.Center
            ) {
                HeadingTextInSurfaceView(
                    HeadingText = "Category",
                    TextFontSize = 30,
                    HeadingTextFontWeight = FontWeight.Bold,
                    SurfacePadding = PaddingValues(0.dp)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.5f)
            ) {
                //CLEAR ALL Button
            }

        }

        Divider(color = colorResource(id = R.color.divider_color))

        Row(modifier = Modifier.fillMaxHeight(0.92f)) {
            Box(
                modifier = Modifier
                    .weight(0.35f)
                    .fillMaxHeight()
                    .background(colorResource(id = R.color.layout_color_light_grey))
            ) {
                LazyColumn(modifier = Modifier.padding(top = 10.dp), userScrollEnabled = false) {
                    itemsIndexed(categoryList) { index, _ ->

                        val boxColor = if (currentlySelectedCategroy == categoryList[index]) {
                            colorResource(id = R.color.scrollable_view)
                        } else {
                            Color.Transparent
                        }

                        Box(
                            modifier = Modifier
                                .padding(start = 15.dp)
                                .fillMaxWidth()
                                .height(50.dp)
                                .clickable(
                                    indication = null,
                                    interactionSource = MutableInteractionSource()
                                ) {
                                    currentlySelectedCategroy = categoryList[index]
                                }
                                .background(boxColor),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            HeadingTextInSurfaceView(
                                HeadingText = categoryList[index],
                                SurfacePadding = PaddingValues(start = 10.dp),
                                HeadingTextFontWeight = FontWeight.Normal
                            )
                        }

                    }
                }
            }

            Box(
                modifier = Modifier
                    .weight(0.5f)
                    .fillMaxHeight()
                    .background(colorResource(id = R.color.scrollable_view))
            ) {
                Column(modifier = Modifier.padding(top = 15.dp)) {

                    categoryMap[currentlySelectedCategroy]?.forEach {item ->

                        Row(
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .fillMaxWidth()
                                .height(40.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxHeight(),
                                contentAlignment = Alignment.CenterStart
                            ) {
                                HeadingTextInSurfaceView(
                                    HeadingText = item.CategoryName,
                                    SurfacePadding = PaddingValues(start = 10.dp),
                                    TextFontSize = 15
                                )

                            }

                            Box(
                                modifier = Modifier
                                    .weight(0.2f)
                                    .fillMaxHeight(),
                                contentAlignment = Alignment.Center
                            ) {
                                Checkbox(
                                    checked = item.isSelected,
                                    onCheckedChange = {
                                        item.isSelected = it
                                        println(item)
                                    },
                                    colors = checkBoxColors
                                )
                            }
                        }
                    }
                }
            }
        }

        Divider(color = colorResource(id = R.color.divider_color))

        Row(modifier = Modifier.fillMaxHeight()) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.5f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier.clickable(
                        indication = null,
                        interactionSource = MutableInteractionSource()
                    ) {
                        scope.launch {
                            sheetState.hide()
                        }
                    },
                    text = "CANCEL",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.icon_tint)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.5f)
            ) {
                //CLEAR ALL Button
            }

        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExploreAllFundsScreen() {

    var currentBottomSheetScreen: ExploreAllFundsBottomSheetScreens? by remember {
        mutableStateOf(null)
    }

    val sheetState =
        rememberModalBottomSheetState(ModalBottomSheetValue.Expanded, skipHalfExpanded = true)

    var corutineScope = rememberCoroutineScope()

    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetBackgroundColor = Color(33, 24, 43, 255),
        //Sheet Content
        sheetContent = {
            CategoryBottomSheetScreen(sheetState)
        }
    ) {

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Button(onClick = {
                corutineScope.launch {
                    sheetState.show()
                }
            }) {
                Text("Show Bottom Sheet", color = Color.White)
            }
        }

        BlueTopAppBar(Heading = "All Funds")
    }

}

@Preview
@Composable
fun PreviewExploreAllFund() {
    PhonepeCloneTheme {
        ExploreAllFundsScreen()
    }
}

