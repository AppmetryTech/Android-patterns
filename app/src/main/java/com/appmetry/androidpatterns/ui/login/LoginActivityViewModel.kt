package com.appmetry.androidpatterns.ui.login

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appmetry.androidpatterns.repositories.login.LoginRepositoryInterface
import com.appmetry.androidpatterns.utils.EmailValidator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginActivityViewModel @Inject constructor(private val loginRepository: LoginRepositoryInterface) :
    ViewModel() {

    val emailMLD = MutableLiveData<String>()
    val passwordMLD = MutableLiveData<String>()
    val isLoginEnabled = MediatorLiveData<Boolean>()

    val errorMLD = MutableLiveData<String>()
    val loginSuccessMLD = MutableLiveData<Boolean>()

    init {
        isLoginEnabled.addSource(emailMLD) {
            isLoginEnabled.postValue(isValidEmailAndPasswords())
        }
        isLoginEnabled.addSource(passwordMLD) {
            isLoginEnabled.postValue(isValidEmailAndPasswords())
        }
    }

    private fun isValidEmailAndPasswords(): Boolean {
        return EmailValidator.isValidEmail(emailMLD.value) && passwordMLD.value != null && passwordMLD.value?.length!! > 4
    }

    fun login() {
        if (emailMLD.value != null && passwordMLD.value != null) {
            viewModelScope.launch {
                val result = loginRepository.loginUser(emailMLD.value!!, passwordMLD.value!!)
                if (!result) {
                    errorMLD.postValue("user not found")
                }
                loginSuccessMLD.postValue(result)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        isLoginEnabled.removeSource(emailMLD)
        isLoginEnabled.removeSource(passwordMLD)
    }
}