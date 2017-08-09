//package com.example.android.sunshine.main;
//
//import android.content.Intent;
//import android.content.pm.PackageManager;
//import android.content.pm.ResolveInfo;
//import android.content.pm.ServiceInfo;
//import android.net.Uri;
//import android.view.Menu;
//import android.view.MenuItem;
//
//import com.example.android.sunshine.BuildConfig;
//import com.example.android.sunshine.showDetails.ShowDetailsActivity;
//import com.example.android.sunshine.main.MainActivity;
//import com.example.android.sunshine.R;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.robolectric.Robolectric;
//import org.robolectric.RobolectricTestRunner;
//import org.robolectric.RuntimeEnvironment;
//import org.robolectric.Shadows;
//import org.robolectric.annotation.Config;
//
//import static org.junit.Assert.assertEquals;
//
//@RunWith(RobolectricTestRunner.class)
//@Config(constants = BuildConfig.class, sdk=23)
//public class NavigationDrawerTest {
//
//    @Test
//    public void onCreateShouldInflateTheMenu() {
//        MainActivity dActivity = Robolectric.buildActivity(MainActivity.class).create().visible().get();
//
//        Menu menu = Shadows.shadowOf(dActivity).getOptionsMenu();
//
//        MenuItem item = menu.findItem(R.id.action_settings);
//        assertEquals(item.getTitle().toString(), "Settings");
//    }
//}
