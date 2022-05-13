package com.crownedjester.soft.waterdrinkremainder.domain.data_source

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.crownedjester.soft.waterdrinkremainder.common.DataStorePreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject


private val Context.dataStore: DataStore<Preferences>
        by preferencesDataStore(name = DataStorePreferences.DATASTORE_NAME)

class DataStoreManager @Inject constructor(
    @ApplicationContext appContext: Context
) : DataStoreRepository {

    private val hydrationDataStore = appContext.dataStore

    override val dailyHydration: Flow<Int>
        get() = hydrationDataStore.getValueAsFlow(
            DataStorePreferences.hydrationPreference,
            DataStorePreferences.HYDRATION_DEFAULT_VALUE
        )

    override suspend fun updateDailyHydration(drankAmount: Int) {
        hydrationDataStore.setValue(DataStorePreferences.hydrationPreference,  drankAmount)
    }

    private suspend fun <T> DataStore<Preferences>.setValue(
        key: Preferences.Key<T>,
        value: T
    ) {
        this.edit { prefs ->
            prefs[key] = value
        }

    }

    private fun <T> DataStore<Preferences>.getValueAsFlow(
        key: Preferences.Key<T>,
        defaultValue: T
    ): Flow<T> {
        return this.data.catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }.map { prefs ->
            prefs[key] ?: defaultValue
        }
    }

}