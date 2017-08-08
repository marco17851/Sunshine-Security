package com.example.android.sunshine;

import android.app.Application;
import android.content.Context;

import javax.inject.Inject;


public class SunshineApplication extends Application {

    public static SunshineApplication get(Context context) {
        return (SunshineApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

}
