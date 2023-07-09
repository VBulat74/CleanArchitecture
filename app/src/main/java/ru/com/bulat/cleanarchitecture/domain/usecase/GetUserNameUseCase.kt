package ru.com.bulat.cleanarchitecture.domain.usecase

import ru.com.bulat.cleanarchitecture.domain.models.UserName

class GetUserNameUseCase {

    fun execute(): UserName {
        return UserName(firstName = "Valdimir", lastName = "Bulat",)

    }
}