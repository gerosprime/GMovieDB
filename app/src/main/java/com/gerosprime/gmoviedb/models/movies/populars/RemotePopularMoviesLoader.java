package com.gerosprime.gmoviedb.models.movies.populars;

import com.gerosprime.gmoviedb.components.retrofit.MovieDBApi;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Single;

public class RemotePopularMoviesLoader
    implements PopularMoviesLoader {

    private final MovieDBApi movieDBApi;
    private final String authToken;

    @Inject
    public RemotePopularMoviesLoader(MovieDBApi movieDBApi,
                                     @Named("movieDBAuthToken") String authToken) {
        this.movieDBApi = movieDBApi;
        this.authToken = authToken;
    }

    @Override
    public Single<List<PopularMovieEntity>> loadPopularMovies(Integer page) {
        return movieDBApi.use(PopularMovieRetrofit.class)
                .loadPopulars(authToken, page)
                .flatMap(popularMovieResponse ->
                        Single.fromCallable(() ->
                                popularMovieResponse.getPopularMovieEntities()));
    }
}
