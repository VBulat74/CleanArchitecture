package ru.com.bulat.cleanarchitecture.data.storage

import ru.com.bulat.cleanarchitecture.data.storage.models.User

interface UserStorage {

    fun save(user: User) : Boolean
    fun getName() : User
}