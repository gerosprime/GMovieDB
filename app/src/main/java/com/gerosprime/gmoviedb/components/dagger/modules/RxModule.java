package com.gerosprime.gmoviedb.components.dagger.modules;

import com.gerosprime.gmoviedb.components.rxjava.AndroidSchedulersComposer;
import com.gerosprime.gmoviedb.components.rxjava.SchedulersComposer;

import dagger.Module;
import dagger.Provides;

@Module
public class RxModule {

    @Provides
    SchedulersComposer provideAndroidScheduler() {
        return new AndroidSchedulersComposer();
    }

}
