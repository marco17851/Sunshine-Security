package com.example.android.sunshine;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android.sunshine.BuildConfig;
import com.example.android.sunshine.MainActivity;
import com.example.android.sunshine.R;
import com.example.android.sunshine.data.WeatherContract;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class DetailActivityTest {

    @Test
    public void onCreateShouldInflateTheMenu() {
        Intent intent = new Intent();
        intent.setData(Uri.EMPTY);
        DetailActivity dActivity = Robolectric.buildActivity(DetailActivity.class, intent).create().visible().get();

        Menu menu = Shadows.shadowOf(dActivity).getOptionsMenu();

        MenuItem item = menu.findItem(R.id.action_settings);
        assertEquals(item.getTitle().toString(), "Settings");
    }
}