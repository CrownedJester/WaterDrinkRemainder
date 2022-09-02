package com.crownedjester.soft.waterdrinkremainder.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "alarm_table")
data class Alarm(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val hours: Int,
    val minutes: Int
)
