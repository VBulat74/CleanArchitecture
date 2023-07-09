package ru.com.bulat.cleanarchitecture.domain.usecase

import ru.com.bulat.cleanarchitecture.domain.models.UserName
import ru.com.bulat.cleanarchitecture.domain.repository.UserRepository

class GetUserNameUseCase (private val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getName()
    }
}