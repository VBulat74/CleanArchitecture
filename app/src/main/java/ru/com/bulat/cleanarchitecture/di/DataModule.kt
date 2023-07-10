package ru.com.bulat.cleanarchitecture.di

import org.koin.dsl.module
import ru.com.bulat.cleanarchitecture.data.repository.UserRepositoryImpl
import ru.com.bulat.cleanarchitecture.data.storage.UserStorage
import ru.com.bulat.cleanarchitecture.data.storage.sharedpref.SharedPrefUserStorage
import ru.com.bulat.cleanarchitecture.domain.repository.UserRepository

val dataModule = module {

    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }
}