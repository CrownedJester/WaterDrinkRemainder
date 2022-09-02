package com.crownedjester.soft.waterdrinkremainder.domain.repository.user

import com.crownedjester.soft.waterdrinkremainder.data.model.User

interface UserRepository {

    suspend fun regUser(user: User)

    suspend fun getUserByUsername(username: String): User

}