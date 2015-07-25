package com.seadowg.cluck.test;

import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;
import com.seadowg.cluck.activity.TimerActivity;


import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@LargeTest
public class TimeCalculationTest {

    @Rule
    public ActivityTestRule<TimerActivity> activityRule = new ActivityTestRule<>(TimerActivity.class);

    @Test
    public void calculatesTimeToCookChickenBasedOnWeight() throws Exception {
        onView(withHint("1500")).perform(typeText("2500"), closeSoftKeyboard());
        Thread.sleep(500);

        onView(withText("Calculate")).perform(click());
        onView(withText("2:01")).check(matches(isDisplayed()));
    }
}
