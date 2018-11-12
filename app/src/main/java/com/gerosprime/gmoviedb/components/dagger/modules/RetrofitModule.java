package com.gerosprime.gmoviedb.components.dagger.modules;

import com.gerosprime.gmoviedb.components.retrofit.MovieDBApi;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class RetrofitModule {

    @Provides
    public MovieDBApi provideMovieDBApi() {
        return new MovieDBApi("https://api.themoviedb.org/3/");
    }

    @Provides
    @Named("movieDBAuthToken")
    public String provideMovieDBApiAuthToken() {
        return "aa01ca1c073058a4dab22bf495ce7fc4";
    }

}
