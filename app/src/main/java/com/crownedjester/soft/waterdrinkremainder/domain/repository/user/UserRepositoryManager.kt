package com.crownedjester.soft.waterdrinkremainder.domain.repository.user

import com.crownedjester.soft.waterdrinkremainder.data.data_source.UserDao
import com.crownedjester.soft.waterdrinkremainder.data.model.User
import javax.inject.Inject

class UserRepositoryManager @Inject constructor(private val userDao: UserDao) : UserRepository {

    override suspend fun regUser(user: User) =
        userDao.regUser(user)


    override suspend fun getUserByUsername(username: String): User =
        userDao.getUserByUsername(username)


}