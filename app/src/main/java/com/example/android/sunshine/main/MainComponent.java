package com.example.android.sunshine.main;

import dagger.Component;


@Component(modules = MainPresenterModule.class)
public interface MainComponent {
    void inject(MainActivity mainActivity);
}