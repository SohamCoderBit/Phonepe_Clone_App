package com.example.phonepeclone

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.phonepeclone.ViewModels.TopCompaniesViewModel
import com.example.phonepeclone.ui.Screens.HomeUnitScreens.PhonepeWalletScreen
import com.example.phonepeclone.ui.Screens.HomeUnitScreens.Profile
import com.example.phonepeclone.ui.Screens.HomeUnitScreens.RechargePayBillScreen
import com.example.phonepeclone.ui.Screens.HomeUnitScreens.ReferAndGetButtonScreen
import com.example.phonepeclone.ui.Screens.HomeUnitScreens.RewardScreen
import com.example.phonepeclone.ui.Screens.HomeUnitScreens.UPILiteScreen
import com.example.phonepeclone.ui.Screens.InsuranceScreens.SuperTopUpScreen
import com.example.phonepeclone.ui.Screens.InsuranceScreens.TermLifeScreen
import com.example.phonepeclone.ui.Screens.InsuranceScreens.TravelScreen
import com.example.phonepeclone.ui.Screens.RechargeAndBillScreens.ApartmentScreen
import com.example.phonepeclone.ui.Screens.RechargeAndBillScreens.CableTVScreen
import com.example.phonepeclone.ui.Screens.RechargeAndBillScreens.EducationFeesScreen
import com.example.phonepeclone.ui.Screens.RechargeAndBillScreens.PhonepeGiftCardScreen
import com.example.phonepeclone.ui.Screens.RechargeAndBillScreens.PipedGasScreen
import com.example.phonepeclone.ui.Screens.RechargeAndBillScreens.WaterScreen
import com.example.phonepeclone.ui.Screens.WealthScreens.ExploreAllFundsScreen
import com.example.phonepeclone.ui.Screens.WealthScreens.GoldScreen
import com.example.phonepeclone.ui.Screens.WealthScreens.HighReturnsScreen
import com.example.phonepeclone.ui.Screens.WealthScreens.IndexFundsScreen
import com.example.phonepeclone.ui.Screens.WealthScreens.LargeCapFundsScreen
import com.example.phonepeclone.ui.Screens.WealthScreens.MidCapFundsScreen
import com.example.phonepeclone.ui.Screens.WealthScreens.SmallCapFundsScreen
import com.example.phonepeclone.ui.Screens.WealthScreens.StartWithScreen
import com.example.phonepeclone.ui.Screens.WealthScreens.TaxSavingFundScreen
import com.example.phonepeclone.ui.Screens.WealthScreens.TopCompaniesScreen
import com.example.phonepeclone.ui.Units.HistoryUnit
import com.example.phonepeclone.ui.theme.Screens.InsuranceScreens.AccidentScreen
import com.example.phonepeclone.ui.theme.Screens.InsuranceScreens.BikeScreen
import com.example.phonepeclone.ui.theme.Screens.InsuranceScreens.CarScreen
import com.example.phonepeclone.ui.theme.Screens.InsuranceScreens.HealthScreen
import com.example.phonepeclone.ui.theme.Screens.RechargeAndBillScreens.CreditCardBillPayment
import com.example.phonepeclone.ui.theme.Screens.RechargeAndBillScreens.DTHScreen
import com.example.phonepeclone.ui.theme.Screens.RechargeAndBillScreens.ElectricityScreen
import com.example.phonepeclone.ui.theme.Screens.RechargeAndBillScreens.GasCylinderScreen
import com.example.phonepeclone.ui.theme.Screens.RechargeAndBillScreens.LoanPaymentScreen
import com.example.phonepeclone.ui.theme.Screens.RechargeAndBillScreens.MobileRechargeScreen
import com.example.phonepeclone.ui.theme.Screens.RechargeAndBillScreens.RentPaymentScreen
import com.example.phonepeclone.ui.theme.Screens.TransferMoneyScreens.AddBankAccount
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

    fun getNavigationController(): NavHostController? {
        return navigationController
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
fun NavGraph(
    navController: NavHostController,
    StartDestination: String = Home.ROUTE
) {

    NavHost(
        navController = navController,
        startDestination = StartDestination,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    )
    {
        HomeGraph()
        InsuranceGraph()
        WealthGraph(navController)
        StoreGraph()
        HistoryGraph()
    }

}

fun NavGraphBuilder.HomeGraph() {


    navigation(
        startDestination = Home.SCREEN,
        route = Home.ROUTE,
        enterTransition = { fadeIn() },
        exitTransition = { fadeOut() }
    ) {
        composable(route = Home.SCREEN) { HomeScreenUnit() }
        composable(route = Home.MOBILE_NUMBER_SCREEN) { MobileNumberScreen() }
        composable(route = Home.BANK_SCREEN) { BankScreen() }
        composable(route = Home.CHECK_BALANCE_SCREEN) { CheckBalanceScreen() }
        composable(route = Home.UPI_LITE_SCREEN) { UPILiteScreen() }
        composable(route = Home.SELF_ACCOUNT_SCREEN) { SelfAccountScreen() }
        composable(route = Home.RECHARGE_PAY_BILL_SCREEN) { RechargePayBillScreen() }
        composable(route = Home.ADD_BANK_SCREEN) { AddBankAccount(addBankAccountViewModel = viewModel()) }

        composable(route = Home.MOBILE_RECHARGE_SCREEN) { MobileRechargeScreen() }
        composable(route = Home.DTH_SCREEN) { DTHScreen() }
        composable(route = Home.ELECTRICITY_SCREEN) { ElectricityScreen() }
        composable(route = Home.CREDIT_CARD_BILL_PAYMENT_SCREEN) { CreditCardBillPayment() }
        composable(route = Home.RENT_PAYMENT_SCREEN) { RentPaymentScreen() }
        composable(route = Home.LOAN_PAYMENT_SCREEN) { LoanPaymentScreen(loanPaymentViewModel = viewModel()) }
        composable(route = Home.BOOK_A_CYLINDER_SCREEN) { GasCylinderScreen() }
        composable(route = Home.CABLE_TV_SCREEN) { CableTVScreen(cableTvViewModel = viewModel()) }
        composable(route = Home.PIPED_GAS_SCREEN) { PipedGasScreen(pipedgasViewModel = viewModel()) }
        composable(route = Home.WATER_SCREEN) { WaterScreen(waterViewModel = viewModel()) }
        composable(route = Home.EDUCATION_FEES_SCREEN) { EducationFeesScreen() }
        composable(route = Home.APARTMENTS_SCREEN) { ApartmentScreen() }
        composable(route = Home.GIFT_CARD_SCREEN) { PhonepeGiftCardScreen() }

        composable(route = Home.PHONEPE_WALLET_SCREEN) { PhonepeWalletScreen() }
        composable(route = Home.REWARD_SCREEN) { RewardScreen() }
        composable(route = Home.REFER_AND_GET_SCREEN) { ReferAndGetButtonScreen() }

        composable(
            route = Home.PROFILE_SCREEN,
            enterTransition = {
                fadeIn(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutLinearInEasing
                    )
                ) + scaleIn(
                    animationSpec = tween(
                        durationMillis = 200,
                        easing = FastOutLinearInEasing
                    ), initialScale = 0.5f
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(
                        durationMillis = 100,
                        easing = FastOutLinearInEasing
                    )
                ) + scaleOut(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutLinearInEasing
                    ), targetScale = 0.5f
                )
            }) { Profile() }

    }

}

fun NavGraphBuilder.InsuranceGraph() {
    navigation(
        startDestination = Insurance.SCREEN,
        route = Insurance.ROUTE,
        enterTransition = { fadeIn() },
        exitTransition = { fadeOut() }
    ) {
        composable(route = Insurance.SCREEN) { InsuranceUnit() }
        composable(route = Insurance.HEALTH_SCREEN) { HealthScreen() }
        composable(route = Insurance.CAR_SCREEN) { CarScreen() }
        composable(route = Insurance.BIKE_SCREEN) { BikeScreen() }
        composable(route = Insurance.TRAVEL_SCREEN) { TravelScreen() }
        composable(route = Insurance.SUPER_TOP_UP_SCREEN) { SuperTopUpScreen() }
        composable(route = Insurance.TERM_LIFE_SCREEN) { TermLifeScreen() }
        composable(route = Insurance.ACCIDENT_SCREEN) { AccidentScreen() }
    }
}

fun NavGraphBuilder.WealthGraph(navController: NavController) {
    navigation(
        startDestination = Wealth.SCREEN,
        route = Wealth.ROUTE,
        enterTransition = { fadeIn() },
        exitTransition = { fadeOut() }
    ) {

        composable(route = Wealth.SCREEN) { WealthUnit() }
        composable(route = Wealth.GOLD_SCREEN) { GoldScreen() }
        composable(route = Wealth.TOP_COMPANIES_SCREEN) {
            val topCompaniesViewModel =
                it.topCompaniesViewModel<TopCompaniesViewModel>(navController = navController)
            TopCompaniesScreen(topCompaniesViewModel)
        }
        composable(route = Wealth.HIGH_RETURN_FUND_SCREEN) {
            val topCompaniesViewModel =
                it.topCompaniesViewModel<TopCompaniesViewModel>(navController = navController)
            HighReturnsScreen(topCompaniesViewModel)
        }
        composable(route = Wealth.START_WITH_100_SCREEN) {
            val topCompaniesViewModel =
                it.topCompaniesViewModel<TopCompaniesViewModel>(navController = navController)
            StartWithScreen(topCompaniesViewModel)
        }
        composable(route = Wealth.TAX_SAVING_FUND_SCREEN) {
            TaxSavingFundScreen(taxSavingFundViewModel = viewModel())
        }
        composable(route = Wealth.LARGE_CAP_FUND_SCREEN) {
            val topCompaniesViewModel =
                it.topCompaniesViewModel<TopCompaniesViewModel>(navController = navController)
            LargeCapFundsScreen(topCompaniesViewModel)
        }
        composable(route = Wealth.MID_CAP_FUND_SCREEN) {
            val topCompaniesViewModel =
                it.topCompaniesViewModel<TopCompaniesViewModel>(navController = navController)
            MidCapFundsScreen(topCompaniesViewModel)
        }
        composable(route = Wealth.SMALL_CAP_SCREEN) {
            val topCompaniesViewModel =
                it.topCompaniesViewModel<TopCompaniesViewModel>(navController = navController)
            SmallCapFundsScreen(topCompaniesViewModel)
        }
        composable(route = Wealth.INDEX_FUND_SCREEN) {
            val topCompaniesViewModel =
                it.topCompaniesViewModel<TopCompaniesViewModel>(navController = navController)
            IndexFundsScreen(topCompaniesViewModel)
        }
        composable(route = Wealth.EXPLORE_ALL_FUNDS) {
            ExploreAllFundsScreen()
        }
    }

}

fun NavGraphBuilder.StoreGraph() {
    navigation(
        startDestination = Store.SCREEN,
        route = Store.ROUTE,
        enterTransition = { fadeIn() },
        exitTransition = { fadeOut() }
    ) {
        composable(route = Store.SCREEN) { StoreUnit() }
    }
}

fun NavGraphBuilder.HistoryGraph() {
    navigation(
        startDestination = History.SCREEN,
        route = History.ROUTE,
        enterTransition = { fadeIn() },
        exitTransition = { fadeOut() }
    ) {
        composable(route = History.SCREEN) { HistoryUnit() }
    }
}


@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.topCompaniesViewModel(navController: NavController): T {
    val navGraphRoute = destination.parent?.route ?: return viewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return viewModel(parentEntry)
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

    const val RECHARGE_PAY_BILL_SCREEN = "RechargePayBillScreen"
    const val MOBILE_RECHARGE_SCREEN = "MoblieRechargeScreen"
    const val DTH_SCREEN = "DTHScreen"
    const val ELECTRICITY_SCREEN = "ElectricityScreen"
    const val CREDIT_CARD_BILL_PAYMENT_SCREEN = "CreditCardBillScreen"
    const val RENT_PAYMENT_SCREEN = "RentPaymentScreen"
    const val LOAN_PAYMENT_SCREEN = "LoanPaymentScreen"
    const val BOOK_A_CYLINDER_SCREEN = "BookACylinderScreen"
    const val CABLE_TV_SCREEN = "CableTVScreen"
    const val PIPED_GAS_SCREEN = "PipedGasScreen"
    const val WATER_SCREEN = "WaterScreen"
    const val EDUCATION_FEES_SCREEN = "EducatinFees"
    const val APARTMENTS_SCREEN = "ApartmentsScreen"
    const val GIFT_CARD_SCREEN = "PhonepeGiftCardScreen"

    const val PHONEPE_WALLET_SCREEN = "PhonepWallet"
    const val REWARD_SCREEN = "RewardScreen"
    const val REFER_AND_GET_SCREEN = "ReferAndGetScreen"

    const val PROFILE_SCREEN = "ProfileScreen"
}

object Insurance {
    const val ROUTE = "Insurance"
    const val SCREEN = "InsuranceScreen"
    const val BIKE_SCREEN = "BikeScreen"
    const val CAR_SCREEN = "CarScreen"
    const val TRAVEL_SCREEN = "TravelScreen"
    const val HEALTH_SCREEN = "HealthScreen"
    const val SUPER_TOP_UP_SCREEN = "SuperTopUpScreen"
    const val TERM_LIFE_SCREEN = "TermLifeScreen"
    const val ACCIDENT_SCREEN = "AccidentScreen"
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
    const val EXPLORE_ALL_FUNDS = "ExploreAllFunds"
}

object History {
    const val ROUTE = "History"
    const val SCREEN = "HistoryScreen"
}

object Store {
    const val ROUTE = "Store"
    const val SCREEN = "StoreScreen"
}
