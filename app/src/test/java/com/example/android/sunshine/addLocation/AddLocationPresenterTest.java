package com.example.android.sunshine.addLocation;

import android.content.Context;
import android.widget.EditText;

import com.example.android.sunshine.BuildConfig;
import com.example.android.sunshine.DetailActivity;
import com.example.android.sunshine.sync.SunshineSyncTask;
import com.example.android.sunshine.utilities.SunshineDrawerUtils;
import com.example.android.sunshine.utilities.SunshineWeatherUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyChar;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 25)
public class AddLocationPresenterTest {

    AddLocationContract.View view;
    Context context;

    AddLocationPresenter presenter;

    @Before
    public void setup(){
        context = Mockito.mock(Context.class);
        view = Mockito.mock(AddLocationContract.View.class);
        presenter = new AddLocationPresenter(view);
    }

    @Test
    public void shouldReturnFalseGivenInvalidInput() throws Exception {
        assertFalse(presenter.isInputValid(context, ""));
    }

    @Test
    public void shouldReturnTrueGivenValidInput() throws Exception {
        assertTrue(presenter.isInputValid(context, "New York, New York"));
    }

}