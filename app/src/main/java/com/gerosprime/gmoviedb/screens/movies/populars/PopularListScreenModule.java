package com.gerosprime.gmoviedb.screens.movies.populars;

import dagger.Binds;
import dagger.Module;

@Module
public interface PopularListScreenModule {

    @Binds
    PopularListPresenter
        bindDefaultPresenter(DefaultPopularListPresenter presenter);

}
