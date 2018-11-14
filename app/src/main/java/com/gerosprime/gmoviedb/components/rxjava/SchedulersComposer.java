package com.gerosprime.gmoviedb.components.rxjava;

import io.reactivex.CompletableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.SingleTransformer;

public interface SchedulersComposer {

    <T> SingleTransformer<T, T> singleTransformer(Scheduler subscribeScheduler);

    CompletableTransformer completableTransformer(Scheduler subscribeScheduler);

}
