package com.appmetry.androidpatterns

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matchers.not

open class EspressoActions {
    open fun enterInput(viewId: Int, input: String) {
        Espresso.onView(ViewMatchers.withId(viewId))
            .perform(ViewActions.typeText(input), ViewActions.closeSoftKeyboard())
    }

    open fun clickView(viewId: Int) {
        Espresso.onView(ViewMatchers.withId(viewId))
            .perform(ViewActions.click())
    }

    open fun matchToast(message: String) {
        Espresso.onView(ViewMatchers.withText(message)).inRoot(ToastMatcher())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    open fun matchIntent(className: String) {
        Intents.intended(IntentMatchers.hasComponent(className))
    }

    open fun isViewDisabled(viewId: Int) {
        Espresso.onView(ViewMatchers.withId(viewId))
            .check(ViewAssertions.matches(not(ViewMatchers.isEnabled())))
    }

    open fun isViewEnabled(viewId: Int) {
        Espresso.onView(ViewMatchers.withId(viewId))
            .check(ViewAssertions.matches(ViewMatchers.isEnabled()))
    }
}