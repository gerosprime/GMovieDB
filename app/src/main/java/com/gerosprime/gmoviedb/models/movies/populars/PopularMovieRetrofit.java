package com.gerosprime.gmoviedb.models.movies.populars;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PopularMovieRetrofit {

    @GET("movie/popular")
    Single<PopularMovieResponse>
        loadPopulars(@Query("api_key") String auth,
                     @Query("page") Integer page);
}
