package com.marco.android.sunshine.addLocation;

import android.content.Context;

import com.marco.android.sunshine.BuildConfig;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

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