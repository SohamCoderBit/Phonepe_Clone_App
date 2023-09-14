package com.example.phonepeclone

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.phonepeclone.Data.BottomnavItem
import com.example.phonepeclone.ViewModels.MainScreenViewModel
import com.example.phonepeclone.ui.theme.Units.HomeScreenUnit
import com.example.phonepeclone.ui.theme.Units.InsuranceUnit
import com.example.phonepeclone.ui.theme.Units.StoreUnit
import com.example.phonepeclone.ui.theme.Units.WealthUnit


object UnitSection
{
    const val HOME = 0
    const val STORE = 1
    const val INSURANCE = 2
    const val WEALTH = 3
    const val HISTORY = 4
}

fun selectItem(SelectedItem: BottomnavItem, ItemList: List<BottomnavItem>) {
    ItemList.forEach { item ->
        item.isSelected.value = item.label == SelectedItem.label
    }
}


@Composable
fun PhonepeApplication(mainScreenViewModel: MainScreenViewModel) {

    val bottomNavItemList = mainScreenViewModel.getBottomAppBarItemList()

    fun isUnitSelected(Index: Int): Boolean {
        return bottomNavItemList[Index].isSelected.value
    }

    var shouldExitToHome by rememberSaveable { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .verticalScroll(
                rememberScrollState()
            )
            .padding(top = 70.dp, bottom = 80.dp)
    ) {


        //Home Screen Unit
        if (isUnitSelected(UnitSection.HOME)) {
            if (mainScreenViewModel.isSurfaceVisible.value) {
                SurfaceInView(
                    Height = 300,
                    InternalContent = @Composable {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            Icon(
                                modifier = Modifier
                                    .height(20.dp)
                                    .align(alignment = Alignment.End)
                                    .clickable {
                                        mainScreenViewModel.isSurfaceVisible.value = false
                                    },
                                painter = painterResource(id = R.drawable.xmark_solid),
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    })
            }

            HomeScreenUnit(bottomnavItemList = bottomNavItemList)
            shouldExitToHome = false
        }

        //Store Screen Unit
        if (isUnitSelected(UnitSection.STORE)) {
            shouldExitToHome = true
            StoreUnit()
        }

        //Insurance Screen Unit
        if (isUnitSelected(UnitSection.INSURANCE)) {
            shouldExitToHome = true
            InsuranceUnit()
        }

        //Wealth Screen Unit
        if (isUnitSelected(UnitSection.WEALTH)) {

            shouldExitToHome = true
            WealthUnit()
        }

        //History Screen Unit
        if (isUnitSelected(UnitSection.HISTORY)) {
            shouldExitToHome = true
        }
    }

    /**
     * Back Button in Handler Which Will be triggered when the User
     * is in the different section (And it will Get back to the Home Screen)
     * this function will be enabled when the [shouldExitToHome] id true
     */
    BackHandler(shouldExitToHome) {
        if (!isUnitSelected(UnitSection.HOME)) {
            selectItem(bottomNavItemList[UnitSection.HOME], bottomNavItemList)
            shouldExitToHome = false
        }
    }

    //Bottom Application Bar
    Box {
        BottomAppBar(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .height(70.dp),
            containerColor = colorResource(id = R.color.bottom_nav)
        ) {

            bottomNavItemList.forEach { menuitem ->
                BottomNavigationItem(
                    modifier = Modifier
                        .padding(start = 2.dp, end = 2.dp)
                        .width(20.dp),
                    selected = menuitem.isSelected.value,
                    onClick = {
                        selectItem(menuitem, bottomNavItemList)

                    },
                    icon = {

                        val iconColor = if (menuitem.isSelected.value) Color.Black else Color(
                            162,
                            142,
                            180,
                            255
                        )
                        val iconBoxColor =
                            if (menuitem.isSelected.value) Color.White else Color(63, 37, 98, 255)
                        Box(
                            modifier = Modifier.size(40.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(26.dp)
                                    .clip(RoundedCornerShape(50))
                                    .background(iconBoxColor),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    modifier = Modifier
                                        .height(14.dp),
                                    imageVector = ImageVector.vectorResource(id = menuitem.icon),
                                    contentDescription = menuitem.label,
                                    tint = iconColor
                                )
                            }
                        }
                    },
                    label = {
                        val textColor = if (menuitem.isSelected.value) Color.White else Color(
                            155,
                            127,
                            185,
                            255
                        )
                        Text(
                            modifier = Modifier.width(80.dp),
                            text = menuitem.label,
                            color = textColor,
                            softWrap = false,
                            fontSize = 11.sp,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Medium
                        )
                    },
                    enabled = true
                )
            }
        }
    }

    //Top App Bar
    Box(modifier = Modifier.height(7.dp)) {
        TopAppBar(
            backgroundColor = colorResource(id = R.color.top_nav),
            modifier = Modifier.height(70.dp)
        ) {
            Surface(
                modifier = Modifier
                    .padding(start = 15.dp)
                    .height(45.dp)
                    .width(45.dp),
                shape = RoundedCornerShape(18.dp)
            ) {
                Box(
                    modifier = Modifier.background(Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier = Modifier
                            .height(28.dp)
                            .width(28.dp),
                        painter = painterResource(id = R.drawable.user_icon),
                        contentDescription = null,
                        tint = Color.Black
                    )
                }
            }


            Surface(
                modifier = Modifier
                    .clickable { },
                color = Color.Transparent,
                shape = RoundedCornerShape(20.dp)
            ) {
                Column(
                    modifier = Modifier.padding(
                        start = 15.dp,
                        end = 20.dp,
                        top = 10.dp,
                        bottom = 10.dp
                    )
                ) {
                    Row {
                        Text(
                            text = "Add Address",
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White,
                            fontSize = 18.sp
                        )
                        Icon(
                            modifier = Modifier
                                .size(18.dp)
                                .padding(start = 8.dp, top = 5.dp),
                            painter = painterResource(id = R.drawable.caret_down_solid),
                            contentDescription = null,
                            tint = Color.White
                        )
                    }

                    Text(
                        text = "Ahemdabad",
                        color = Color.White,
                        fontSize = 14.sp,
                    )
                }

            }

            Row(
                modifier = Modifier.padding(start = 50.dp)
            ) {

                //QR Button
                DrawIconInButton(IconID = R.drawable.qrcode_solid)

                //Bell Icon
                DrawIconInButton(IconID = R.drawable.bell_regular)

                //Question Mark
                DrawIconInButton(IconID = R.drawable.circle_question_regular)
            }
        }

        Box(
            modifier = Modifier
                .padding(top = 42.dp, start = 53.dp)
                .clip(RoundedCornerShape(7.dp))
        )
        {
            Icon(
                modifier = Modifier.height(20.dp),
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null,
                tint = Color(0, 179, 60)
            )
        }
    }

}

