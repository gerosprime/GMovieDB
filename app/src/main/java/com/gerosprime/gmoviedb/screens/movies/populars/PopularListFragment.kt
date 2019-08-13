package com.gerosprime.gmoviedb.screens.movies.populars

import android.os.Bundle
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

import com.gerosprime.gmoviedb.R
import com.gerosprime.gmoviedb.components.glide.GlidePopulator
import com.gerosprime.gmoviedb.components.mvp.MovieDBBaseFragment
import com.gerosprime.gmoviedb.models.movies.populars.PopularMovieEntity
import com.gerosprime.gmoviedb.screens.movies.populars.adapter.PopularMoviesAdapter

import javax.inject.Inject

import butterknife.BindView
import butterknife.ButterKnife
import dagger.android.support.AndroidSupportInjection

class PopularListFragment : MovieDBBaseFragment<PopularListView, PopularListPresenter>(), PopularListView {

    @Inject
    lateinit var popularListPresenter: PopularListPresenter

    @Inject
    lateinit var glidePopulator: GlidePopulator

    @BindView(R.id.toolbar)
    lateinit var toolbar: Toolbar

    @BindView(R.id.coordinator)
    lateinit var coordinatorLayout: CoordinatorLayout

    @BindView(R.id.fragment_popular_movies_content)
    lateinit var recyclerView: RecyclerView

    @BindView(R.id.fragment_popular_movies_loading_content)
    lateinit var loadingContent: View

    @BindView(R.id.fragment_popular_movies_error_container)
    lateinit var errorContent: View

    @BindView(R.id.fragment_popular_movies_error_button)
    lateinit var errorButton: Button

    @BindView(R.id.fragment_popular_movies_error_message)
    lateinit var errorMessageTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val inflated = inflater.inflate(R.layout.fragment_popular_movies, container, false)
        ButterKnife.bind(this, inflated)


        return inflated
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        popularListPresenter!!.loadPopulars()
    }

    override fun createPresenter(): PopularListPresenter {
        return popularListPresenter!!
    }

    override fun populatePopulars(movieEntities: List<PopularMovieEntity>) {
        recyclerView!!.adapter = PopularMoviesAdapter(movieEntities, glidePopulator!!)
    }


    override fun hideContentList() {
        recyclerView!!.visibility = View.INVISIBLE
    }

    override fun showContentList() {
        recyclerView!!.visibility = View.VISIBLE
    }

    override fun hideLoadingIndicator() {
        loadingContent!!.visibility = View.INVISIBLE
    }

    override fun showLoadingIndicator() {
        loadingContent!!.visibility = View.VISIBLE
    }

    override fun showContentError() {
        errorContent!!.visibility = View.VISIBLE
    }

    override fun hideContentError() {

        errorContent!!.visibility = View.INVISIBLE
    }

    override fun loadingPopularApiError() {
        errorMessageTextView!!.setText(R.string.popular_list_api_error)
        errorButton!!.setOnClickListener { view -> presenter!!.loadPopulars() }
    }

    override fun loadingPopularTechnicalError() {
        errorMessageTextView!!.setText(R.string.popular_list_technical_error)
        errorButton!!.setOnClickListener { view -> presenter!!.loadPopulars() }
    }

}
