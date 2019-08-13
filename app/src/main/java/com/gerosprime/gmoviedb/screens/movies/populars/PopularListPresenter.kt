package com.gerosprime.gmoviedb.screens.movies.populars

import com.gerosprime.gmoviedb.components.mvp.MovieDBMvpPresenter

interface PopularListPresenter : MovieDBMvpPresenter<PopularListView> {
    fun loadPopulars()
}