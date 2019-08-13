package com.gerosprime.gmoviedb.screens.movies.populars;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.gerosprime.gmoviedb.R;
import com.gerosprime.gmoviedb.components.glide.GlidePopulator;
import com.gerosprime.gmoviedb.components.mvp.MovieDBBaseFragment;
import com.gerosprime.gmoviedb.models.movies.populars.PopularMovieEntity;
import com.gerosprime.gmoviedb.screens.movies.populars.adapter.PopularMoviesAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;

public class PopularListFragment
    extends MovieDBBaseFragment<PopularListView, PopularListPresenter>
    implements PopularListView {

    @Inject
    PopularListPresenter presenter;

    @Inject
    GlidePopulator glidePopulator;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.coordinator)
    CoordinatorLayout coordinatorLayout;

    @BindView(R.id.fragment_popular_movies_content)
    RecyclerView recyclerView;

    @BindView(R.id.fragment_popular_movies_loading_content)
    View loadingContent;

    @BindView(R.id.fragment_popular_movies_error_container)
    View errorContent;

    @BindView(R.id.fragment_popular_movies_error_button)
    Button errorButton;

    @BindView(R.id.fragment_popular_movies_error_message)
    TextView errorMessageTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View inflated = inflater.inflate(R.layout.fragment_popular_movies, container, false);
        ButterKnife.bind(this, inflated);
        return inflated;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.loadPopulars();
    }

    @Override
    public PopularListPresenter createPresenter() {
        return presenter;
    }

    @Override
    public void populatePopulars(List<PopularMovieEntity> movieEntities) {
        recyclerView.setAdapter(new PopularMoviesAdapter(movieEntities, glidePopulator));
    }

    @Override
    public void hideContentList() {
        recyclerView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showContentList() {
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadingIndicator() {
        loadingContent.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showLoadingIndicator() {
        loadingContent.setVisibility(View.VISIBLE);
    }

    @Override
    public void showContentError() {
        errorContent.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideContentError() {

        errorContent.setVisibility(View.INVISIBLE);
    }

    @Override
    public void loadingPopularApiError() {
        errorMessageTextView.setText(R.string.popular_list_api_error);
        errorButton.setOnClickListener(view -> presenter.loadPopulars());
    }

    @Override
    public void loadingPopularTechnicalError() {
        errorMessageTextView.setText(R.string.popular_list_technical_error);
        errorButton.setOnClickListener(view -> presenter.loadPopulars());
    }

}
