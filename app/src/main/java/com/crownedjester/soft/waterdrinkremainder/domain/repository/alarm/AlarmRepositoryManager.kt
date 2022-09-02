package com.crownedjester.soft.waterdrinkremainder.domain.repository.alarm

import com.crownedjester.soft.waterdrinkremainder.data.data_source.AlarmDao
import com.crownedjester.soft.waterdrinkremainder.data.model.Alarm
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AlarmRepositoryManager @Inject constructor(private val alarmDao: AlarmDao) : AlarmRepository {

    override fun getAlarms(): Flow<List<Alarm>> = alarmDao.getAlarms()

    override suspend fun addAlarm(alarm: Alarm) = alarmDao.addAlarm(alarm)

    override suspend fun deleteAlarm(alarm: Alarm) = alarmDao.deleteAlarm(alarm)

}