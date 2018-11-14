package com.gerosprime.gmoviedb.components.glide;

import android.widget.ImageView;

import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import io.reactivex.Completable;

public class DefaultGlidePopulator
        implements GlidePopulator {

    public DefaultGlidePopulator() {
    }

    @Override
    public Completable populateMoviesEntity(ImageView imageView,
                                            String imagePath) {
        String url = String.format("https://image.tmdb.org/t/p/original%s",imagePath);
        RequestOptions requestOptions = new RequestOptions()
                .centerCrop()
                .transform(new RoundedCorners(16));

        return Completable.fromAction(() -> {

            GlideRequests glideRequests = GlideApp.with(imageView);
            glideRequests.setRequestOptions(requestOptions);
            glideRequests.load(url).into(imageView);

        });
    }
}
