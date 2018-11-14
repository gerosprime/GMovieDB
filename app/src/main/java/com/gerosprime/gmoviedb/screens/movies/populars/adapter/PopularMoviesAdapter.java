package com.gerosprime.gmoviedb.screens.movies.populars.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gerosprime.gmoviedb.R;
import com.gerosprime.gmoviedb.components.glide.GlidePopulator;
import com.gerosprime.gmoviedb.models.movies.populars.PopularMovieEntity;

import java.util.List;

public class PopularMoviesAdapter
    extends RecyclerView.Adapter<PopularMoviesViewHolder> {

    private List<PopularMovieEntity> popularMovieEntities;

    private LayoutInflater layoutInflater;
    private GlidePopulator glidePopulator;


    public PopularMoviesAdapter(List<PopularMovieEntity> popularMovieEntities,
                                GlidePopulator glidePopulator) {
        this.popularMovieEntities = popularMovieEntities;
        this.glidePopulator = glidePopulator;
    }

    @NonNull
    @Override
    public PopularMoviesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        if (layoutInflater == null)
            layoutInflater = LayoutInflater.from(viewGroup.getContext());

        View itemView = layoutInflater.inflate(R.layout.viewholder_popular_movie,
                viewGroup, false);

        return new PopularMoviesViewHolder(itemView, glidePopulator);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularMoviesViewHolder popularMoviesViewHolder, int i) {
        popularMoviesViewHolder.setEntity(popularMovieEntities.get(i));
    }

    @Override
    public int getItemCount() {
        return popularMovieEntities.size();
    }

}
