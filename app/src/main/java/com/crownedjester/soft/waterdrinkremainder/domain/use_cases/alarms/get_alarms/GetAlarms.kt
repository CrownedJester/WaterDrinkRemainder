package com.crownedjester.soft.waterdrinkremainder.domain.use_cases.alarms.get_alarms

import com.crownedjester.soft.waterdrinkremainder.domain.repository.alarm.AlarmRepository
import javax.inject.Inject

class GetAlarms @Inject constructor(
    private val alarmRepository: AlarmRepository
){

   operator fun invoke() =
       alarmRepository.getAlarms()

}