package com.marco.android.sunshine.showDetails;

import dagger.Component;

@Component(modules = ShowDetailsPresenterModule.class)
public interface ShowDetailsComponent {
    void inject(ShowDetailsActivity showDetailsActivity);
}
