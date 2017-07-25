package com.example.android.sunshine;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by MarcoBarragan on 7/25/17.
 */

class WatchlistAdapter extends RecyclerView.Adapter<WatchlistAdapter.WatchlistAdapterViewHolder> {
    private Context mContext;
    private ArrayList<String> mLocations;

    public WatchlistAdapter(@NonNull Context context) {
        mContext = context;
    }

    public void setLocations(Set<String> locations){
        mLocations = new ArrayList<>();
        mLocations.addAll(locations);
    }

    @Override
    public WatchlistAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutId = R.layout.navigation_list_item;

        View view = LayoutInflater.from(mContext).inflate(layoutId, parent, false);

        view.setFocusable(true);

        return new WatchlistAdapter.WatchlistAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WatchlistAdapterViewHolder holder, int position) {
        holder.locationView.setText(mLocations.get(position));
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    /**
     * A ViewHolder is a required part of the pattern for RecyclerViews. It mostly behaves as
     * a cache of the child views for a forecast item. It's also a convenient place to set an
     * OnClickListener, since it has access to the adapter and the views.
     */
    class WatchlistAdapterViewHolder extends RecyclerView.ViewHolder {
        final TextView locationView;

        WatchlistAdapterViewHolder(View view) {
            super(view);

            locationView = (TextView) view.findViewById(R.id.navigation_rec_location);
        }
    }
}
