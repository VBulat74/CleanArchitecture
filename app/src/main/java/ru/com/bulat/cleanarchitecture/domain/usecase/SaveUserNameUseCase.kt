package ru.com.bulat.cleanarchitecture.domain.usecase

import ru.com.bulat.cleanarchitecture.domain.models.SaveUserNameParam

class SaveUserNameUseCase {

    fun execute (param: SaveUserNameParam) : Boolean {
        if(param.name.isEmpty()){
            return false
        } else {
            return true
        }
    }
}