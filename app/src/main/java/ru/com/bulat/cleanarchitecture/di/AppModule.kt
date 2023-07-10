package ru.com.bulat.cleanarchitecture.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.com.bulat.cleanarchitecture.presentation.MainViewModel

val appModule = module {

    viewModel<MainViewModel> {

        MainViewModel(
            getUserNameUseCase = get(),
            saveUserNameUseCase = get(),
        )
    }
}