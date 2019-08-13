package com.gerosprime.gmoviedb.screens.movies.populars.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.gerosprime.gmoviedb.R
import com.gerosprime.gmoviedb.components.glide.GlidePopulator
import com.gerosprime.gmoviedb.models.movies.populars.PopularMovieEntity

class PopularMoviesAdapter(private val popularMovieEntities: List<PopularMovieEntity>,
                           private val glidePopulator: GlidePopulator) : RecyclerView.Adapter<PopularMoviesViewHolder>() {

    private var layoutInflater: LayoutInflater? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): PopularMoviesViewHolder {

        if (layoutInflater == null)
            layoutInflater = LayoutInflater.from(viewGroup.context)

        val itemView = layoutInflater!!.inflate(R.layout.viewholder_popular_movie,
                viewGroup, false)

        return PopularMoviesViewHolder(itemView, glidePopulator)
    }

    override fun onBindViewHolder(popularMoviesViewHolder: PopularMoviesViewHolder, i: Int) {
        popularMoviesViewHolder.set(entity = popularMovieEntities[i])
    }

    override fun getItemCount(): Int {
        return popularMovieEntities.size
    }

}
