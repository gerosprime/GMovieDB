package com.gerosprime.gmoviedb.models.movies.populars;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PopularMovieResponse {

    private Integer page;

    @SerializedName("results")
    private List<PopularMovieEntity> popularMovieEntities;

    @SerializedName("total_results")
    private Integer totalResults;

    @SerializedName("total_pages")
    private Integer totalPages;

    public Integer getPage() {
        return page;
    }

    public List<PopularMovieEntity> getPopularMovieEntities() {
        return popularMovieEntities;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public Integer getTotalPages() {
        return totalPages;
    }
}
