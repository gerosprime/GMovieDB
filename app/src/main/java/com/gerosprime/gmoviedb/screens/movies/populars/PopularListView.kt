package com.gerosprime.gmoviedb.screens.movies.populars

import com.gerosprime.gmoviedb.components.mvp.MovieDBMvpView
import com.gerosprime.gmoviedb.models.movies.populars.PopularMovieEntity

interface PopularListView : MovieDBMvpView {

    fun populatePopulars(movieEntities: List<PopularMovieEntity>)

    fun hideContentList()
    fun showContentList()

    fun hideLoadingIndicator()
    fun showLoadingIndicator()

    fun showContentError()
    fun hideContentError()

    fun loadingPopularApiError()
    fun loadingPopularTechnicalError()

}