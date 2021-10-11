package com.appmetry.androidpatterns.ui.login

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.appmetry.androidpatterns.getOrAwaitValue
import com.appmetry.androidpatterns.test.repositories.FakeLoginRepository
import org.junit.*

class LoginActivityViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var loginActivityViewModel: LoginActivityViewModel

    @Before
    fun before() {
        loginActivityViewModel = LoginActivityViewModel(FakeLoginRepository())
    }

    @After
    fun after() {
    }

    private fun setData(email: String, password: String) {
        loginActivityViewModel.emailMLD.value = email
        loginActivityViewModel.passwordMLD.value = password
    }

    @Test
    fun loginWithEmptyDetail() {
        setData("", "")
        Assert.assertFalse(loginActivityViewModel.isLoginEnabled.getOrAwaitValue())
    }

    @Test
    fun loginWithInvalidEmail() {
        setData("user@mail", "")
        Assert.assertFalse(loginActivityViewModel.isLoginEnabled.getOrAwaitValue())
    }

    @Test
    fun loginWithEmptyPassword() {
        setData("user@mail.com", "")
        Assert.assertFalse(loginActivityViewModel.isLoginEnabled.getOrAwaitValue())
    }

    @Test
    fun loginWithInvalidPassword() {
        setData("user@mail.com", "pass")
        Assert.assertFalse(loginActivityViewModel.isLoginEnabled.getOrAwaitValue())
    }

    @Test
    fun loginWithUnregisteredUser() {
        setData("unregistereduser@mail.com", "password")
        Assert.assertTrue(loginActivityViewModel.isLoginEnabled.getOrAwaitValue())
        loginActivityViewModel.login()
        val result = loginActivityViewModel.loginSuccessMLD.getOrAwaitValue()
        Assert.assertFalse(result)
        Assert.assertEquals("user not found", loginActivityViewModel.errorMLD.value)
    }

    @Test
    fun loginWithValidUser() {
        setData("fakeuser@mail.com", "password")
        Assert.assertTrue(loginActivityViewModel.isLoginEnabled.getOrAwaitValue())
        loginActivityViewModel.login()
        val result = loginActivityViewModel.loginSuccessMLD.getOrAwaitValue()
        Assert.assertTrue(result)
    }
}