package ru.com.bulat.cleanarchitecture.di

import dagger.Component
import ru.com.bulat.cleanarchitecture.presentation.MainActivity

@Component (modules = [AppModule::class, DataModule::class, DomainModule::class])
interface AppComponent {
    fun inject (mainActivity: MainActivity)
}