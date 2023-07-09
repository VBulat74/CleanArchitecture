package ru.com.bulat.cleanarchitecture.data.repository

import ru.com.bulat.cleanarchitecture.data.storage.models.User
import ru.com.bulat.cleanarchitecture.data.storage.UserStorage
import ru.com.bulat.cleanarchitecture.domain.models.SaveUserNameParam
import ru.com.bulat.cleanarchitecture.domain.models.UserName
import ru.com.bulat.cleanarchitecture.domain.repository.UserRepository

class UserRepositoryImpl (private val userStorage: UserStorage) :UserRepository {

    override fun saveName (saveParam: SaveUserNameParam) : Boolean {

        val result = userStorage.save(mapToStorage(saveParam))
        return result

    }

    override fun getName() : UserName {
        val user = userStorage.getName()

        return mapToDomain(user)
    }

    fun mapToStorage (saveParam: SaveUserNameParam) : User {
        return User (firstName = saveParam.name, "")
    }
    fun mapToDomain (user: User) : UserName {
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }
}