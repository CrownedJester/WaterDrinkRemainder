package com.crownedjester.soft.waterdrinkremainder.common

import androidx.datastore.preferences.core.intPreferencesKey

object DataStorePreferences {

    const val DATASTORE_NAME = "hydration_datastore"

    private const val HYDRATION_KEY_NAME = "daily_hydration"

    const val HYDRATION_DEFAULT_VALUE = 0
    val hydrationPreference = intPreferencesKey(HYDRATION_KEY_NAME)


}