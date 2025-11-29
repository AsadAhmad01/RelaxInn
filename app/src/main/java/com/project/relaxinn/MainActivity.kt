package com.project.relaxinn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.project.relaxinn.presentation.ui.home.HomeScreen
import com.project.relaxinn.presentation.navigation.Screen
import com.project.relaxinn.presentation.theme.AppTheme
import com.project.relaxinn.presentation.ui.auth.login.LoginScreen
import com.project.relaxinn.presentation.ui.welcome.WelcomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                val navController = rememberNavController()
                Scaffold { _ ->
                    NavHost(
                        navController = navController,
                        startDestination = Screen.Welcome.route
                    ) {

                        composable(Screen.Welcome.route) {
                            WelcomeScreen(onSignUpClick = {}, onLoginClick = {
                                navController.navigate(Screen.Login.route)
                            })
                        }

                        composable(Screen.Login.route) {
                            LoginScreen(
                                onLoginClick = {},
                                onSignUpClick = {},
                                onForgotPasswordClick = {})
                        }

                        composable(Screen.Home.route) {
                            HomeScreen()
                        }
                    }
                }
            }
        }
    }
}
