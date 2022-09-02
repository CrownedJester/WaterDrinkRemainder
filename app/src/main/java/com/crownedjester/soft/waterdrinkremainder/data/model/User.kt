package com.crownedjester.soft.waterdrinkremainder.data.model

import androidx.room.ColumnInfo
import androidx.room.ColumnInfo.BLOB
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "first_name")
    val firstName: String,
    val username: String,
    val mobile: String,
    @ColumnInfo(name = "profile_photo", typeAffinity = BLOB)
    val profilePhoto: ByteArray? = null
)
