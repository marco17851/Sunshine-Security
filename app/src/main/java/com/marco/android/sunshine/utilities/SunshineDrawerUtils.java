package com.marco.android.sunshine.utilities;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.preference.PreferenceManager;
import android.widget.Toast;

import java.util.Set;
import java.util.TreeSet;

public class SunshineDrawerUtils {

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static Set<String> getLocations(@NonNull final Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        Set<String> watched_locations = sharedPreferences.getStringSet("watch_locations", new TreeSet<String>());

        return watched_locations;
    }

    public static void startWatchingLocation(@NonNull final Context context, String location) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        Set<String> locations = sharedPreferences.getStringSet("watch_locations", new TreeSet<String>());
        locations.add(location);

        sharedPreferences.edit().putStringSet("watch_locations", locations).apply();
    }

    public static void removeLocation(@NonNull final Context context, String location) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        Set<String> locations = sharedPreferences.getStringSet("watch_locations", new TreeSet<String>());
        if (locations.contains(location)){
            locations.remove(location);
        }

        sharedPreferences.edit().putStringSet("watch_locations", locations).apply();
    }

    public static void toastLocations(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        Set<String> locations = sharedPreferences.getStringSet("watch_locations", new TreeSet<String>());

        Toast.makeText(context, locations.toString(), Toast.LENGTH_LONG).show();
    }
}
