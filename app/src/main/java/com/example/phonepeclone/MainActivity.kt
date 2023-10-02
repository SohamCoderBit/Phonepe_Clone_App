package com.example.phonepeclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.phonepeclone.ViewModels.MainScreenViewModel
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme

val mainNavController = NavigationController()

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhonepeCloneTheme {
                val mainScreenViewModel : MainScreenViewModel = viewModel()
                PhonepeApplication(
                    mainScreenViewModel = mainScreenViewModel
                )
            }
        }
    }
}
