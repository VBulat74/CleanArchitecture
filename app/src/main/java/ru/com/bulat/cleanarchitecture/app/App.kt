package ru.com.bulat.cleanarchitecture.app

import android.app.Application
import ru.com.bulat.cleanarchitecture.di.AppComponent
import ru.com.bulat.cleanarchitecture.di.AppModule
import ru.com.bulat.cleanarchitecture.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()
    }
}