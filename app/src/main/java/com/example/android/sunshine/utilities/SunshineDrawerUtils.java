package com.example.android.sunshine.utilities;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.preference.PreferenceManager;
import android.util.Log;

import java.util.HashSet;
import java.util.Set;

public class SunshineDrawerUtils {

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static Set<String> getLocations(@NonNull final Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        return sharedPreferences.getStringSet("watch_locations", new HashSet<String>());
    }

    public static void startWatchingLocation(@NonNull final Context context, String location) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        Set<String> locations = sharedPreferences.getStringSet("watch_locations", new HashSet<String>());
        locations.add(location);

        sharedPreferences.edit().putStringSet("watch_locations", locations).apply();
    }

    public static void removeLocation(@NonNull final Context context, String location) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        Set<String> locations = sharedPreferences.getStringSet("watch_locations", new HashSet<String>());
        if (locations.contains(location)){
            locations.remove(location);
        }

        sharedPreferences.edit().putStringSet("watch_locations", locations).apply();
    }
}
