package com.example.android.sunshine;


import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v7.preference.DialogPreference;
import android.support.v7.preference.EditTextPreference;
import android.util.AttributeSet;

import java.util.HashSet;
import java.util.Set;

public class WatchlistPreference extends DialogPreference {

    private Context mContext;
    private String mLocation;
    private int mDialogLayoutResId = R.layout.dialog_add_to_watchlist;


    private static final Set<String> DEFAULT_VALUE = new HashSet<>();

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public WatchlistPreference(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mContext = context;
    }

    public WatchlistPreference(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }

    public WatchlistPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public WatchlistPreference(Context context) {
        super(context);
        mContext = context;
    }

    public String getLocation() {
        return mLocation;
    }

//    @TargetApi(Build.VERSION_CODES.N)
//    public void setLocation(String location) {
//        mLocation = location;
//        // Save to Shared Preferences
//        Set<String> stringSet = getPersistedStringSet(DEFAULT_VALUE);
//        stringSet.add(mLocation);
//
//        persistStringSet(stringSet);
//    }

    @Override
    protected Object onGetDefaultValue(TypedArray a, int index) {
        return a.getString(index);
    }

//    @Override
//    protected void onSetInitialValue(boolean restorePersistedValue,
//                                     Object defaultValue) {
//        // Read the value. Use the default value if it is not possible.
//        setLocation((String) defaultValue);
//    }

    @Override
    public int getDialogLayoutResource() {
        return mDialogLayoutResId;
    }
}
