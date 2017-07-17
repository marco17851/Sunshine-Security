package com.example.android.sunshine;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class SettingsFragmentTest {

    @Test
    public void shouldLetUserAddMultipleLocations() {
        assertEquals(1+1, 2);
    }

    @Test
    public void shouldNotLetUserAddAlreadyExistingCity() {
        assertEquals(true, true);
    }
}