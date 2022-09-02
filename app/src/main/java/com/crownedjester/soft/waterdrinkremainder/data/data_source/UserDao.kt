package com.crownedjester.soft.waterdrinkremainder.data.data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.crownedjester.soft.waterdrinkremainder.data.model.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun regUser(user: User)

    @Query("select * from user_table where username=:username")
    suspend fun getUserByUsername(username: String): User

}