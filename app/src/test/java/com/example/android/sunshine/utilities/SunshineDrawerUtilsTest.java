package com.example.android.sunshine.utilities;

import android.content.SharedPreferences;
import android.support.v7.preference.PreferenceManager;

import com.example.android.sunshine.BuildConfig;
import com.example.android.sunshine.R;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class SunshineDrawerUtilsTest {

    @Test
    public void shouldReturnAnEmptyListOfLocationsWhenTheUserHasNotSetAnyToBeWatched(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(RuntimeEnvironment.application);
        String key = RuntimeEnvironment.application.getResources().getString(R.string.pref_watch_locations_key);
        sharedPreferences.edit().remove(key).apply();

        Set<String> locations = SunshineDrawerUtils.getLocations(RuntimeEnvironment.application);

        assertThat(locations.size(), is(0));
    }

    @Test
    public void shouldReturnCorrectListOfLocations(){
        Set<String> correctLocations = new HashSet<>();
        correctLocations.add("New York, New York");
        correctLocations.add("Paris, France");
        correctLocations.add("Seoul, South Korea");

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(RuntimeEnvironment.application);
        preferences.edit().putStringSet("watch_list", correctLocations).commit();

        Set<String> retrievedLocations = SunshineDrawerUtils.getLocations(RuntimeEnvironment.application);

        assertThat(retrievedLocations, is(correctLocations));
    }

}