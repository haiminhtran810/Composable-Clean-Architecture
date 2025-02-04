package com.home.domain.model.movie

import com.google.gson.annotations.SerializedName

data class Genre(
    @SerializedName("id")
    val id: Int? = 0,

    @SerializedName("homepage")
    val homepage: String? = "",

    @SerializedName("imdb_id")
    val imdbId: String? = ""
)