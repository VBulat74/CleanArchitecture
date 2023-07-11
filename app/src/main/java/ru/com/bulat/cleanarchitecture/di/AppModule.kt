package ru.com.bulat.cleanarchitecture.di

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule (val context: Context) {

    @Provides
    fun provideContext() : Context {
        return context
    }

//    @Provides
//    fun provideMainViewModelFactory(
//        getUserNameUseCase: GetUserNameUseCase,
//        saveUserNameUseCase: SaveUserNameUseCase,
//    ): MainViewModelFactory {
//        return MainViewModelFactory(
//            getUserNameUseCase = getUserNameUseCase,
//            saveUserNameUseCase = saveUserNameUseCase,
//        )
//    }
}