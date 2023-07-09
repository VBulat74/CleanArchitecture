package ru.com.bulat.cleanarchitecture.domain.usecase

import ru.com.bulat.cleanarchitecture.domain.models.SaveUserNameParam
import ru.com.bulat.cleanarchitecture.domain.repository.UserRepository

class SaveUserNameUseCase (private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam): Boolean {

        val oldUserName = userRepository.getName()

        if (oldUserName.firstName == param.name) return true

        return userRepository.saveName(saveParam = param)
    }
}