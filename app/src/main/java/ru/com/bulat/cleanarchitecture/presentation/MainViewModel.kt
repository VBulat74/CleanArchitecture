package ru.com.bulat.cleanarchitecture.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.com.bulat.cleanarchitecture.domain.models.SaveUserNameParam
import ru.com.bulat.cleanarchitecture.domain.models.UserName
import ru.com.bulat.cleanarchitecture.domain.usecase.GetUserNameUseCase
import ru.com.bulat.cleanarchitecture.domain.usecase.SaveUserNameUseCase

class MainViewModel (
    private val getUserNameUseCase : GetUserNameUseCase,
    private val saveUserNameUseCase : SaveUserNameUseCase
) :ViewModel() {

    private var stateLiveMutable = MutableLiveData<MainState>()
    val stateLive : LiveData<MainState> = stateLiveMutable

    init {
        Log.d("AAA", "VM created")
        stateLiveMutable.value = MainState(
            saveResult = false,
            firsName = "",
            lastName = "",
        )
    }

    override fun onCleared() {
        Log.d("AAA", "VM cleared")
        super.onCleared()
    }
    

    fun send(event: MainEvent) {
        when (event) {
            is SaveEvent -> {
                save(event.text)
            }
            is LoadEvent -> {
                load()
            }

        }
    }

    private fun save (text:String){
        val params = SaveUserNameParam(name = text)
        val resultData = saveUserNameUseCase.execute(param = params)
        stateLiveMutable.value = MainState(
            saveResult = resultData,
            firsName = stateLiveMutable.value!!.firsName,
            lastName = stateLiveMutable.value!!.lastName,
        )
    }

    private fun load (){
        val userName: UserName = getUserNameUseCase.execute()
        stateLiveMutable.value = MainState(
            saveResult = stateLiveMutable.value!!.saveResult,
            firsName = userName.firstName,
            lastName = userName.lastName,
        )
    }

}