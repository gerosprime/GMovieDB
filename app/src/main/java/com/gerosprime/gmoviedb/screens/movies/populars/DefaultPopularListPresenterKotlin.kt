package com.gerosprime.gmoviedb.screens.movies.populars

import com.gerosprime.gmoviedb.components.mvp.MovieDBBasePresenter
import com.gerosprime.gmoviedb.components.rxjava.SchedulersComposer
import com.gerosprime.gmoviedb.models.movies.populars.PopularMovieEntity
import com.gerosprime.gmoviedb.models.movies.populars.PopularMoviesLoader
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import javax.inject.Inject

class DefaultPopularListPresenterKotlin

    @Inject
    constructor(private val popularMoviesLoader : PopularMoviesLoader,
                private val schedulersComposer: SchedulersComposer)

     : MovieDBBasePresenter<PopularListView>(), PopularListPresenter {

    override fun loadPopulars() {
        ifViewAttached { view ->
            run {

                view.hideContentError()
                view.hideContentList()
                view.showLoadingIndicator()
                popularMoviesLoader.loadPopularMovies(1)
                        .compose(schedulersComposer.singleTransformer(Schedulers.io()))
                        .subscribe(this::popularsLoaded, this::popularsLoadError)

            }
        }
    }

    private fun popularsLoaded(popularList : List<PopularMovieEntity>) {
        ifViewAttached {
            run {

                it.showContentList()
                it.hideLoadingIndicator()
                it.populatePopulars(popularList)

            }
        }
    }

    private fun popularsLoadError(error : Throwable) {
        ifViewAttached {
            run {
                it.showContentError()
                it.hideLoadingIndicator()

                if (error is HttpException)
                    it.loadingPopularApiError()
                else
                    it.loadingPopularTechnicalError()
            }
        }
    }

}