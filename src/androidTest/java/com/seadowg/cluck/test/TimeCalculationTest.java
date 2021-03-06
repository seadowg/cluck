package com.seadowg.cluck.test;

import androidx.test.rule.ActivityTestRule;

import com.seadowg.cluck.activity.TimerActivity;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class TimeCalculationTest {

    @Rule
    public ActivityTestRule<TimerActivity> activityRule = new ActivityTestRule<>(TimerActivity.class);

    @Test
    public void clickingCalculate_showsTimeToCook() {
        onView(withHint("1500")).perform(typeText("2500"), closeSoftKeyboard());
        onView(withText("Calculate")).perform(click());
        onView(withText("2:01")).check(matches(isDisplayed()));
    }

    @Test
    public void clickingCalculate_whenNoWeightEntered_showsPromptToEnterWeight() {
        onView(withText("Calculate")).perform(click());
        onView(withText("You need to set a weight!")).check(matches(isDisplayed()));
    }

    @Test
    public void clickingCalculate_andThenClickingReset_letsAnotherWeightBeEntered() {
        onView(withHint("1500")).perform(typeText("2500"), closeSoftKeyboard());
        onView(withText("Calculate")).perform(click());
        onView(withText("Reset")).perform(click());
        onView(withHint("1500")).perform(typeText("2500"), closeSoftKeyboard());
    }
}
