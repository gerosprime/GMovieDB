package com.gerosprime.gmoviedb.components.glide;

import android.widget.ImageView;

import com.gerosprime.gmoviedb.models.movies.populars.PopularMovieEntity;

import io.reactivex.Completable;

public interface GlidePopulator {

    Completable populateMoviesEntity(ImageView imageView,
                                     String imagePath);

}
