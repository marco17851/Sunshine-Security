package com.marco.android.sunshine.showDetails;

import dagger.Module;
import dagger.Provides;

@Module
public class ShowDetailsPresenterModule {
    private final ShowDetailsContract.View mView;

    public ShowDetailsPresenterModule (ShowDetailsContract.View view){
        mView = view;
    }

    @Provides
    ShowDetailsContract.View getView(){
        return mView;
    }
}
