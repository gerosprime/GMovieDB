package com.gerosprime.gmoviedb.models.movies.populars;

import dagger.Binds;
import dagger.Module;

@Module
public interface PopularMoviesModule {

    @Binds
    PopularMoviesLoader bindDefaultRemote(RemotePopularMoviesLoader moviesLoader);

}
