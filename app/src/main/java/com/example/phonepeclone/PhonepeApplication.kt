package com.example.phonepeclone

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
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



@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PhonepeApplication(mainScreenViewModel: MainScreenViewModel) {

    val internalNavController = rememberNavController()
    mainNavController.setNavigationController(internalNavController)


    val bottomNavItemList = mainScreenViewModel.getBottomAppBarItemList()

    val navBackStackEntry by internalNavController.currentBackStackEntryAsState()
    val currentRoute = routeMap[navBackStackEntry?.destination?.route]
    val showAppbars = BottomAppbarRouteList.any { it == currentRoute }

    mainScreenViewModel.ShowAppbar.value = showAppbars

    Scaffold(
        topBar = {
            MainTopAppBar(mainScreenViewModel.ShowAppbar.value)
        },
        bottomBar = {
            if (currentRoute != null) {
                MainBottomAppBar(
                    internalNavController,
                    bottomNavItemList,
                    mainScreenViewModel.ShowAppbar.value,
                    currentRoute
                )
            }
        },
        containerColor = colorResource(id = R.color.background)
    ) {
        NavGraph(internalNavController)
    }

}








@Preview
@Composable
fun PreviewPhonepeScreen() {
    PhonepeCloneTheme {
        PhonepeApplication(mainScreenViewModel = viewModel())
    }
}

