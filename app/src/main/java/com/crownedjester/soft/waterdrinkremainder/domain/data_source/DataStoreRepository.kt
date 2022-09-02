package com.crownedjester.soft.waterdrinkremainder.domain.data_source

import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {

    val dailyHydration: Flow<Int>

    val hydrationGoal: Flow<Int>

    suspend fun updateDailyHydration(drankAmount: Int)

    suspend fun setNewHydrationGoal(value: Int)

}