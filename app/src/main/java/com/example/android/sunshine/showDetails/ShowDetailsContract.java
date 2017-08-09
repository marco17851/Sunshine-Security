package com.example.android.sunshine.showDetails;

import android.content.Context;
import android.database.Cursor;

import com.example.android.sunshine.BasePresenter;
import com.example.android.sunshine.BaseView;
import com.example.android.sunshine.models.WeatherData;

public interface ShowDetailsContract {

    interface View extends BaseView<Presenter> {
    }

    interface Presenter extends BasePresenter {
        WeatherData getWeatherData(Cursor data);
    }
}
