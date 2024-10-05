package com.home.domain.model.weather

import com.google.gson.annotations.SerializedName

data class Coord(
    @SerializedName("lat") val lat: Double,
    @SerializedName("lon") val long: Double
)
