package com.example.phonepeclone

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.expandHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.phonepeclone.ui.Screens.HomeUnitScreens.UPILiteScreen
import com.example.phonepeclone.ui.Screens.InsuranceScreens.TravelScreen
import com.example.phonepeclone.ui.Units.HistoryUnit
import com.example.phonepeclone.ui.theme.Screens.InsuranceScreens.BikeScreen
import com.example.phonepeclone.ui.theme.Screens.InsuranceScreens.CarScreen
import com.example.phonepeclone.ui.theme.Screens.InsuranceScreens.HealthScreen
import com.example.phonepeclone.ui.theme.Screens.TransferMoneyScreens.BankScreen
import com.example.phonepeclone.ui.theme.Screens.TransferMoneyScreens.CheckBalanceScreen
import com.example.phonepeclone.ui.theme.Screens.TransferMoneyScreens.MobileNumberScreen
import com.example.phonepeclone.ui.theme.Screens.TransferMoneyScreens.SelfAccountScreen
import com.example.phonepeclone.ui.theme.Units.HomeScreenUnit
import com.example.phonepeclone.ui.theme.Units.InsuranceUnit
import com.example.phonepeclone.ui.theme.Units.StoreUnit
import com.example.phonepeclone.ui.theme.Units.WealthUnit


/**
 * Basic Implementation of [NavigationController] class. this class's object is referenced in all the files now
 * becasue we only need one NavController
 */

class NavigationController {

    private var navigationController: NavHostController? = null

    fun setNavigationController(controller: NavHostController) {
        navigationController = controller
    }

    /**
     * if Node in Graph will not exist the app will crash.
     * EveryTime we Navigate to Route Destination And After goBack
     * to Previous Composable Whole Compsable function Recomposes
     */
    fun navigateTo(Route: String) {
        navigationController?.navigate(Route)
    }

    fun goBack() {
        navigationController?.navigateUp()
    }

}


@Composable
fun BottomNavGraph(
    navController: NavHostController? = rememberNavController(),
    StartDestination: String = BottomNav.HOME
) {

    if (navController != null) {
        NavHost(
            navController = navController,
            startDestination = StartDestination,
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None }) {
            composable(route = BottomNav.HOME) {
                HomeScreenUnit()
            }

            composable(route = BottomNav.INSURANCE) {
                InsuranceUnit()
            }

            composable(route = BottomNav.WEALTH) {
                WealthUnit()
            }

            composable(route = BottomNav.HISTORY) {
                HistoryUnit()
            }

            composable(route = BottomNav.STORE) {
                StoreUnit()
            }
        }

    }
}

@Composable
fun MainNavGraph(
    navController: NavHostController? = rememberNavController(),
    StartDestination: String = Home.ROUTE
) {
    if (navController != null) {
        NavHost(
            navController = navController,
            startDestination = StartDestination,
            enterTransition = { expandHorizontally { 20 } },
            exitTransition = { ExitTransition.None }
        )
        {
            HomeGraph()
            InsuranceGraph()
        }
    }
}

fun NavGraphBuilder.HomeGraph() {
    navigation(startDestination = "NullScreen", route = Home.ROUTE)
    {
        composable(route = "NullScreen") {}
        composable(route = Home.MOBILE_NUMBER_SCREEN,) { MobileNumberScreen() }
        composable(route = Home.BANK_SCREEN) { BankScreen() }
        composable(route = Home.CHECK_BALANCE_SCREEN,) { CheckBalanceScreen() }
        composable(route = Home.UPI_LITE_SCREEN) { UPILiteScreen() }
        composable(route = Home.SELF_ACCOUNT_SCREEN) { SelfAccountScreen() }
    }

}

fun NavGraphBuilder.InsuranceGraph() {
    navigation(startDestination = Insurance.SCREEN, route = Insurance.ROUTE)
    {
        composable(route = Insurance.SCREEN) {}
        composable(route = Insurance.HEALTH_SCREEN) { HealthScreen() }
        composable(route = Insurance.CAR_SCREEN) { CarScreen() }
        composable(route = Insurance.BIKE_SCREEN) { BikeScreen() }
        composable(route = Insurance.TRAVEL_SCREEN) { TravelScreen() }
    }
}


object BottomNav {
    const val HOME = "Home"
    const val INSURANCE = "Insurance"
    const val STORE = "Store"
    const val WEALTH = "Wealth"
    const val HISTORY = "History"

}


object Home {
    const val ROUTE = "Home"
    const val SCREEN = "HomeScreen"
    const val MOBILE_NUMBER_SCREEN = "MobileNumberScreen"
    const val ADD_BANK_SCREEN = "AddBankAccount"
    const val SELF_ACCOUNT_SCREEN = "SelfAccountScreen"
    const val BANK_SCREEN = "BankScreen"
    const val CHECK_BALANCE_SCREEN = "CheckBalanceScreen"
    const val UPI_LITE_SCREEN = "UPILite"
}

object Insurance {
    const val ROUTE = "Insurance"
    const val SCREEN = "InsuranceScreen"
    const val BIKE_SCREEN = "BikeScreen"
    const val CAR_SCREEN = "CarScreen"
    const val TRAVEL_SCREEN = "TravelScreen"
    const val HEALTH_SCREEN = "HealthScreen"
}

object Wealth {
    const val ROUTE = "Wealth"
    const val SCREEN = "WealthScreen"
    const val TAX_SAVING_FUND_SCREEN = "TaxSavingFundScreen"
    const val HIGH_RETURN_FUND_SCREEN = "HighReturnsScreen"
    const val TOP_COMPANIES_SCREEN = "TopCompaniesScreen"
    const val BEST_SIP_FUNDS_SCREEN = "BestSIPFundsScreen"
    const val TRENDING_THEME_SCREEN = "TrendingThemesScreen"
    const val START_WITH_100_SCREEN = "StartWithScreen"
    const val THREE_IN_ONE_SCREEN = "ThreeInOneScreen"
    const val LARGE_CAP_FUND_SCREEN = "LargeCapFundsScreen"
    const val MID_CAP_FUND_SCREEN = "MidCapFundsScreen"
    const val SMALL_CAP_SCREEN = "SmallCapFundsScreen"
    const val INDEX_FUND_SCREEN = "IndexFundsScreen"
    const val GOLD_SCREEN = "GoldScreen"
}

object History {
    const val ROUTE = "History"
    const val SCREEN = "HistoryScreen"
}

object Store {
    const val ROUTE = "Store"
    const val SCREEN = "StoreScreen"
}
