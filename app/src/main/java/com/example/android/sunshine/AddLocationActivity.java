package com.example.android.sunshine;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.sunshine.sync.SunshineSyncTask;
import com.example.android.sunshine.utilities.SunshineDrawerUtils;

public class AddLocationActivity extends Activity {

    private EditText mLocationInput;
    private Button mSaveButton;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_location);

        mContext = getApplicationContext();

        mLocationInput = (EditText) findViewById(R.id.new_location_input);
        mSaveButton = (Button) findViewById(R.id.save_location);

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String location = mLocationInput.getText().toString();
                if (!location.equals("")){

                    AsyncTask<Void, Void, Void> mFetchWeatherTask = new AsyncTask<Void, Void, Void>() {
                        @Override
                        protected Void doInBackground(Void... voids) {
                            SunshineSyncTask.syncWatchListLocation(mContext, location);
                            return null;
                        }
                    };

                    mFetchWeatherTask.execute();
                    finish();
                }
            }
        });
    }

}
