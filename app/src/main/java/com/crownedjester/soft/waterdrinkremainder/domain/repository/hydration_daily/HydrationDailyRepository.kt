package com.crownedjester.soft.waterdrinkremainder.domain.repository.hydration_daily

import com.crownedjester.soft.waterdrinkremainder.data.model.HydrationDaily
import kotlinx.coroutines.flow.Flow

interface HydrationDailyRepository {

    suspend fun addDailyStat(hydrationDaily: HydrationDaily)

    fun getDailiesStat(): Flow<List<HydrationDaily>>

}