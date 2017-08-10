package com.marco.android.sunshine.addLocation;

import android.content.Context;

import com.marco.android.sunshine.BasePresenter;
import com.marco.android.sunshine.BaseView;

public interface AddLocationContract {

    interface View extends BaseView<Presenter> {
        void showInvalidInputMessage();
    }

    interface Presenter extends BasePresenter {

        void fetchWeather(final Context context, String locationInput);

        boolean isInputValid(Context context, String locationInput);
    }
}
