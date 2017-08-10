package com.marco.android.sunshine.addLocation;


import dagger.Component;

@Component(modules = AddLocationPresenterModule.class)
public interface AddLocationComponent {
    void inject(AddLocationActivity addLocationActivity);
}
