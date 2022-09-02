package com.crownedjester.soft.waterdrinkremainder.domain.use_cases.hydration_daily.add_daily_stat

import com.crownedjester.soft.waterdrinkremainder.data.model.HydrationDaily
import com.crownedjester.soft.waterdrinkremainder.domain.repository.hydration_daily.HydrationDailyRepository
import javax.inject.Inject

class AddDailyStat @Inject constructor(
    private val hydrationDailyRepository: HydrationDailyRepository
) {

    suspend operator fun invoke(hydrationDaily: HydrationDaily) =
        hydrationDailyRepository.addDailyStat(hydrationDaily)

}