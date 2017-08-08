package com.example.android.sunshine.addLocation;

import javax.inject.Inject;

public class AddLocationPresenter implements AddLocationContract.Presenter {

    private AddLocationContract.View mView;

    @Inject
    AddLocationPresenter(AddLocationContract.View view){
        mView = view;
    }

    @Inject
    void setupListeners() {
        mView.setPresenter(this);
    }

    @Override
    public void start() {

    }
}
