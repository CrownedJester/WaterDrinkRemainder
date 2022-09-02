package com.crownedjester.soft.waterdrinkremainder.domain.use_cases.user.get_user_by_username

import com.crownedjester.soft.waterdrinkremainder.domain.repository.user.UserRepository
import javax.inject.Inject

class GetUserByUsername @Inject constructor(
    private val userRepository: UserRepository
) {

    suspend operator fun invoke(username: String) =
        userRepository.getUserByUsername(username)

}