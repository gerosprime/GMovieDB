package com.gerosprime.gmoviedb.screens.movies.populars.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.gerosprime.gmoviedb.R;
import com.gerosprime.gmoviedb.components.glide.GlidePopulator;
import com.gerosprime.gmoviedb.models.movies.populars.PopularMovieEntity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PopularMoviesViewHolder
    extends RecyclerView.ViewHolder {


    @BindView(R.id.viewholder_popular_movies_title)
    TextView textViewTitle;

    @BindView(R.id.viewholder_popular_movies_star)
    RatingBar ratingBar;

    @BindView(R.id.viewholder_popular_movies_image)
    ImageView imageView;

    private PopularMovieEntity entity;
    private GlidePopulator glidePopulator;

    private Context context;


    public PopularMoviesViewHolder(@NonNull View itemView,
                                   GlidePopulator glidePopulator) {
        super(itemView);
        this.glidePopulator = glidePopulator;
        this.context = itemView.getContext();
        ButterKnife.bind(this, itemView);

    }

    public void setEntity(PopularMovieEntity entity) {
        this.entity = entity;

        glidePopulator.populateMoviesEntity(imageView,
                entity.getPosterPath()).subscribe();

        ratingBar.setRating(entity.getVoteAverage());
        textViewTitle.setText(entity.getTitle());

    }
}
