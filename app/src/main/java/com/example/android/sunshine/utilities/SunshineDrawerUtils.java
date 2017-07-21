package com.example.android.sunshine.utilities;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.preference.PreferenceManager;

import java.util.HashSet;
import java.util.Set;

public class SunshineDrawerUtils {

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static Set<String> getLocations(@NonNull final Context context){

        Set<String> defaultSet = new HashSet<>();

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        return sharedPreferences.getStringSet("watch_locations", defaultSet);
    }
}
