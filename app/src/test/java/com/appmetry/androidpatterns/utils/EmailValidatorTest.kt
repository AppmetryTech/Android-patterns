package com.appmetry.androidpatterns.utils

import org.junit.Assert
import org.junit.Test

class EmailValidatorTest {

    @Test
    fun `Test pass when if valid input`() {
        Assert.assertTrue(EmailValidator.isValidEmail("user@mail.com"))
    }

    @Test
    fun  `Test fails when if invalid input`(){
        Assert.assertFalse(EmailValidator.isValidEmail("usermail.com"))
    }
}