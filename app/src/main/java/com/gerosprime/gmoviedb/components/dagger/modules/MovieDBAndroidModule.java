package com.gerosprime.gmoviedb.components.dagger.modules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class MovieDBAndroidModule {

    private Context context;

    public MovieDBAndroidModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideApplicationContext() {
        return context;
    }

}
