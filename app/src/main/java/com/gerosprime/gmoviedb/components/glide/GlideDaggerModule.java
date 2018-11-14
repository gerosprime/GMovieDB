package com.gerosprime.gmoviedb.components.glide;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class GlideDaggerModule {

    @Provides
    @Singleton
    GlidePopulator providePopulator() {
        return new DefaultGlidePopulator();
    }

}
