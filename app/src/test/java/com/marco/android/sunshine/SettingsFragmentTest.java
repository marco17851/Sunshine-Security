package com.marco.android.sunshine;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v7.preference.PreferenceManager;

import com.marco.android.sunshine.settings.SettingsActivity;
import com.marco.android.sunshine.settings.SettingsFragment;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil;

import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 25)
public class SettingsFragmentTest {

    SettingsFragment fragment;
    Context applicationContext;
    SharedPreferences sharedPreferences;

    @Before
    public void setUp(){
        fragment = new SettingsFragment();

        applicationContext = RuntimeEnvironment.application.getApplicationContext();

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
    }

    @Test
    public void shouldLetUserChangeLocation() {
        sharedPreferences.edit().putString("location", "Paris, France").apply();

        assertEquals("Paris, France", this.sharedPreferences.getString("location", ""));
    }

    @Test
    public void preferencesFragmentShouldShowDefaultNotificationsValue() {
        SupportFragmentTestUtil.startFragment(fragment, SettingsActivity.class);

        assertEquals(true, sharedPreferences.getBoolean("enable_notifications", false));
    }

    @Test
    public void userShouldBeAbleToPreventNotifications() {
        sharedPreferences.edit().putBoolean("enable_notifications", false).apply();
        SupportFragmentTestUtil.startFragment(fragment, SettingsActivity.class);

        assertEquals(false, sharedPreferences.getBoolean("enable_notifications", true));
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Test
    public void shouldLetUserAddMultipleLocationsToWatch() {
        Set<String> locations = new TreeSet<>();
        locations.add("New York, New York");
        locations.add("Paris, France");
        locations.add("Seoul, South Korea");
        sharedPreferences.edit().putStringSet("watch_locations", locations).apply();

        assertEquals(sharedPreferences.getStringSet("watch_locations", null), locations);
    }
}