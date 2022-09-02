package com.crownedjester.soft.waterdrinkremainder.domain.repository.alarm

import com.crownedjester.soft.waterdrinkremainder.data.model.Alarm
import kotlinx.coroutines.flow.Flow

interface AlarmRepository {

    fun getAlarms(): Flow<List<Alarm>>

    suspend fun addAlarm(alarm: Alarm)

    suspend fun deleteAlarm(alarm: Alarm)

}