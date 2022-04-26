package com.crownedjester.soft.waterdrinkremainder.presentation.util

import androidx.annotation.DrawableRes
import com.crownedjester.soft.waterdrinkremainder.R

data class ProfileItemData(
    @DrawableRes val imageRes: Int,
    val title: String
) {
    companion object {
        val itemsList
            get() = listOf(
                ProfileItemData(R.drawable.ic_profile_100, "Profile"),
                ProfileItemData(R.drawable.ic_notifications_100, "Notifications"),
                ProfileItemData(R.drawable.ic_statistics_100, "Statistics"),
                ProfileItemData(R.drawable.ic_preferences_100, "Settings"),
            )
    }
}