package com.crownedjester.soft.waterdrinkremainder.presentation.util

sealed class Screen(val title: String = "", val route: String) {
    object ProfileScreen : Screen(route = "profile_screen")
    object DashboardScreen : Screen(route = "dashboard_screen")
    object StatusScreen : Screen(route = "status_screen")
    object EditProfileScreen : Screen(title = "Edit Profile Screen", route = "edit_profile_screen")
    object ReminderSettingsScreen : Screen(title = "Reminder", route = "reminder_settings_screen")
    object AppSettingsScreen : Screen(title = "Settings", route = "settings_screen")
    object UserStatisticsScreen : Screen(title = "Statistics", route = "statistics_screen")
}
