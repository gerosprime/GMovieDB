package com.gerosprime.gmoviedb.models.movies.populars;

import java.util.List;

import io.reactivex.Single;

public interface PopularMoviesLoader {
    Single<List<PopularMovieEntity>> loadPopularMovies(Integer page);
}
