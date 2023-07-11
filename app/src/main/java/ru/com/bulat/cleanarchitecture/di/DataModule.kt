package ru.com.bulat.cleanarchitecture.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.com.bulat.cleanarchitecture.data.repository.UserRepositoryImpl
import ru.com.bulat.cleanarchitecture.data.storage.UserStorage
import ru.com.bulat.cleanarchitecture.data.storage.sharedpref.SharedPrefUserStorage
import ru.com.bulat.cleanarchitecture.domain.repository.UserRepository

@Module
class DataModule {
    @Provides
    fun provideUserStorage(context: Context): UserStorage {
        return SharedPrefUserStorage(context = context)
    }

    @Provides
    fun UserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage)
    }
}