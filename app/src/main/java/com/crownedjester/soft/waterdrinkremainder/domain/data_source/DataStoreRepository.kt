package com.crownedjester.soft.waterdrinkremainder.domain.data_source

import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {

    val dailyHydration: Flow<Int>

    suspend fun updateDailyHydration(drankAmount: Int)

}