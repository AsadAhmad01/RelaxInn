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
    object HotelDetail : Screen("hotelDetail/{hotelName}/{location}/{rating}/{price}") {
        fun createRoute(hotelName: String, location: String, rating: Float, price: String): String {
            return "hotelDetail/$hotelName/$location/$rating/$price"
        }
    }
}
