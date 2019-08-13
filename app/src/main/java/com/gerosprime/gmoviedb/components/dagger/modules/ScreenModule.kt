package com.gerosprime.gmoviedb.components.dagger.modules

import com.gerosprime.gmoviedb.screens.movies.populars.PopularListFragment
import com.gerosprime.gmoviedb.screens.movies.populars.PopularListScreenModule

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ScreenModule {

    @ContributesAndroidInjector(modules = [PopularListScreenModule::class])
    fun contributePopularListFragment(): PopularListFragment

}
