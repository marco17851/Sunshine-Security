package com.example.android.sunshine.settings;

import android.support.test.espresso.DataInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.util.Log;

import com.example.android.sunshine.main.MainActivity;
import com.example.android.sunshine.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.R.id.title;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.PreferenceMatchers.withKey;
import static android.support.test.espresso.matcher.PreferenceMatchers.withSummary;
import static android.support.test.espresso.matcher.PreferenceMatchers.withTitle;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertEquals;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.AllOf.allOf;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class SettingsFragmentTest {

    @Rule
    public ActivityTestRule<SettingsActivity> mActivityRule = new ActivityTestRule<>(
            SettingsActivity.class);

    @Test
    public void preferredLocationShouldBeVisibleOnDisplay(){
        mActivityRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                SettingsFragment settingsFragment = startSettingsFragment();
            }
        });

        onView(withId(R.id.weather_settings_fragment))
                .check(matches(isCompletelyDisplayed()))
                .check(matches(hasDescendant(withText("Location"))))
                .check(matches(hasDescendant(withText("Temperature Units"))))
                .check(matches(hasDescendant(withText("Weather Notifications"))));
    }

    private SettingsFragment startSettingsFragment(){
        SettingsActivity activity = mActivityRule.getActivity();
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        SettingsFragment settingsFragment = new SettingsFragment();

        transaction.replace(R.id.weather_settings_fragment, settingsFragment, "settingsFragment");
        transaction.commit();

        return settingsFragment;
    }

}
