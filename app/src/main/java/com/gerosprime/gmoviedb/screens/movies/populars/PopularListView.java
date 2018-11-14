package com.gerosprime.gmoviedb.screens.movies.populars;

import com.gerosprime.gmoviedb.components.mvp.MovieDBMvpView;
import com.gerosprime.gmoviedb.models.movies.populars.PopularMovieEntity;

import java.util.List;

public interface PopularListView
    extends MovieDBMvpView {

    void populatePopulars(List<PopularMovieEntity> movieEntities);
    void hideContentList();
    void showContentList();

    void hideLoadingIndicator();
    void showLoadingIndicator();

    void showContentError();
    void hideContentError();
    void loadingPopularApiError();
    void loadingPopularTechnicalError();

}
