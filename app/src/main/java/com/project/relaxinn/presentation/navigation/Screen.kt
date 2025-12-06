package com.project.relaxinn.presentation.navigation

sealed class Screen(val route: String) {
    object Welcome : Screen("welcome")
    object Login : Screen("login")
    object Register : Screen("register")
    object ForgotPassword : Screen("forgotPassword")
    object Home : Screen("home")
    object Explore : Screen("explore")
    object Bookings : Screen("bookings")
    object Favorites : Screen("favorites")
    object Profile : Screen("profile")
    object Detail : Screen("detail")
}
