package com.appmetry.androidpatterns.repositories.login

import com.appmetry.androidpatterns.test.repositories.FakeLoginRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LoginRepositoryTest {
    val fakeLoginRepository = FakeLoginRepository()

    @Test
    fun `login with invalid inputs`() = runBlocking {
        assertFalse(fakeLoginRepository.loginUser("invalid@mail.com", "password"))
    }

    @Test
    fun `login with valid inputs`() = runBlocking {
        assertTrue(fakeLoginRepository.loginUser("fakeuser@mail.com", "pass"))
    }
}