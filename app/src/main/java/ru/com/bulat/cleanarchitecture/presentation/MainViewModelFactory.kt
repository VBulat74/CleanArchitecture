package ru.com.bulat.cleanarchitecture.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.com.bulat.cleanarchitecture.domain.usecase.GetUserNameUseCase
import ru.com.bulat.cleanarchitecture.domain.usecase.SaveUserNameUseCase
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(
    val getUserNameUseCase: GetUserNameUseCase,
    val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        //return super.create(modelClass)
        return MainViewModel(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        ) as T
    }
}