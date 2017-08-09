package com.example.android.sunshine.main;

import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.espresso.contrib.DrawerMatchers;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.android.sunshine.R;
import com.example.android.sunshine.data.WatchlistContract;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;


@RunWith(AndroidJUnit4.class)
public class NavigationDrawerTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    private String fakeCity = "Fake City, Fakeland";

    @Before
    public void setup(){
        onView(ViewMatchers.withId(R.id.drawer_layout)).perform(DrawerActions.open());
    }

    @After
    public void cleanup(){
        clearDatabaseTable();
    }

    @Test
    public void shouldCloseDrawerWhenDrawerIsOpenAndUserPressesBackButton() {
        pressBack();
        onView(ViewMatchers.withId(R.id.drawer_layout)).check(matches(DrawerMatchers.isClosed()));
    }

    @Test
    public void shouldShowCorrectHeaderInNavigationDrawer(){
        onView(ViewMatchers.withId(R.id.navigation_header_title)).check(matches(withText(R.string.header_title)));
        onView(ViewMatchers.withId(R.id.navigation_header_description)).check(matches(withText(R.string.header_description)));
    }

    @Test
    public void shouldTellUserTheyHaveNotYetAddedAnyLocationsToTheirWatchlistIfWatchlistIsEmpty(){
        onView(ViewMatchers.withId(R.id.navigation_body_text)).check(matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(ViewMatchers.withId(R.id.navigation_recycler_view)).check(matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
        onView(ViewMatchers.withId(R.id.navigation_body_text)).check(matches(withText(R.string.drawer_body_empty)));
    }

    @Test
    public void watchlistShouldShowLocationAndWeatherDetailsAfterAddedThroughFAB(){


        onView(ViewMatchers.withId(R.id.navigation_drawer_fab)).perform(click());
        onView(ViewMatchers.withId(R.id.new_location_input)).perform(typeText(fakeCity)).perform(closeSoftKeyboard());
        onView(ViewMatchers.withId(R.id.save_location)).perform(click());

        onView(ViewMatchers.withId(R.id.location))
                .check(matches(withText(fakeCity)))
                .check(matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(allOf(ViewMatchers.withId(R.id.high_temperature), withParent(withId(R.id.navigation_list_item))))
                .check(matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(allOf(ViewMatchers.withId(R.id.low_temperature), withParent(withId(R.id.navigation_list_item))))
                .check(matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(allOf(ViewMatchers.withId(R.id.weather_description), withParent(withId(R.id.navigation_list_item))))
                .check(matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(allOf(ViewMatchers.withId(R.id.weather_icon), withParent(withId(R.id.navigation_list_item))))
                .check(matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }
    
    @Test
    public void shouldBeAbleToDeleteLocationOnRightSwipe(){
        onView(ViewMatchers.withId(R.id.navigation_drawer_fab)).perform(click());
        onView(ViewMatchers.withId(R.id.new_location_input)).perform(typeText(fakeCity)).perform(closeSoftKeyboard());
        onView(ViewMatchers.withId(R.id.save_location)).perform(click());

        onView(ViewMatchers.withId(R.id.location))
                .check(matches(withText(fakeCity)))
                .check(matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));

        onView(withId(R.id.location))
                .perform(swipeRight());
        onView(ViewMatchers.withId(R.id.navigation_body_text)).check(matches(withText(R.string.drawer_body_empty)));
    }

    @Test
    public void shouldShowMultipleCitiesInNavigationDrawer(){
        onView(ViewMatchers.withId(R.id.navigation_drawer_fab)).perform(click());
        onView(ViewMatchers.withId(R.id.new_location_input)).perform(typeText(fakeCity)).perform(closeSoftKeyboard());
        onView(ViewMatchers.withId(R.id.save_location)).perform(click());

        String otherCity = "Other City, Fakeland";

        onView(ViewMatchers.withId(R.id.navigation_drawer_fab)).perform(click());
        onView(ViewMatchers.withId(R.id.new_location_input)).perform(typeText(otherCity)).perform(closeSoftKeyboard());
        onView(ViewMatchers.withId(R.id.save_location)).perform(click());

        onView(withId(R.id.navigation_recycler_view))
                .check(matches(hasDescendant(withText(fakeCity))))
                .check(matches(hasDescendant(withText(otherCity))));
    }

    private void clearDatabaseTable() {
        activityRule.getActivity().getApplicationContext().getContentResolver()
                .delete(WatchlistContract.WatchlistEntry.CONTENT_URI, null, null);
    }

}
