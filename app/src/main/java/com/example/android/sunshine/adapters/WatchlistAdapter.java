package com.example.android.sunshine.adapters;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.sunshine.MainActivity;
import com.example.android.sunshine.R;
import com.example.android.sunshine.data.WatchlistContract;
import com.example.android.sunshine.utilities.SunshineWeatherUtils;

/**
 * Created by MarcoBarragan on 7/25/17.
 */

public class WatchlistAdapter extends RecyclerView.Adapter<WatchlistAdapter.WatchlistAdapterViewHolder> {
    private Context mContext;
    private Cursor mCursor;

    public WatchlistAdapter(@NonNull Context context) {
        mContext = context;
    }

    @Override
    public WatchlistAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutId = R.layout.navigation_list_item;

        View view = LayoutInflater.from(mContext).inflate(layoutId, parent, false);

        view.setFocusable(true);

        return new WatchlistAdapter.WatchlistAdapterViewHolder(view);
    }

    public void swapCursor(Cursor newCursor) {
        if (mCursor != null){
            mCursor.close();
        }

        mCursor = newCursor;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(WatchlistAdapterViewHolder holder, int position) {
        if (mCursor == null || mCursor.getCount() == 0){
            return;
        }
        mCursor.moveToPosition(position);

        holder.locationView.setText(mCursor.getString(MainActivity.INDEX_WATCHLIST_LOCATION));

        int weatherId = mCursor.getInt(MainActivity.INDEX_WEATHER_CONDITION_ID);
        int weatherImageId;

        weatherImageId = SunshineWeatherUtils.getSmallArtResourceIdForWeatherCondition(weatherId);

        holder.iconView.setImageResource(weatherImageId);


        /***********************
         * Weather Description *
         ***********************/
        String description = SunshineWeatherUtils.getStringForWeatherCondition(mContext, weatherId);
         /* Create the accessibility (a11y) String from the weather description */
        String descriptionA11y = mContext.getString(R.string.a11y_forecast, description);

         /* Set the text and content description (for accessibility purposes) */
        holder.descriptionView.setText(description);
        holder.descriptionView.setContentDescription(descriptionA11y);

        /**************************
         * High (max) temperature *
         **************************/
         /* Read high temperature from the cursor (in degrees celsius) */
        double highInCelsius = mCursor.getDouble(MainActivity.INDEX_WEATHER_MAX_TEMP);
         /*
          * If the user's preference for weather is fahrenheit, formatTemperature will convert
          * the temperature. This method will also append either °C or °F to the temperature
          * String.
          */
        String highString = SunshineWeatherUtils.formatTemperature(mContext, highInCelsius);
         /* Create the accessibility (a11y) String from the weather description */
        String highA11y = mContext.getString(R.string.a11y_high_temp, highString);

         /* Set the text and content description (for accessibility purposes) */
        holder.highTempView.setText(highString);
        holder.highTempView.setContentDescription(highA11y);

        /*************************
         * Low (min) temperature *
         *************************/
         /* Read low temperature from the cursor (in degrees celsius) */
        double lowInCelsius = mCursor.getDouble(MainActivity.INDEX_WEATHER_MIN_TEMP);
         /*
          * If the user's preference for weather is fahrenheit, formatTemperature will convert
          * the temperature. This method will also append either °C or °F to the temperature
          * String.
          */
        String lowString = SunshineWeatherUtils.formatTemperature(mContext, lowInCelsius);
        String lowA11y = mContext.getString(R.string.a11y_low_temp, lowString);

         /* Set the text and content description (for accessibility purposes) */
        holder.lowTempView.setText(lowString);
        holder.lowTempView.setContentDescription(lowA11y);
    }

    @Override
    public int getItemCount() {
        if (mCursor == null){
            return 0;
        }
        return mCursor.getCount();
    }

    public void deleteLocation(String location) {
        ContentResolver resolver = mContext.getContentResolver();

        resolver.delete(WatchlistContract.WatchlistEntry.CONTENT_URI.buildUpon().appendPath(location).build(),
                null,
                null);
        notifyDataSetChanged();

    }

    /**
     * A ViewHolder is a required part of the pattern for RecyclerViews. It mostly behaves as
     * a cache of the child views for a forecast item. It's also a convenient place to set an
     * OnClickListener, since it has access to the adapter and the views.
     */
    class WatchlistAdapterViewHolder extends RecyclerView.ViewHolder {
        final ImageView iconView;

        final TextView locationView;
        final TextView descriptionView;
        final TextView highTempView;
        final TextView lowTempView;

        WatchlistAdapterViewHolder(View view) {
            super(view);

            iconView = (ImageView) view.findViewById(R.id.weather_icon);
            locationView = (TextView) view.findViewById(R.id.location);
            descriptionView = (TextView) view.findViewById(R.id.weather_description);
            highTempView = (TextView) view.findViewById(R.id.high_temperature);
            lowTempView = (TextView) view.findViewById(R.id.low_temperature);
        }
    }
}
