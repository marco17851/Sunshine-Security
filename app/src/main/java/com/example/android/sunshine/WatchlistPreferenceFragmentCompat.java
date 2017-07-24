package com.example.android.sunshine;

import android.os.Bundle;
import android.support.v7.preference.DialogPreference;
import android.support.v7.preference.PreferenceDialogFragmentCompat;
import android.view.View;
import android.widget.EditText;

public class WatchlistPreferenceFragmentCompat extends PreferenceDialogFragmentCompat {

//    private EditText mUserInput;

    public static WatchlistPreferenceFragmentCompat newInstance(
            String key) {
        final WatchlistPreferenceFragmentCompat
                fragment = new WatchlistPreferenceFragmentCompat();
        final Bundle b = new Bundle(1);
        b.putString(ARG_KEY, key);
        fragment.setArguments(b);

        return fragment;
    }

    @Override
    protected void onBindDialogView(View view) {
        super.onBindDialogView(view);

//        mUserInput = view.findViewById(R.id.edit);
//
//        // Exception when there is no TimePicker
//        if (mUserInput == null) {
//            throw new IllegalStateException("Dialog is missing an EditText view");
//        }

        String input = "";
        DialogPreference preference = getPreference();
        if (preference instanceof WatchlistPreference) {
            input = ((WatchlistPreference) preference).getLocation();
        }

        // Set the time to the TimePicker
//        if (input != null && !input.equals("")) {
//            mUserInput.setText(input);
//        }
    }

    @Override
    public void onDialogClosed(boolean positiveResult) {
//        if (positiveResult) {
//            String location = mUserInput.getText().toString();
//
//            // Get the related Preference and save the value
//            DialogPreference preference = getPreference();
//            if (preference instanceof WatchlistPreference) {
//                WatchlistPreference watchlistPreference =
//                        ((WatchlistPreference) preference);
//                // This allows the client to ignore the user value.
//
//                watchlistPreference.setLocation(location);
//            }
//        }
    }
}
