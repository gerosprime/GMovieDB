package com.gerosprime.gmoviedb.components.dagger.modules;

import com.gerosprime.gmoviedb.components.glide.GlideDaggerModule;

import dagger.Module;

@Module(includes = {DaggerModule.class, RetrofitModule.class, RxModule.class,
        GlideDaggerModule.class})
public class ComponentModule {
}
