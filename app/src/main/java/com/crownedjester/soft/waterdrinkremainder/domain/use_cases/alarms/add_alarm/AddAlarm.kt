package com.crownedjester.soft.waterdrinkremainder.domain.use_cases.alarms.add_alarm

import com.crownedjester.soft.waterdrinkremainder.data.model.Alarm
import com.crownedjester.soft.waterdrinkremainder.domain.repository.alarm.AlarmRepository
import javax.inject.Inject

class AddAlarm @Inject constructor(
    private val alarmRepository: AlarmRepository
) {

    suspend operator fun invoke(alarm: Alarm) =
        alarmRepository.addAlarm(alarm)

}