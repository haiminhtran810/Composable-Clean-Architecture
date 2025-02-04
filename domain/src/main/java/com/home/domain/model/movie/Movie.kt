package com.home.domain.model.movie

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("id")
    val id: Int? = 0,

    @SerializedName("adult")
    val adult: Boolean? = false,

    @SerializedName("genres")
    val genres: List<Genre>? = emptyList(),

    @SerializedName("budget")
    val budget: Int? = 0,

    @SerializedName("backdrop_path")
    val backdropPath: String? = "",

    @SerializedName("original_language")
    val originalLanguage: String? = "",

    @SerializedName("original_title")
    val originalTitle: String? = "",

    @SerializedName("overview")
    val overview: String? = "",

    @SerializedName("popularity")
    val popularity: Double? = 0.0,

    @SerializedName("poster_path")
    val posterPath: String? = "",

    @SerializedName("title")
    val title: String? = "",

    @SerializedName("video")
    val video: Boolean? = false,

    @SerializedName("vote_average")
    val voteAverage: Double? = 0.0,

    @SerializedName("vote_count")
    val voteCount: Int? = 0
) 