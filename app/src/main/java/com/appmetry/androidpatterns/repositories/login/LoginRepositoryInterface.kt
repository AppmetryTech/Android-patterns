package com.appmetry.androidpatterns.repositories.login

//Created by Appmetry
interface LoginRepositoryInterface {
    suspend fun loginUser(email: String, password: String): Boolean
}