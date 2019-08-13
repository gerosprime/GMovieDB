package com.gerosprime.gmoviedb.screens.movies.populars

import dagger.Binds
import dagger.Module

@Module
interface PopularListScreenModule {

    @Binds
    fun bindDefaultPresenter(defuaultPresenter : DefaultPopularListPresenterKotlin) : PopularListPresenter

}