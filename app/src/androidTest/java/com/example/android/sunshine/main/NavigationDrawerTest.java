package com.example.android.sunshine.main;

import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.android.sunshine.MainActivity;
import com.example.android.sunshine.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class NavigationDrawerTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void shouldCloseDrawerWhenDrawerIsOpenAndUserPressesBackButton() {
        onView(ViewMatchers.withId(R.id.drawer_layout)).perform(DrawerActions.open());
        pressBack();
    }

    @Test
    public void shouldShowCitiesHeaderInNavigationDrawer(){
        onView(ViewMatchers.withId(R.id.drawer_layout)).perform(DrawerActions.open());
        onView(ViewMatchers.withId(R.id.navigation_header_title)).check(matches(withText("Cities")));
    }
}