package com.gerosprime.gmoviedb.screens.movies.populars;

import com.gerosprime.gmoviedb.components.rxjava.SchedulersComposer;
import com.gerosprime.gmoviedb.components.rxjava.TestSchedulersComponer;
import com.gerosprime.gmoviedb.models.movies.populars.PopularMovieResponse;
import com.gerosprime.gmoviedb.models.movies.populars.PopularMoviesLoader;
import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.net.SocketException;

import io.reactivex.Single;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@RunWith(MockitoJUnitRunner.class)
public class DefaultPopularListPresenterTest {


    private static final String SAMPLE_JSON_POPULAR_RESPONSE = "{\n" +
            "  \"page\": 1,\n" +
            "  \"results\": [\n" +
            "    {\n" +
            "      \"poster_path\": \"/e1mjopzAS2KNsvpbpahQ1a6SkSn.jpg\",\n" +
            "      \"adult\": false,\n" +
            "      \"overview\": \"From DC Comics comes the Suicide Squad, an antihero team of incarcerated supervillains who act as deniable assets for the United States government, undertaking high-risk black ops missions in exchange for commuted prison sentences.\",\n" +
            "      \"release_date\": \"2016-08-03\",\n" +
            "      \"genre_ids\": [\n" +
            "        14,\n" +
            "        28,\n" +
            "        80\n" +
            "      ],\n" +
            "      \"id\": 297761,\n" +
            "      \"original_title\": \"Suicide Squad\",\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"title\": \"Suicide Squad\",\n" +
            "      \"backdrop_path\": \"/ndlQ2Cuc3cjTL7lTynw6I4boP4S.jpg\",\n" +
            "      \"popularity\": 48.261451,\n" +
            "      \"vote_count\": 1466,\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 5.91\n" +
            "    }\n" +
            "  ],\n" +
            "  \"total_results\": 19629,\n" +
            "  \"total_pages\": 982\n" +
            "}";

    @Mock
    PopularMoviesLoader remotePopularMoviesLoader;

    PopularListPresenter popularListPresenter;

    @Mock
    PopularListView popularListView;

    SchedulersComposer schedulersComposer;

    @Before
    public void setUp() {

        schedulersComposer = new TestSchedulersComponer();

        remotePopularMoviesLoader =
                BDDMockito.mock(PopularMoviesLoader.class);
        popularListPresenter = new DefaultPopularListPresenter(remotePopularMoviesLoader,
                schedulersComposer);
        popularListPresenter.attachView(popularListView);
    }

    private void givenThatMoviesLoaderWillLoadList() {
        given(remotePopularMoviesLoader
        .loadPopularMovies(anyInt()))
                .willReturn(Single.fromCallable(() -> {

                    Gson gson = new Gson();
                    PopularMovieResponse popularMovieResponse =
                            gson.fromJson(SAMPLE_JSON_POPULAR_RESPONSE,
                                    PopularMovieResponse.class);
                    return popularMovieResponse.getPopularMovieEntities();
                }));
    }

    private void givenThatMoviesLoaderWillLoadTechnicalError() {
        given(remotePopularMoviesLoader
                .loadPopularMovies(anyInt()))
                .willReturn(Single.error(new SocketException()));
    }

    @Test
    public void testPresenterLoadingPopularsSuccessful() {
        givenThatMoviesLoaderWillLoadList();
        // givenThatPopularListViewWillGivePage();

        popularListPresenter.loadPopulars();

        then(popularListView).should().hideLoadingIndicator();
        then(popularListView).should().populatePopulars(anyList());
        then(popularListView).should().showContentList();

    }

    @Test
    public void testPresenterLoadingPopularsTechnicalError() {

        givenThatMoviesLoaderWillLoadTechnicalError();

        popularListPresenter.loadPopulars();

        then(popularListView).should().hideLoadingIndicator();
        then(popularListView).should().loadingPopularTechnicalError();
        then(popularListView).should().showContentError();

    }

}