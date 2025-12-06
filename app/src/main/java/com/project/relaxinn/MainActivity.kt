package com.project.relaxinn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.project.relaxinn.presentation.ui.main.MainContainer
import com.project.relaxinn.presentation.navigation.Screen
import com.project.relaxinn.presentation.theme.AppTheme
import com.project.relaxinn.presentation.ui.auth.forgotpassword.ForgotPasswordScreen
import com.project.relaxinn.presentation.ui.auth.login.LoginScreen
import com.project.relaxinn.presentation.ui.auth.signup.SignUpScreen
import com.project.relaxinn.presentation.ui.hoteldetail.HotelDetailScreen
import com.project.relaxinn.presentation.ui.welcome.WelcomeScreen
import androidx.navigation.NavType
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                val navController = rememberNavController()
                Scaffold { paddingValues ->
                    NavHost(
                        navController = navController,
                        startDestination = Screen.Welcome.route
                    ) {

                        composable(Screen.Welcome.route) {
                            WelcomeScreen(
                                onSignUpClick = {
                                    navController.navigate(Screen.Register.route)
                                },
                                onLoginClick = {
                                    navController.navigate(Screen.Login.route)
                                }
                            )
                        }

                        composable(Screen.Login.route) {
                            LoginScreen(
                                onLoginClick = {
                                    // Navigate to home after successful login
                                    navController.navigate(Screen.Home.route) {
                                        popUpTo(Screen.Welcome.route) { inclusive = true }
                                    }
                                },
                                onSignUpClick = {
                                    navController.navigate(Screen.Register.route)
                                },
                                onForgotPasswordClick = {
                                    navController.navigate(Screen.ForgotPassword.route)
                                }
                            )
                        }

                        composable(Screen.Register.route) {
                            SignUpScreen(
                                onSignUpClick = {
                                    // Navigate to home after successful signup
                                    navController.navigate(Screen.Home.route) {
                                        popUpTo(Screen.Welcome.route) { inclusive = true }
                                    }
                                },
                                onSignInClick = {
                                    navController.popBackStack()
                                }
                            )
                        }

                        composable(Screen.ForgotPassword.route) {
                            ForgotPasswordScreen(
                                onSubmitClick = {
                                    // Navigate back to login after successful submission
                                    navController.popBackStack()
                                },
                                onBackToLoginClick = {
                                    navController.popBackStack()
                                }
                            )
                        }

                        composable(Screen.Home.route) {
                            MainContainer(navController = navController)
                        }

                        composable(
                            route = Screen.HotelDetail.route,
                            arguments = listOf(
                                navArgument("hotelName") { type = NavType.StringType },
                                navArgument("location") { type = NavType.StringType },
                                navArgument("rating") { type = NavType.StringType },
                                navArgument("price") { type = NavType.StringType }
                            )
                        ) { backStackEntry ->
                            val hotelName = backStackEntry.arguments?.getString("hotelName") ?: ""
                            val location = backStackEntry.arguments?.getString("location") ?: ""
                            val rating = backStackEntry.arguments?.getString("rating")?.toFloatOrNull() ?: 0f
                            val price = backStackEntry.arguments?.getString("price") ?: ""

                            HotelDetailScreen(
                                hotelName = hotelName,
                                location = location,
                                rating = rating,
                                price = price,
                                onBackClick = {
                                    navController.popBackStack()
                                },
                                onBookNowClick = {
                                    // TODO: Navigate to booking confirmation
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
