package com.appmetry.androidpatterns.ui.login

import com.appmetry.androidpatterns.EspressoActions
import com.appmetry.androidpatterns.R

class LoginActivityActions : EspressoActions() {

    fun withEmail(email: String) {
        enterInput(R.id.email_et, email)
    }

    fun withPassword(password: String) {
        enterInput(R.id.password_et, password)
    }

    fun clickLogin() {
        clickView(R.id.login_btn)
    }

    fun isLoginButtonDisabled() {
        isViewDisabled(R.id.login_btn)
    }

    fun isLoginButtonEnabled() {
        isViewEnabled(R.id.login_btn)
    }
}