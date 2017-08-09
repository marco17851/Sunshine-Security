package com.example.android.sunshine.showDetails;

import android.content.Context;

import com.example.android.sunshine.BasePresenter;
import com.example.android.sunshine.BaseView;

public interface ShowDetailsContract {

    interface View extends BaseView<Presenter> {
    }

    interface Presenter extends BasePresenter {

    }
}
