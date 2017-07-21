package com.example.android.sunshine.main;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android.sunshine.BuildConfig;
import com.example.android.sunshine.DetailActivity;
import com.example.android.sunshine.MainActivity;
import com.example.android.sunshine.R;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class NavigationDrawerTest {

}
