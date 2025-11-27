package com.project.relaxinn.presentation.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Detail : Screen("detail")
}
