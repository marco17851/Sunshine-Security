package com.example.android.sunshine.addLocation;

import android.app.Instrumentation;
import android.content.pm.InstrumentationInfo;

import com.example.android.sunshine.BuildConfig;
import com.example.android.sunshine.R;
import com.example.android.sunshine.SunshineApplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoRule;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.internal.bytecode.RobolectricInternals;
import org.robolectric.res.builder.RobolectricPackageManager;
import org.robolectric.shadow.api.Shadow;
import org.robolectric.shadows.ShadowHandler;
import org.robolectric.shadows.ShadowToast;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 25)
public class AddLocationActivityTest {
    @Test
    public void shouldShowInvalidInputMessage() throws Exception {
        AddLocationPresenter mockPresenter = Mockito.mock(AddLocationPresenter.class);

        AddLocationActivity activity = Robolectric.setupActivity(AddLocationActivity.class);

        activity.setPresenter(mockPresenter);

        activity.showInvalidInputMessage();

        String invalidMessage = activity.getResources().getString(R.string.invalid_input);

        assertThat( ShadowToast.getTextOfLatestToast(), equalTo(invalidMessage));

    }

}