package com.marco.android.sunshine.main;

import com.marco.android.sunshine.BasePresenter;
import com.marco.android.sunshine.BaseView;

public interface MainContract {
    interface View extends BaseView<Presenter> {
    }

    interface Presenter extends BasePresenter {
    }
}
