package com.crownedjester.soft.waterdrinkremainder.presentation.util

import androidx.annotation.DrawableRes
import com.crownedjester.soft.waterdrinkremainder.R

data class BottomNavItem(
    val label: String = "",
    @DrawableRes val iconId: Int,
    val route: String
)

val bottomNavItems = listOf(
    BottomNavItem(
        iconId = R.drawable.ic_status_bottom_nav,
        route = Screen.StatusScreen.route
    ),

    BottomNavItem(
        iconId = R.drawable.ic_dashboard_bottom_nav,
        route = Screen.DashboardScreen.route
    ),

    BottomNavItem(
        iconId = R.drawable.ic_profile_bottom_nav,
        route = Screen.ProfileScreen.route
    ),
)