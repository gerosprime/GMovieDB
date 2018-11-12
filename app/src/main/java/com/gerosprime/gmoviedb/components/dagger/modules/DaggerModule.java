package com.gerosprime.gmoviedb.components.dagger.modules;

import dagger.Module;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

@Module(includes = {AndroidSupportInjectionModule.class, AndroidInjectionModule.class})
public class DaggerModule {
}
