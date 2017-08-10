package com.marco.android.sunshine.showDetails;

import android.database.Cursor;
import com.marco.android.sunshine.models.WeatherData;
import javax.inject.Inject;
import static com.marco.android.sunshine.showDetails.ShowDetailsActivity.*;

public class ShowDetailsPresenter implements ShowDetailsContract.Presenter {

    private ShowDetailsContract.View mView;

    @Inject
    ShowDetailsPresenter(ShowDetailsContract.View view) {
        mView = view;
    }

    @Inject
    void setupListeners() {
        mView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public WeatherData getWeatherData(Cursor data) {
        /*
         * Before we bind the data to the UI that will display that data, we need to check the
         * cursor to make sure we have the results that we are expecting. In order to do that, we
         * check to make sure the cursor is not null and then we call moveToFirst on the cursor.
         * Although it may not seem obvious at first, moveToFirst will return true if it contains
         * a valid first row of data.
         *
         * If we have valid data, we want to continue on to bind that data to the UI. If we don't
         * have any data to bind, we just return from this method.
         */
        boolean cursorHasValidData = false;
        if (data != null && data.moveToFirst()) {
            /* We have valid data, continue on to bind the data to the UI */
            cursorHasValidData = true;
        }

        if (!cursorHasValidData) {
            /* No data to display, simply return and do nothing */
            return null;
        }

        int weatherId = data.getInt(INDEX_WEATHER_CONDITION_ID);
        long localDateMidnightGmt = data.getLong(INDEX_WEATHER_DATE);
        double highInCelsius = data.getDouble(INDEX_WEATHER_MAX_TEMP);
        double lowInCelsius = data.getDouble(INDEX_WEATHER_MIN_TEMP);
        float humidity = data.getFloat(INDEX_WEATHER_HUMIDITY);
        float windSpeed = data.getFloat(INDEX_WEATHER_WIND_SPEED);
        float windDirection = data.getFloat(INDEX_WEATHER_DEGREES);
        float pressure = data.getFloat(INDEX_WEATHER_PRESSURE);


        return new WeatherData(weatherId, localDateMidnightGmt, highInCelsius, lowInCelsius, humidity, windSpeed, windDirection, pressure);
    }


}
