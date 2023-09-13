package com.example.phonepeclone

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.phonepeclone.ViewModels.LoanPaymentViewModel
import com.example.phonepeclone.ViewModels.MainScreenViewModel
import com.example.phonepeclone.ViewModels.TopCompaniesViewModel
import com.example.phonepeclone.ui.Screens.HomeUnitScreens.PhonepeWalletScreen
import com.example.phonepeclone.ui.Screens.HomeUnitScreens.ReferAndGetButtonScreen
import com.example.phonepeclone.ui.Screens.HomeUnitScreens.RewardScreen
import com.example.phonepeclone.ui.Screens.InsuranceScreens.InsuranceRenewalScreen
import com.example.phonepeclone.ui.Screens.WealthScreens.DynamicScreen
import com.example.phonepeclone.ui.Screens.WealthScreens.GoldScreen
import com.example.phonepeclone.ui.Screens.WealthScreens.TopCompaniesScreen
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


object NavigationDestinations {
    const val HOMESCREEN_ROUTE = "HomeScreen"
    const val MOBILENUMBERSCREEN_ROUTE = "MobileNumberScreen"
    const val BANKSCREEN_ROUTE = "BankScreen"
    const val CHECKBALANCESCREEN_ROUTE = "CheckBalanceScreen"
    const val ELECTRICITYSCREEN_ROUTE = "ElectricityScreen"
    const val RENTPAYMENTSCREEN_ROUTE = "RentPaymentScreen"
    const val LOANPAYMENTSCREEN_ROUTE = "LoanPaymentScreen"
    const val MOBILERECHARGESCREEN_ROUTE = "MobileRechargeScreen"
    const val DTHSCREEN_ROUTE = "DTHScreen"
    const val GASCYLINDERSCREEN_ROUTE = "GasCylinderScreen"
    const val BIKESCREEN_ROUTE = "BikeScreen"
    const val HEALTHSCREEN_ROUTE = "HealthScreen"
    const val CREDITCARDBILLPAYMENTSCREEN_ROUTE = "CreditCardBillPayment"
    const val CARSCREEN_ROUTE = "CarScreen"
    const val ACCIDENTSCREEN_ROUTE = "AccidentScreen"
    const val ADDBANKSCREEN_ROUTE = "AddBankAccount"
    const val SELFACCOUNT_ROUTE = "SelfAccountScreen"
    const val GOLDSCREEN_ROUTE = "GoldScreen"
    const val REFERANDGETBUTTON_ROUTE = "ReferAndGetButtonScreen"
    const val PHONEPEWALLETBUTTON_ROUTE = "PhonepeWalletScreen"
    const val TOPCOMPANIES_ROUTE = "TopCompaniesScreen"
    const val REWARDBUTTON_ROUTE = "RewardScreen"
    const val INSURANCERENEWAL_ROUTE = "InsuranceRenewalScreen"

    //Testing
    const val DYNAMICSCREEN_ROUTE = "DynamicScreen"
}

/**
 * Basic Implementation of [NavigationController] class. this class's object is referenced in all the files now
 * becasue we only need one NavController
 */

class NavigationController {

    private var navigationController: NavController? = null

    fun setNavigationController(controller: NavController) {
        navigationController = controller
    }

    fun getNavigationController(): NavController? {
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
fun NavGraphInit(
    navController: NavHostController = rememberNavController(),
    StartDestination: String = NavigationDestinations.HOMESCREEN_ROUTE
) {

    val mainScreenViewModel: MainScreenViewModel = viewModel()

    val loanPaymentViewModel: LoanPaymentViewModel = viewModel()

    val topCompaniesViewModel: TopCompaniesViewModel = viewModel()

    NavHost(navController = navController, startDestination = StartDestination) {

        //Main View
        composable(route = NavigationDestinations.HOMESCREEN_ROUTE) {
            PhonepeApplication(
                mainScreenViewModel
            )
        }

        /**
         * Below the term Screens means Each Icon's Screens Associated to that Specific Icon OR Buttons
         */

        //Tranfer Money Screens
        composable(route = NavigationDestinations.MOBILENUMBERSCREEN_ROUTE) { MobileNumberScreen() }
        composable(route = NavigationDestinations.ADDBANKSCREEN_ROUTE) { AddBankAccount() }
        composable(route = NavigationDestinations.SELFACCOUNT_ROUTE) { SelfAccountScreen() }
        composable(route = NavigationDestinations.BANKSCREEN_ROUTE) { BankScreen() }
        composable(route = NavigationDestinations.CHECKBALANCESCREEN_ROUTE) { CheckBalanceScreen() }

        //Recharge And Pay Bills Screens
        composable(route = NavigationDestinations.CREDITCARDBILLPAYMENTSCREEN_ROUTE) { CreditCardBillPayment() }
        composable(route = NavigationDestinations.ELECTRICITYSCREEN_ROUTE) { ElectricityScreen() }
        composable(route = NavigationDestinations.RENTPAYMENTSCREEN_ROUTE) { RentPaymentScreen() }
        composable(route = NavigationDestinations.LOANPAYMENTSCREEN_ROUTE) { LoanPaymentScreen(loanPaymentViewModel) }
        composable(route = NavigationDestinations.MOBILERECHARGESCREEN_ROUTE) { MobileRechargeScreen() }
        composable(route = NavigationDestinations.DTHSCREEN_ROUTE) { DTHScreen() }
        composable(route = NavigationDestinations.GASCYLINDERSCREEN_ROUTE) { GasCylinderScreen() }

        //Insurance Screens
        composable(route = NavigationDestinations.BIKESCREEN_ROUTE) { BikeScreen() }
        composable(route = NavigationDestinations.HEALTHSCREEN_ROUTE) { HealthScreen() }
        composable(route = NavigationDestinations.CARSCREEN_ROUTE) { CarScreen() }
        composable(route = NavigationDestinations.ACCIDENTSCREEN_ROUTE) { AccidentScreen() }
        composable(route = NavigationDestinations.INSURANCERENEWAL_ROUTE) { InsuranceRenewalScreen() }

        //Wealth Screens
        composable(route = NavigationDestinations.GOLDSCREEN_ROUTE) { GoldScreen() }
        composable(route = NavigationDestinations.TOPCOMPANIES_ROUTE) { TopCompaniesScreen(topCompaniesViewModel) }


        //Home Screen Buttons
        composable(route = NavigationDestinations.REFERANDGETBUTTON_ROUTE) { ReferAndGetButtonScreen() }
        composable(route = NavigationDestinations.PHONEPEWALLETBUTTON_ROUTE) { PhonepeWalletScreen() }
        composable(route = NavigationDestinations.REWARDBUTTON_ROUTE) { RewardScreen() }


        //Testing
        composable(route = NavigationDestinations.DYNAMICSCREEN_ROUTE){ DynamicScreen(topCompaniesViewModel)}

    }
}
