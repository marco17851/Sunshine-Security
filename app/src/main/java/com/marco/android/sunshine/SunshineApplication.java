package com.marco.android.sunshine;

import android.app.Application;
import android.content.Context;

public class SunshineApplication extends Application {

    public static SunshineApplication get(Context context) {
        return (SunshineApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

}
