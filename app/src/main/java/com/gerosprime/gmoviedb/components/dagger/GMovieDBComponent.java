package com.gerosprime.gmoviedb.components.dagger;

import com.gerosprime.gmoviedb.GMovieDBApplication;
import com.gerosprime.gmoviedb.components.dagger.modules.ComponentModule;
import com.gerosprime.gmoviedb.components.dagger.modules.ModelModule;
import com.gerosprime.gmoviedb.components.dagger.modules.MovieDBAndroidModule;
import com.gerosprime.gmoviedb.components.dagger.modules.ScreenModule;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {ScreenModule.class, ModelModule.class, ComponentModule.class,
        MovieDBAndroidModule.class})
@Singleton
public interface GMovieDBComponent {
    void inject(GMovieDBApplication gMovieDBApplication);


    //
    // Adding builder nested interface to provide application context upon creation of component
    // https://proandroiddev.com/dagger-2-component-builder-1f2b91237856

    @Component.Builder
    interface Builder {
        GMovieDBComponent build();
        Builder appModule(MovieDBAndroidModule appModule);
    }

}
