package com.marco.android.sunshine.addLocation;

import android.content.Context;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.marco.android.sunshine.R;

import javax.inject.Inject;

import static dagger.internal.Preconditions.checkNotNull;

public class AddLocationActivity extends Activity implements AddLocationContract.View{

    @Inject
    AddLocationPresenter mPresenter;

    private EditText mLocationInput;
    private Button mSaveButton;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_location);

        mContext = getApplicationContext();

        DaggerAddLocationComponent.builder()
                .addLocationPresenterModule(new AddLocationPresenterModule(this))
                .build()
                .inject(this);

        mLocationInput = (EditText) findViewById(R.id.new_location_input);
        mSaveButton = (Button) findViewById(R.id.save_location);

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mPresenter.isInputValid(mContext, mLocationInput.getText().toString())){
                    mPresenter.fetchWeather(mContext, mLocationInput.getText().toString());
                    finish();
                } else {
                    showInvalidInputMessage();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void setPresenter(AddLocationContract.Presenter presenter) {
        mPresenter = (AddLocationPresenter) checkNotNull(presenter);
    }

    @Override
    public void showInvalidInputMessage() {
        Toast.makeText(this, getString(R.string.invalid_input), Toast.LENGTH_SHORT).show();
    }
}
