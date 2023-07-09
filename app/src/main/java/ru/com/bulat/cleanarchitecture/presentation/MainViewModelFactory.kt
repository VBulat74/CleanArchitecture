package ru.com.bulat.cleanarchitecture.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.com.bulat.cleanarchitecture.data.repository.UserRepositoryImpl
import ru.com.bulat.cleanarchitecture.data.storage.sharedpref.SharedPrefUserStorage
import ru.com.bulat.cleanarchitecture.domain.usecase.GetUserNameUseCase
import ru.com.bulat.cleanarchitecture.domain.usecase.SaveUserNameUseCase

class MainViewModelFactory (context: Context) : ViewModelProvider.Factory {

    private val userRepository by lazy (LazyThreadSafetyMode.NONE) {
        val userStorage = SharedPrefUserStorage(context = context)
        UserRepositoryImpl(userStorage)
    }
    private val getUserNameUseCase by lazy (LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(
            userRepository = userRepository
        )
    }
    private val saveUserNameUseCase by lazy (LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(
            userRepository = userRepository
        )
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        //return super.create(modelClass)
        return MainViewModel (
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase,
        ) as T
    }
}