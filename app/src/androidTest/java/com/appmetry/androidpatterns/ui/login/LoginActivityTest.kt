package com.appmetry.androidpatterns.ui.login

import androidx.test.espresso.intent.Intents
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.appmetry.androidpatterns.BaseHiltTest
import com.appmetry.androidpatterns.ui.product.ProductActivity
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
class LoginActivityTest : BaseHiltTest() {

    @get:Rule(order = 1)
    val loginActivityRule = ActivityScenarioRule(LoginActivity::class.java)

    override fun startUp() {
        super.startUp()
        Intents.init()
    }

    override fun cleanUp() {
        super.cleanUp()
        Intents.release()
    }

    @Test
    fun validEmailPassword_buttonEnabled_navigatedToNextScreen() {
        val loginActivityActionBuilder = LoginActivityActions()
        loginActivityActionBuilder.withEmail("fakeuser@mail.com")
        loginActivityActionBuilder.withPassword("password")

        loginActivityActionBuilder.isLoginButtonEnabled()

        loginActivityActionBuilder.clickLogin()
        loginActivityActionBuilder.matchIntent(ProductActivity::class.java.name)
    }

    @Test
    fun unregisteredEmailPassword_buttonEnabled_errorDisplayed() {
        val loginActivityActionBuilder = LoginActivityActions()
        loginActivityActionBuilder.withEmail("unregistereduser@mail.com")
        loginActivityActionBuilder.withPassword("password")

        loginActivityActionBuilder.isLoginButtonEnabled()

        loginActivityActionBuilder.clickLogin()
        loginActivityActionBuilder.matchToast("user not found")
    }

    @Test
    fun noEmailPassword_buttonDisabled() {
        val loginActivityActionBuilder = LoginActivityActions()
        loginActivityActionBuilder.isLoginButtonDisabled()
    }

    @Test
    fun invalidEmailValidPassword_buttonDisabled() {
        val loginActivityActionBuilder = LoginActivityActions()
        loginActivityActionBuilder.withEmail("user@mail")
        loginActivityActionBuilder.withPassword("password")
        loginActivityActionBuilder.isLoginButtonDisabled()
    }

    @Test
    fun validEmailNoPassword_buttonDisabled() {
        val loginActivityActionBuilder = LoginActivityActions()
        loginActivityActionBuilder.withEmail("unregistereduser@mail.com")
        loginActivityActionBuilder.isLoginButtonDisabled()
    }

    @Test
    fun validEmailInvalidPassword_buttonDisabled() {
        val loginActivityActionBuilder = LoginActivityActions()
        loginActivityActionBuilder.withEmail("user@mail.com")
        loginActivityActionBuilder.withPassword("pass")
        loginActivityActionBuilder.isLoginButtonDisabled()
    }
}