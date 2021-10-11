package com.appmetry.androidpatterns.utils

import androidx.core.util.PatternsCompat

object EmailValidator {
    fun isValidEmail(email: String?): Boolean {
        if (email.isNullOrEmpty()) {
            return false
        }
        return PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()
    }
}