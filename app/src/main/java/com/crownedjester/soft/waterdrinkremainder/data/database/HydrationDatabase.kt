package com.crownedjester.soft.waterdrinkremainder.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.crownedjester.soft.waterdrinkremainder.data.data_source.AlarmDao
import com.crownedjester.soft.waterdrinkremainder.data.data_source.HydrationDailyDao
import com.crownedjester.soft.waterdrinkremainder.data.data_source.UserDao
import com.crownedjester.soft.waterdrinkremainder.data.model.Alarm
import com.crownedjester.soft.waterdrinkremainder.data.model.HydrationDaily
import com.crownedjester.soft.waterdrinkremainder.data.model.User


@Database(
    entities = [Alarm::class, HydrationDaily::class, User::class],
    version = 1,
    exportSchema = false

)
abstract class HydrationDatabase : RoomDatabase() {

    abstract val alarmDao: AlarmDao
    abstract val hydrationDailyDao: HydrationDailyDao
    abstract val userDao: UserDao

    companion object {
        const val database_name = "hydration_database"
    }

}