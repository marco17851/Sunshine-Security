package com.marco.android.sunshine.main;

import javax.inject.Inject;

public class MainPresenter implements MainContract.Presenter{

    private MainContract.View mView;

    @Inject
    MainPresenter(MainContract.View view){

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
