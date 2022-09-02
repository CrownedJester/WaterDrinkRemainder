package com.crownedjester.soft.waterdrinkremainder.domain.use_cases.user.reg_user

import com.crownedjester.soft.waterdrinkremainder.data.model.User
import com.crownedjester.soft.waterdrinkremainder.domain.repository.user.UserRepository
import javax.inject.Inject

class RegUser @Inject constructor(
    private val userRepository: UserRepository
) {

    suspend operator fun invoke(user: User) =
        userRepository.regUser(user)

}