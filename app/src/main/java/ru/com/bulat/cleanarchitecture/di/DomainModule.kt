package ru.com.bulat.cleanarchitecture.di

import dagger.Module
import dagger.Provides
import ru.com.bulat.cleanarchitecture.domain.repository.UserRepository
import ru.com.bulat.cleanarchitecture.domain.usecase.GetUserNameUseCase
import ru.com.bulat.cleanarchitecture.domain.usecase.SaveUserNameUseCase

@Module
class DomainModule {

    @Provides
    fun provideGetUserNameUseCase (userRepository:UserRepository) : GetUserNameUseCase {
        return GetUserNameUseCase(
            userRepository = userRepository
        )
    }

    @Provides
    fun providesaveUserNameUseCase (userRepository:UserRepository) : SaveUserNameUseCase {
        return SaveUserNameUseCase(
            userRepository = userRepository
        )
    }
}