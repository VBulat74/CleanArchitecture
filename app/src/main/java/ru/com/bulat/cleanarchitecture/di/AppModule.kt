package ru.com.bulat.cleanarchitecture.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.com.bulat.cleanarchitecture.presentation.MainPresenterImpl

val appModule = module {

    viewModel<MainPresenterImpl> {

        MainPresenterImpl(
            getUserNameUseCase = get(),
            saveUserNameUseCase = get(),
        )
    }
}