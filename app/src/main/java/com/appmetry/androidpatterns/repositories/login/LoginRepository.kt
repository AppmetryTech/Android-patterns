package com.appmetry.androidpatterns.repositories.login

import kotlinx.coroutines.delay
//Created by Appmetry

class LoginRepository : LoginRepositoryInterface {
    override suspend fun loginUser(email: String, password: String): Boolean {
        delay(1000)
        return email == "user@mail.com" && password == "password"
    }
}