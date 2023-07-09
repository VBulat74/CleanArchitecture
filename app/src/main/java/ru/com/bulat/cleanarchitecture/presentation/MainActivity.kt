package ru.com.bulat.cleanarchitecture.presentation

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.com.bulat.cleanarchitecture.R
import ru.com.bulat.cleanarchitecture.data.repository.UserRepositoryImpl
import ru.com.bulat.cleanarchitecture.data.storage.sharedpref.SharedPrefUserStorage
import ru.com.bulat.cleanarchitecture.domain.usecase.GetUserNameUseCase
import ru.com.bulat.cleanarchitecture.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {
    private val userRepository by lazy (LazyThreadSafetyMode.NONE) {
        val userStorage = SharedPrefUserStorage(context = applicationContext)
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataTextVew = findViewById<TextView>(R.id.dataTextView)
        val dataEditView = findViewById<TextView>(R.id.dataEditView)

        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)

        sendButton.setOnClickListener {
            // Клик по кнопке Save data
            val text = dataEditView.text.toString()
            val params = ru.com.bulat.cleanarchitecture.domain.models.SaveUserNameParam(name = text)
            val result = saveUserNameUseCase.execute(param = params)
            dataTextVew.setText("Save result = $result")
        }

        receiveButton.setOnClickListener {
            // Клик по кнопке Get data
            val userName: ru.com.bulat.cleanarchitecture.domain.models.UserName = getUserNameUseCase.execute()
            dataTextVew.setText ("${userName.firstName} ${userName.lastName}")
        }
    }
}