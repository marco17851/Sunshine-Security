package com.marco.android.sunshine.addLocation;

import com.marco.android.sunshine.BuildConfig;
import com.marco.android.sunshine.R;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
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