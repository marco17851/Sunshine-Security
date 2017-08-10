package com.marco.android.sunshine.addLocation;

import android.content.Context;
import android.os.AsyncTask;

import com.marco.android.sunshine.sync.SunshineSyncTask;

import javax.inject.Inject;

public class AddLocationPresenter implements AddLocationContract.Presenter {

    private AddLocationContract.View mView;

    @Inject
    AddLocationPresenter(AddLocationContract.View view) {
        mView = view;
    }

    @Inject
    void setupListeners() {
        mView.setPresenter(this);
    }

    @Override
    public void fetchWeather(final Context context, final String locationInput) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                SunshineSyncTask.syncWatchListLocation(context, locationInput);
                return null;
            }
        }.execute();
    }

    @Override
    public boolean isInputValid(Context context, String locationInput) {
        String input = locationInput;
        input = input.trim();
        return !(input.length() == 0 || input.equals(""));
    }

    @Override
    public void start() {
    }

}
