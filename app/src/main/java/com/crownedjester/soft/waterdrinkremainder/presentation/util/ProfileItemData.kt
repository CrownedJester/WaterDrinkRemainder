package com.crownedjester.soft.waterdrinkremainder.presentation.util

import androidx.annotation.DrawableRes
import com.crownedjester.soft.waterdrinkremainder.R

data class ProfileItemData(
    @DrawableRes val imageRes: Int,
    val title: String,
    val route: String = ""
) {
    companion object {
        val itemsList
            get() = listOf(
                ProfileItemData(
                    R.drawable.ic_profile_100,
                    "Profile",
                    Screen.EditProfileScreen.route
                ),
                ProfileItemData(
                    R.drawable.ic_notifications_100,
                    "Notifications",
                    Screen.ReminderSettingsScreen.route
                ),

                ProfileItemData(
                    R.drawable.ic_statistics_100,
                    "Statistics",
                ),
                ProfileItemData(
                    R.drawable.ic_preferences_100,
                    "Settings",
                    Screen.AppSettingsScreen.route
                )
            )
    }
}