package com.example.android.sunshine;

import android.app.Application;
import android.database.Cursor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class WatchlistAdapterTest {

    private Application context;
    private WatchlistAdapter adapter;

    @Before
    public void setup(){
        context = RuntimeEnvironment.application;
        adapter = new WatchlistAdapter(context);
    }

    @Test
    public void shouldSetLocationsWhenGivenASet() {
        Set<String> locations = new TreeSet<>();
        locations.add("Paris, France");

        adapter.setLocations(locations);

        assertEquals(1, adapter.getItemCount());
    }

    @Test
    public void shouldDeleteLocationFromAdapterAndPreferencesAndReturnDeletedLocation(){
        Set<String> locations = new TreeSet<>();
        locations.add("Chicago, Illinois");
        locations.add("New York, New York");
        locations.add("Paris, France");
        locations.add("Seoul, South Korea");

        adapter.setLocations(locations);

        assertEquals(4, adapter.getItemCount());

        String deletedLocation = adapter.deleteLocation(0);

        assertEquals("Chicago, Illinois", deletedLocation);
        assertEquals(3, adapter.getItemCount());
    }

    @Test
    public void shouldSwapCursorAndClosePreviousOne(){
        Cursor firstCursor = mock(Cursor.class);
        adapter.swapCursor(firstCursor);

        Cursor newCursor = mock(Cursor.class);

        adapter.swapCursor(newCursor);
        verify(firstCursor).close();
    }
}
