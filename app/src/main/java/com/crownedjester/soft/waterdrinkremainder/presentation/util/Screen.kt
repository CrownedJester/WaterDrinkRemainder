package com.crownedjester.soft.waterdrinkremainder.presentation.util

sealed class Screen(val route: String) {
    object ProfileScreen : Screen(route = "profile_screen")
    object DashboardScreen : Screen(route = "dashboard_screen")
    object StatusScreen : Screen(route = "status_screen")
}
