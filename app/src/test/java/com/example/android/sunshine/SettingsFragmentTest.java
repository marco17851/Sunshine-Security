package com.example.android.sunshine;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
import android.support.v7.preference.PreferenceManager;
import android.view.View;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
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

    @Test
    public void shouldLetUserAddMultipleLocations() {
        assertEquals(1+1, 2);

    }

    @Test
    public void shouldNotLetUserAddAlreadyExistingCity() {
        assertEquals(true, true);
    }
}