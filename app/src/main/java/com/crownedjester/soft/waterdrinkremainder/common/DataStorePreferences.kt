package com.crownedjester.soft.waterdrinkremainder.common

import androidx.datastore.preferences.core.intPreferencesKey

object DataStorePreferences {

    const val DATASTORE_NAME = "hydration_datastore"

    private const val HYDRATION_KEY_NAME = "daily_hydration"
    private const val GOAL_NAME = "goal_hydration"

    const val HYDRATION_DEFAULT_VALUE = 0
    val dailyHydrationPreferences = intPreferencesKey(HYDRATION_KEY_NAME)

    const val GOAL_DEFAULT_VALUE = 2000
    val goalPreferences = intPreferencesKey(GOAL_NAME)


}