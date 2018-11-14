package com.gerosprime.gmoviedb.components.mvp;

import com.hannesdorfmann.mosby3.mvp.MvpFragment;

public abstract class MovieDBBaseFragment<View extends MovieDBMvpView,
            Presenter extends MovieDBMvpPresenter<View>>
    extends MvpFragment<View, Presenter> {
}
