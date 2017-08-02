package com.example.android.sunshine.utilities;

import android.util.Log;

import com.example.android.sunshine.BuildConfig;

public class SunshineLogger {

    public static void log(int priority, String tag, String message){
        if (BuildConfig.DEBUG){
            switch(priority){
                case Log.DEBUG:
                    Log.d(tag, message);
                    break;

                case Log.ERROR:
                    Log.e(tag, message);
                    break;

                case Log.INFO:
                    Log.i(tag, message);
                    break;

                case Log.VERBOSE:
                    Log.v(tag, message);
                    break;

                case Log.WARN:
                    Log.w(tag, message);
                    break;

                default:
                    Log.v(tag, message);
                    break;
            }
        }
    }
}
