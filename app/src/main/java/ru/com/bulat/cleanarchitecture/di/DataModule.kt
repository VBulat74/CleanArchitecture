package ru.com.bulat.cleanarchitecture.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.com.bulat.cleanarchitecture.data.repository.UserRepositoryImpl
import ru.com.bulat.cleanarchitecture.data.storage.UserStorage
import ru.com.bulat.cleanarchitecture.data.storage.sharedpref.SharedPrefUserStorage
import ru.com.bulat.cleanarchitecture.domain.repository.UserRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideUserStorage(@ApplicationContext context: Context): UserStorage {
        return SharedPrefUserStorage(context = context)
    }

    @Provides
    @Singleton
    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage = userStorage)
    }
}