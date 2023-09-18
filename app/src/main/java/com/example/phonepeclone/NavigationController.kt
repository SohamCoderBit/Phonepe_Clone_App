package com.example.phonepeclone

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.phonepeclone.ViewModels.AddBankAccountVIewModel
import com.example.phonepeclone.ViewModels.DynamicScreenViewModel
import com.example.phonepeclone.ViewModels.InsuranceRenewalViewModel
import com.example.phonepeclone.ViewModels.LoanPaymentViewModel
import com.example.phonepeclone.ViewModels.MainScreenViewModel
import com.example.phonepeclone.ViewModels.TaxSavingFundViewModel
import com.example.phonepeclone.ViewModels.TopCompaniesViewModel
import com.example.phonepeclone.ui.Screens.HomeUnitScreens.PhonepeWalletScreen
import com.example.phonepeclone.ui.Screens.HomeUnitScreens.ReferAndGetButtonScreen
import com.example.phonepeclone.ui.Screens.HomeUnitScreens.RewardScreen
import com.example.phonepeclone.ui.Screens.HomeUnitScreens.UPILiteScreen
import com.example.phonepeclone.ui.Screens.InsuranceScreens.InsuranceRenewalScreen
import com.example.phonepeclone.ui.Screens.InsuranceScreens.TermLifeScreen
import com.example.phonepeclone.ui.Screens.WealthScreens.BestSIPFundsScreen
import com.example.phonepeclone.ui.Screens.WealthScreens.DynamicScreen
import com.example.phonepeclone.ui.Screens.WealthScreens.GoldScreen
import com.example.phonepeclone.ui.Screens.WealthScreens.HighReturnsScreen
import com.example.phonepeclone.ui.Screens.WealthScreens.TaxSavingFundScreen
import com.example.phonepeclone.ui.Screens.WealthScreens.TopCompaniesScreen
import com.example.phonepeclone.ui.Screens.WealthScreens.TrendingThemesScreen
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
    const val HOME_SCREEN_ROUTE = "HomeScreen"
    const val UPI_LITE_ROUTE = "UPILiteScreen"
    const val MOBILE_NUMBER_SCREEN_ROUTE = "MobileNumberScreen"
    const val BANK_SCREEN_ROUTE = "BankScreen"
    const val CHECK_BALANCE_SCREEN_ROUTE = "CheckBalanceScreen"
    const val ELECTRICITY_SCREEN_ROUTE = "ElectricityScreen"
    const val RENT_PAYMENT_SCREEN_ROUTE = "RentPaymentScreen"
    const val LOAN_PAYMENT_SCREEN_ROUTE = "LoanPaymentScreen"
    const val MOBILE_RECHARGE_SCREEN_ROUTE = "MobileRechargeScreen"
    const val DTH_SCREEN_ROUTE = "DTHScreen"
    const val GAS_CYLINDER_SCREEN_ROUTE = "GasCylinderScreen"
    const val BIKE_SCREEN_ROUTE = "BikeScreen"
    const val HEALTH_SCREEN_ROUTE = "HealthScreen"
    const val CREDIT_CARD_BILL_PAYMENT_SCREEN_ROUTE = "CreditCardBillPayment"
    const val CAR_SCREEN_ROUTE = "CarScreen"
    const val ACCIDENT_SCREEN_ROUTE = "AccidentScreen"
    const val ADD_BANK_SCREEN_ROUTE = "AddBankAccount"
    const val SELF_ACCOUNT_ROUTE = "SelfAccountScreen"
    const val GOLD_SCREEN_ROUTE = "GoldScreen"

    const val REFER_AND_GET_BUTTON_ROUTE = "ReferAndGetButtonScreen"
    const val PHONEPE_WALLET_BUTTON_ROUTE = "PhonepeWalletScreen"
    const val REWARD_BUTTON_ROUTE = "RewardScreen"

    const val INSURANCE_RENEWAL_ROUTE = "InsuranceRenewalScreen"

    const val TAX_SAVING_FUND_ROUTE = "TaxSavingFundScreen"
    const val HIGH_RETURN_FUND_ROUTE =  "HighReturnsScreen"
    const val TOP_COMPANIES_ROUTE = "TopCompaniesScreen"
    const val BEST_SIP_FUNDS_ROUTE = "BestSIPFundsScreen"
    const val TRENDING_THEME_ROUTE = "TrendingThemesScreen"

    const val TERM_LIFE_ROUTE = "TermLifeScreen"

    //Testing
    const val DYNAMIC_SCREEN_ROUTE = "DynamicScreen"
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
    StartDestination: String = NavigationDestinations.HOME_SCREEN_ROUTE
) {

    val mainScreenViewModel: MainScreenViewModel = viewModel()

    val loanPaymentViewModel: LoanPaymentViewModel = viewModel()

    val topCompaniesViewModel: TopCompaniesViewModel = viewModel()

    val taxSavingFundViewModel: TaxSavingFundViewModel = viewModel()

    val dynamicScreenViewModel: DynamicScreenViewModel = viewModel()

    val insuranceRenewalViewModel: InsuranceRenewalViewModel = viewModel()

    val addBankAccountVIewModel: AddBankAccountVIewModel = viewModel()

    NavHost(navController = navController, startDestination = StartDestination) {

        //Main View
        composable(route = NavigationDestinations.HOME_SCREEN_ROUTE) { PhonepeApplication(mainScreenViewModel)}

        /**
         * Below the term Screens means Each Icon's Screens Associated to that Specific Icon OR Buttons
         */

        //Tranfer Money Screens
        composable(route = NavigationDestinations.MOBILE_NUMBER_SCREEN_ROUTE) { MobileNumberScreen() }
        composable(route = NavigationDestinations.ADD_BANK_SCREEN_ROUTE) { AddBankAccount(addBankAccountVIewModel) }
        composable(route = NavigationDestinations.SELF_ACCOUNT_ROUTE) { SelfAccountScreen() }
        composable(route = NavigationDestinations.BANK_SCREEN_ROUTE) { BankScreen() }
        composable(route = NavigationDestinations.CHECK_BALANCE_SCREEN_ROUTE) { CheckBalanceScreen() }

        //Recharge And Pay Bills Screens
        composable(route = NavigationDestinations.CREDIT_CARD_BILL_PAYMENT_SCREEN_ROUTE) { CreditCardBillPayment() }
        composable(route = NavigationDestinations.ELECTRICITY_SCREEN_ROUTE) { ElectricityScreen() }
        composable(route = NavigationDestinations.RENT_PAYMENT_SCREEN_ROUTE) { RentPaymentScreen() }
        composable(route = NavigationDestinations.LOAN_PAYMENT_SCREEN_ROUTE) { LoanPaymentScreen(loanPaymentViewModel) }
        composable(route = NavigationDestinations.MOBILE_RECHARGE_SCREEN_ROUTE) { MobileRechargeScreen() }
        composable(route = NavigationDestinations.DTH_SCREEN_ROUTE) { DTHScreen() }
        composable(route = NavigationDestinations.GAS_CYLINDER_SCREEN_ROUTE) { GasCylinderScreen() }


        //UPI Lite
        composable(route = NavigationDestinations.UPI_LITE_ROUTE) { UPILiteScreen() }
        //Insurance Screens
        composable(route = NavigationDestinations.BIKE_SCREEN_ROUTE) { BikeScreen() }
        composable(route = NavigationDestinations.HEALTH_SCREEN_ROUTE) { HealthScreen() }
        composable(route = NavigationDestinations.CAR_SCREEN_ROUTE) { CarScreen() }
        composable(route = NavigationDestinations.ACCIDENT_SCREEN_ROUTE) { AccidentScreen() }
        composable(route = NavigationDestinations.INSURANCE_RENEWAL_ROUTE) { InsuranceRenewalScreen(insuranceRenewalViewModel) }
        composable(route = NavigationDestinations.TERM_LIFE_ROUTE) { TermLifeScreen() }

        //Wealth Screens
        composable(route = NavigationDestinations.GOLD_SCREEN_ROUTE) { GoldScreen() }
        composable(route = NavigationDestinations.TOP_COMPANIES_ROUTE) { TopCompaniesScreen(topCompaniesViewModel, dynamicScreenViewModel) }
        composable(route = NavigationDestinations.TAX_SAVING_FUND_ROUTE) { TaxSavingFundScreen(taxSavingFundViewModel) }
        composable(route = NavigationDestinations.HIGH_RETURN_FUND_ROUTE){ HighReturnsScreen(topCompaniesViewModel, dynamicScreenViewModel)   }
        composable(route = NavigationDestinations.BEST_SIP_FUNDS_ROUTE){  BestSIPFundsScreen(topCompaniesViewModel , dynamicScreenViewModel)  }
        composable(route = NavigationDestinations.TRENDING_THEME_ROUTE){ TrendingThemesScreen(topCompaniesViewModel , dynamicScreenViewModel)}



        //Home Screen Buttons
        composable(route = NavigationDestinations.REFER_AND_GET_BUTTON_ROUTE) { ReferAndGetButtonScreen() }
        composable(route = NavigationDestinations.PHONEPE_WALLET_BUTTON_ROUTE) { PhonepeWalletScreen() }
        composable(route = NavigationDestinations.REWARD_BUTTON_ROUTE) { RewardScreen() }


        //Testing
        composable(route = NavigationDestinations.DYNAMIC_SCREEN_ROUTE) { DynamicScreen(dynamicScreenViewModel) }

    }
}
