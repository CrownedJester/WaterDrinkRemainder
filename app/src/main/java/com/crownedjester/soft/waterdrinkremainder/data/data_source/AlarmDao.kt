package com.crownedjester.soft.waterdrinkremainder.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.crownedjester.soft.waterdrinkremainder.data.model.Alarm
import kotlinx.coroutines.flow.Flow


@Dao
interface AlarmDao {

    @Query("select * from alarm_table")
    fun getAlarms():Flow<List<Alarm>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addAlarm(alarm: Alarm)

    @Delete
    suspend fun deleteAlarm(alarm: Alarm)
}