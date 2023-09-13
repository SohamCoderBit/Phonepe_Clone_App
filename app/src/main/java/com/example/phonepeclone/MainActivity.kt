package com.example.phonepeclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme

val navController = NavigationController()

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhonepeCloneTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = colorResource(id = R.color.background)
                ) {
                    navController.setNavigationController(rememberNavController())
                    NavGraphInit(navController = navController.getNavigationController() as NavHostController)
                }
            }
        }
    }
}
