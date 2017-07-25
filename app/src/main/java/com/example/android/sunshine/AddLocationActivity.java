package com.example.android.sunshine;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
                String location = mLocationInput.getText().toString();
                if (!location.equals("")){
                    SunshineDrawerUtils.startWatchingLocation(mContext, location);
                    finish();
                }
            }
        });
    }

}
