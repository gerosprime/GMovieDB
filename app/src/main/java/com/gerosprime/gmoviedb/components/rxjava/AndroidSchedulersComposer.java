package com.gerosprime.gmoviedb.components.rxjava;

import javax.inject.Inject;

import io.reactivex.CompletableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class AndroidSchedulersComposer
    implements SchedulersComposer {

    @Inject
    public AndroidSchedulersComposer() {
    }

    @Override
    public <T> SingleTransformer<T, T> singleTransformer(Scheduler subscribeScheduler) {
        return upstream -> upstream.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(subscribeScheduler);
    }

    @Override
    public CompletableTransformer completableTransformer(Scheduler subscribeScheduler) {
        return upstream -> upstream.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(subscribeScheduler);
    }

}
