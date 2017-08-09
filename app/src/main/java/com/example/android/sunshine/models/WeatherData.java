package com.example.android.sunshine.models;

public class WeatherData {

    private final int weatherId;
    private final long localDateMidnightGmt;
    private final double highInCelsius;
    private final double lowInCelsius;
    private final float humidity;
    private final float windSpeed;
    private final float windDirection;
    private final float pressure;

    public WeatherData(int weatherId, long localDateMidnightGmt, double highInCelsius, double lowInCelsius, float humidity, float windSpeed, float windDirection, float pressure){

        this.weatherId = weatherId;
        this.localDateMidnightGmt = localDateMidnightGmt;
        this.highInCelsius = highInCelsius;
        this.lowInCelsius = lowInCelsius;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.pressure = pressure;
    }

    public long getLocalDateMidnightGmt() {
        return localDateMidnightGmt;
    }

    public int getWeatherId() {
        return weatherId;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public float getWindDirection() {
        return windDirection;
    }

    public float getPressure() {
        return pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public double getLowInCelsius() {
        return lowInCelsius;
    }

    public double getHighInCelsius() {
        return highInCelsius;
    }
}
