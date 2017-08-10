package com.marco.android.sunshine.showDetails;

import android.database.Cursor;

import com.marco.android.sunshine.BasePresenter;
import com.marco.android.sunshine.BaseView;
import com.marco.android.sunshine.models.WeatherData;

public interface ShowDetailsContract {

    interface View extends BaseView<Presenter> {
    }

    interface Presenter extends BasePresenter {
        WeatherData getWeatherData(Cursor data);
    }
}
