package com.gerosprime.gmoviedb.screens.movies.populars.adapter

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.gerosprime.gmoviedb.R
import com.gerosprime.gmoviedb.components.glide.GlidePopulator
import com.gerosprime.gmoviedb.models.movies.populars.PopularMovieEntity

class PopularMoviesViewHolder constructor(itemView: View,
                                          private val glidePopulator: GlidePopulator)
    : RecyclerView.ViewHolder(itemView) {

    @BindView(R.id.viewholder_popular_movies_title)
    lateinit var textViewTitle : TextView

    @BindView(R.id.viewholder_popular_movies_star)
    lateinit var ratingBar : RatingBar

    @BindView(R.id.viewholder_popular_movies_image)
    lateinit var imageView : ImageView

    private var context : Context? = null

    private var entity : PopularMovieEntity? = null

    init {

        context = itemView.context
        ButterKnife.bind(this, itemView)

    }

    fun set(entity: PopularMovieEntity) {

        this.entity = entity

        glidePopulator.populateMoviesEntity(imageView, entity.posterPath)
                .subscribe()

        textViewTitle.text = entity.title
        ratingBar.rating = entity.voteAverage


    }

}