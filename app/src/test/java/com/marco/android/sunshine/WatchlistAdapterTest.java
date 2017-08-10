package com.marco.android.sunshine;

import android.app.Application;
import android.database.Cursor;

import com.marco.android.sunshine.adapters.WatchlistAdapter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 25)
public class WatchlistAdapterTest {

    private Application context;
    private WatchlistAdapter adapter;

    @Before
    public void setup(){
        context = RuntimeEnvironment.application;
        adapter = new WatchlistAdapter(context);
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
