package com.crownedjester.soft.waterdrinkremainder.domain.repository.hydration_daily

import com.crownedjester.soft.waterdrinkremainder.data.data_source.HydrationDailyDao
import com.crownedjester.soft.waterdrinkremainder.data.model.HydrationDaily
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HydrationDailyRepositoryManager @Inject constructor(private val hydrationDailyDao: HydrationDailyDao) :
    HydrationDailyRepository {

    override suspend fun addDailyStat(hydrationDaily: HydrationDaily) =
        hydrationDailyDao.addDailyStat(hydrationDaily = hydrationDaily)

    override fun getDailiesStat(): Flow<List<HydrationDaily>> = hydrationDailyDao.getDailiesStat()

}