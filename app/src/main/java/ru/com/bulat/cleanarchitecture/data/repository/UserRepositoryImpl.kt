package ru.com.bulat.cleanarchitecture.data.repository

import android.content.Context
import ru.com.bulat.cleanarchitecture.domain.models.SaveUserNameParam
import ru.com.bulat.cleanarchitecture.domain.models.UserName
import ru.com.bulat.cleanarchitecture.domain.repository.UserRepository

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName"
private const val DEFAULT_NAME = "Default last name"

class UserRepositoryImpl (context: Context) :UserRepository {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveName (saveParam: SaveUserNameParam) : Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, saveParam.name).apply()
        return true
    }

    override fun getName() : UserName {

        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, "") ?: ""
        val lastName = sharedPreferences.getString(KEY_LAST_NAME, DEFAULT_NAME) ?: DEFAULT_NAME

        return UserName(firstName = firstName, lastName = lastName)
    }
}