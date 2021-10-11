package com.appmetry.androidpatterns

import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.After
import org.junit.Before
import org.junit.Rule

@HiltAndroidTest
open class BaseHiltTest {

    @get:Rule(order = 0)
    val hiltAndroidRule = HiltAndroidRule(this)

    @Before
    open fun startUp() {
        hiltAndroidRule.inject()
    }

    @After
    open fun cleanUp() {
    }
}