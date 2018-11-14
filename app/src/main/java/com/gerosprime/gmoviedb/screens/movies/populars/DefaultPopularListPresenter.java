package com.gerosprime.gmoviedb.screens.movies.populars;

import com.gerosprime.gmoviedb.components.mvp.MovieDBBasePresenter;
import com.gerosprime.gmoviedb.components.rxjava.SchedulersComposer;
import com.gerosprime.gmoviedb.models.movies.populars.PopularMovieEntity;
import com.gerosprime.gmoviedb.models.movies.populars.PopularMoviesLoader;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;

public class DefaultPopularListPresenter
        extends MovieDBBasePresenter<PopularListView>
        implements PopularListPresenter {

    private final PopularMoviesLoader popularMoviesLoader;
    private final SchedulersComposer schedulersComposer;

    @Inject
    public DefaultPopularListPresenter(PopularMoviesLoader popularMoviesLoader,
                                       SchedulersComposer schedulersComposer) {
        this.popularMoviesLoader = popularMoviesLoader;
        this.schedulersComposer = schedulersComposer;
    }

    @Override
    public void loadPopulars() {
        ifViewAttached(view -> {

            view.hideContentError();
            view.hideContentList();
            view.showLoadingIndicator();
            Single<List<PopularMovieEntity>> listSingle =
                    popularMoviesLoader.loadPopularMovies(1);
                listSingle.compose(schedulersComposer.singleTransformer(Schedulers.io()))
                .subscribe(this::popularsLoaded, this::popularLoadError);

        });
    }

    private void popularsLoaded(List<PopularMovieEntity> movieEntities) {
        ifViewAttached(view -> {
            view.hideLoadingIndicator();
            view.showContentList();
            view.populatePopulars(movieEntities);
        });
    }

    private void popularLoadError(Throwable error) {

        ifViewAttached(view -> {

            view.hideContentList();
            view.hideLoadingIndicator();
            view.showContentError();
            if (error instanceof HttpException)
                view.loadingPopularApiError();
            else
                view.loadingPopularTechnicalError();
        });


    }

}
