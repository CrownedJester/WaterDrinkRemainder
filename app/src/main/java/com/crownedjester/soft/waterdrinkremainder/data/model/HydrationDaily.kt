package com.crownedjester.soft.waterdrinkremainder.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hydration_daily_table")
data class HydrationDaily(
    val goal: Int,
    @ColumnInfo(name="drank_amount")
    val drankAmount: Int,
    @ColumnInfo(name="is_goal_achieved")
    val isGoalAchieved: Boolean,
    @PrimaryKey
    val date: String
)
