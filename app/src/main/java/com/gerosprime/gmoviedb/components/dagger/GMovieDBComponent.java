package com.gerosprime.gmoviedb.components.dagger;

import com.gerosprime.gmoviedb.GMovieDBApplication;
import com.gerosprime.gmoviedb.components.dagger.modules.ComponentModule;
import com.gerosprime.gmoviedb.components.dagger.modules.ModelModule;
import com.gerosprime.gmoviedb.components.dagger.modules.ScreenModule;

import dagger.Component;

@Component(modules = {ScreenModule.class, ModelModule.class, ComponentModule.class})
public interface GMovieDBComponent {
    void inject(GMovieDBApplication gMovieDBApplication);
}
