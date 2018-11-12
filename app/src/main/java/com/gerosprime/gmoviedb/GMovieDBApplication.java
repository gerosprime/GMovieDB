package com.gerosprime.gmoviedb;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;

import com.gerosprime.gmoviedb.components.dagger.DaggerGMovieDBComponent;
import com.gerosprime.gmoviedb.components.dagger.GMovieDBComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class GMovieDBApplication
    extends Application implements HasSupportFragmentInjector, HasActivityInjector {


    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;


    GMovieDBComponent gMovieDBComponent;

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        gMovieDBComponent = DaggerGMovieDBComponent.create();
        gMovieDBComponent.inject(this);
    }
}
