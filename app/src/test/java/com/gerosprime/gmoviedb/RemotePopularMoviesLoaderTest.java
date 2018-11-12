package com.gerosprime.gmoviedb;

import com.gerosprime.gmoviedb.components.dagger.modules.RetrofitModule;
import com.gerosprime.gmoviedb.models.movies.populars.RemotePopularMoviesLoader;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import io.reactivex.observers.TestObserver;

@RunWith(JUnit4.class)
public class RemotePopularMoviesLoaderTest {

    RemotePopularMoviesLoader remotePopularMoviesLoader;

    RetrofitModule retrofitModule;

    @Before
    public void setUp() {

        retrofitModule = new RetrofitModule();
        remotePopularMoviesLoader =
                new RemotePopularMoviesLoader(retrofitModule.provideMovieDBApi(),
                        retrofitModule.provideMovieDBApiAuthToken());
    }


    @Test
    public void testPopularMoviesLoaded() {

        TestObserver testObserver = new TestObserver();
        remotePopularMoviesLoader.loadPopularMovies(1)
                .subscribe(testObserver);

        testObserver.assertComplete();

    }

}
