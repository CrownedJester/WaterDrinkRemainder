package com.crownedjester.soft.waterdrinkremainder.data.data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.crownedjester.soft.waterdrinkremainder.data.model.HydrationDaily
import kotlinx.coroutines.flow.Flow

@Dao
interface HydrationDailyDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun addDailyStat(hydrationDaily: HydrationDaily)

    @Query("select * from hydration_daily_table")
    fun getDailiesStat(): Flow<List<HydrationDaily>>

}