package com.home.data.service.response

import com.google.gson.annotations.SerializedName
import com.home.domain.model.movie.Movie

data class MovieResponse(
    @SerializedName("id") val page: Int? = null,
    @SerializedName("total_results") val totalResults: Int? = null,
    @SerializedName("total_pages") val totalPages: Int? = null,
    @SerializedName("results") var results: ArrayList<Movie>? = null
)