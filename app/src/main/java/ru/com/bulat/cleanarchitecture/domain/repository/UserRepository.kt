package ru.com.bulat.cleanarchitecture.domain.repository

import ru.com.bulat.cleanarchitecture.domain.models.SaveUserNameParam
import ru.com.bulat.cleanarchitecture.domain.models.UserName

interface UserRepository {
    fun saveName (saveParam: SaveUserNameParam) : Boolean
    fun getName() : UserName
}