package com.gerosprime.gmoviedb.components.rxjava;

import io.reactivex.CompletableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.SingleTransformer;

public class TestSchedulersComponer
    implements SchedulersComposer {

    @Override
    public <T> SingleTransformer<T, T> singleTransformer(Scheduler subscribeScheduler) {
        return upstream -> upstream;
    }

    @Override
    public CompletableTransformer completableTransformer(Scheduler subscribeScheduler) {
        return upstream -> upstream;
    }

}
