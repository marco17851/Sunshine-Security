package com.example.android.sunshine.addLocation;

import dagger.Module;
import dagger.Provides;

@Module
public class AddLocationPresenterModule {

    private final AddLocationContract.View mView;

    public AddLocationPresenterModule (AddLocationContract.View view){
        mView = view;
    }

    @Provides
    AddLocationContract.View getView(){
        return mView;
    }
}
