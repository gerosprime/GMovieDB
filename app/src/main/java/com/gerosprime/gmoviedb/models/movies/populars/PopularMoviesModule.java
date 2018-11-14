package com.gerosprime.gmoviedb.models.movies.populars;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public interface PopularMoviesModule {

    @Binds
    @Singleton
    PopularMoviesLoader bindDefaultRemote(RemotePopularMoviesLoader moviesLoader);

}
