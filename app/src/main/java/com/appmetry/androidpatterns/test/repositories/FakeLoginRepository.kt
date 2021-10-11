package com.appmetry.androidpatterns.test.repositories

import com.appmetry.androidpatterns.repositories.login.LoginRepositoryInterface

//Created by Appmetry
class FakeLoginRepository : LoginRepositoryInterface {
    override suspend fun loginUser(email: String, password: String): Boolean {
        return email == "fakeuser@mail.com" && password == "password"
    }
}