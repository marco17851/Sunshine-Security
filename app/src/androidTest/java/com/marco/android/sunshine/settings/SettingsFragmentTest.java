package com.marco.android.sunshine.settings;

import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.app.FragmentTransaction;

import com.marco.android.sunshine.R;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import tools.fastlane.screengrab.Screengrab;
import tools.fastlane.screengrab.UiAutomatorScreenshotStrategy;
import tools.fastlane.screengrab.locale.LocaleTestRule;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.PreferenceMatchers.withKey;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertEquals;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.AllOf.allOf;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class SettingsFragmentTest {

    @Rule
    public ActivityTestRule<SettingsActivity> mActivityRule = new ActivityTestRule<>(
            SettingsActivity.class);

    @ClassRule
    public static final LocaleTestRule localeTestRule = new LocaleTestRule();

    @Test
    public void preferredLocationShouldBeVisibleOnDisplay(){
        mActivityRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                SettingsFragment settingsFragment = startSettingsFragment();
            }
        });
        Screengrab.setDefaultScreenshotStrategy(new UiAutomatorScreenshotStrategy());
        Screengrab.screenshot("settings");

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
