package com.home.domain.model.movie

import com.google.gson.annotations.SerializedName
import com.home.domain.model.movie.Result

data class Videos(
    @SerializedName("id")
    val id: Int,
    @SerializedName("results")
    val results: List<Result>
)