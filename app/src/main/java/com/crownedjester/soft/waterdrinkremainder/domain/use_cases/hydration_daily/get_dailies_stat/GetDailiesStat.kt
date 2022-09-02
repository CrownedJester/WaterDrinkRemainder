package com.crownedjester.soft.waterdrinkremainder.domain.use_cases.hydration_daily.get_dailies_stat

import com.crownedjester.soft.waterdrinkremainder.domain.repository.hydration_daily.HydrationDailyRepository
import javax.inject.Inject

class GetDailiesStat @Inject constructor(
    private val hydrationDailyRepository: HydrationDailyRepository
) {

    operator fun invoke() =
        hydrationDailyRepository.getDailiesStat()


}