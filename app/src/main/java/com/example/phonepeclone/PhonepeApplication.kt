package com.example.phonepeclone

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Observer
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.phonepeclone.Data.BottomnavItem
import com.example.phonepeclone.ViewModels.MainScreenViewModel
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme


val routeMap = mapOf(
    Home.SCREEN to Home.ROUTE,
    Insurance.SCREEN to Insurance.ROUTE,
    Store.SCREEN to Store.ROUTE,
    Wealth.SCREEN to Wealth.ROUTE,
    History.SCREEN to History.ROUTE

)
val BottomAppbarRouteList = listOf(
    Home.ROUTE,
    Insurance.ROUTE,
    Store.ROUTE,
    Wealth.ROUTE,
    History.ROUTE
)

var showAppBar = false

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PhonepeApplication(mainScreenViewModel: MainScreenViewModel) {


    val appBarObserver = Observer<Boolean> {
        showAppBar = it
    }
    mainScreenViewModel.ShowAppbar.observeForever(appBarObserver)

    val internalNavController = rememberNavController()
    mainNavController.setNavigationController(internalNavController)


    val bottomNavItemList = mainScreenViewModel.getBottomAppBarItemList()

    val navBackStackEntry by internalNavController.currentBackStackEntryAsState()
    val currentRoute = routeMap[navBackStackEntry?.destination?.route]
    val showAppbars = BottomAppbarRouteList.any { it == currentRoute }

    mainScreenViewModel.ShowAppbar.value = showAppbars

    Scaffold(
        topBar = {
            MainTopAppBar(mainScreenViewModel.ShowAppbar.value!!)
        },
        bottomBar = {
            if (currentRoute != null) {
                MainBottomAppBar(
                    internalNavController,
                    bottomNavItemList,
                    mainScreenViewModel.ShowAppbar.value!!,
                    currentRoute
                )
            }
        },
        containerColor = colorResource(id = R.color.background)
    ) {
        NavGraph(internalNavController)
    }

}


@Composable
fun MainTopAppBar(showTopAppbar: Boolean) {


    AnimatedVisibility(
        visible = showTopAppbar,
        enter = fadeIn(),
        exit = fadeOut()
    )
    {
        Box {
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


}


@Composable
fun MainBottomAppBar(
    navController: NavHostController,
    bottomNavItemList: List<BottomnavItem>,
    showBottomAppbar: Boolean,
    currentRoute: String
) {

    AnimatedVisibility(
        visible = showBottomAppbar,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        Box {
            BottomAppBar(
                modifier = Modifier
                    .height(70.dp),
                containerColor = colorResource(id = R.color.bottom_nav)
            ) {

                bottomNavItemList.forEach { menuitem ->
                    val isSelected = currentRoute == menuitem.route
                    val iconColor = if (isSelected) Color.Black else Color(162, 142, 180, 255)
                    val iconBoxColor =
                        if (isSelected) Color.White else Color(63, 37, 98, 255)
                    val textColor = if (isSelected) Color.White else Color(155, 127, 185, 255)
                    BottomNavigationItem(
                        modifier = Modifier
                            .padding(start = 2.dp, end = 2.dp)
                            .width(20.dp),
                        selected = isSelected,
                        onClick = {
                            navController.navigate(route = menuitem.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }

                        },
                        icon = {

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

                            Text(
                                text = menuitem.label,
                                color = textColor,
                                softWrap = false,
                                fontSize = 11.sp,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Medium
                            )
                        },
                    )
                }

            }
        }
    }

}


@Preview
@Composable
fun PreviewPhonepeScreen() {
    PhonepeCloneTheme {
        PhonepeApplication(mainScreenViewModel = viewModel())
    }
}

