package com.example.android.sunshine.main;

import com.example.android.sunshine.BasePresenter;
import com.example.android.sunshine.BaseView;

public interface MainContract {
    interface View extends BaseView<Presenter> {
    }

    interface Presenter extends BasePresenter {
    }
}
