package com.home.data.service.response

import com.google.gson.annotations.SerializedName
import com.home.domain.model.movie.Cast
import com.home.domain.model.movie.Crew

data class MovieCreditsResponse(
    @SerializedName("id") val id: Int? = 0,
    @SerializedName("cast") var cast: ArrayList<Cast>? = null,
    @SerializedName("crew") var crew: ArrayList<Crew>? = null
)