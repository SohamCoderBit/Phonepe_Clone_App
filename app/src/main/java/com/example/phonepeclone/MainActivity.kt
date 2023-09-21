package com.example.phonepeclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme

val bottomBarNavController = NavigationController()
val mainNavController = NavigationController()

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhonepeCloneTheme {
                mainNavController.setNavigationController(rememberNavController())
                PhonepeApplication(
                    mainScreenViewModel = viewModel()
                )
            }
        }
    }
}
