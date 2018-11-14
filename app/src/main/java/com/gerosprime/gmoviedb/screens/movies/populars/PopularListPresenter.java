package com.gerosprime.gmoviedb.screens.movies.populars;

import com.gerosprime.gmoviedb.components.mvp.MovieDBMvpPresenter;

public interface PopularListPresenter
    extends MovieDBMvpPresenter<PopularListView> {

    void loadPopulars();

}
