package com.example.android.sunshine;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public final class SunshineApplicationModule {
    private final Context mContext;

    SunshineApplicationModule(Context context) {
        mContext = context;
    }

    @Provides
    Context provideContext() {
        return mContext;
    }
}
