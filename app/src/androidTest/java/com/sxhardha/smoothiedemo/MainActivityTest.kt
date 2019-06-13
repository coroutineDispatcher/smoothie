package com.sxhardha.smoothiedemo

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.sxhardha.smoothie.Smoothie
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.junit.Rule
import org.junit.Test


@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var activityActivityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(Smoothie.countingIdlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(Smoothie.countingIdlingResource)
        print("Finished testing")
    }

    @Test
    fun failingTest() {
        onView(withId(R.id.btnSmoothie)).perform(click())
        onView(withId(R.id.tvSmoothie)).check(matches(withText("HELLO SMOOTHIE!")))
    }
}