package ru.com.bulat.cleanarchitecture.presentation

import android.util.Log
import ru.com.bulat.cleanarchitecture.domain.models.SaveUserNameParam
import ru.com.bulat.cleanarchitecture.domain.models.UserName
import ru.com.bulat.cleanarchitecture.domain.usecase.GetUserNameUseCase
import ru.com.bulat.cleanarchitecture.domain.usecase.SaveUserNameUseCase

class MainPresenterImpl (
    private val getUserNameUseCase : GetUserNameUseCase,
    private val saveUserNameUseCase : SaveUserNameUseCase,
    private val view: MainView,
) : MAinPresenter {

    init {
        Log.d("AAA", "VM created")
    }
    

    override fun save (text:String){
        val params = SaveUserNameParam(name = text)
        val resultData = saveUserNameUseCase.execute(param = params)
        view.showResult("Save result = $resultData")
    }

    override fun load (){
        val userName: UserName = getUserNameUseCase.execute()
        view.showResult("${userName.firstName} ${userName.lastName}")
    }

}