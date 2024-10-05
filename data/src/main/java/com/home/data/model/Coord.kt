package com.home.data.model

import com.google.gson.annotations.SerializedName
import com.home.data.base.DataModel

data class Coord(
    @SerializedName("lat") val lat: Double,
    @SerializedName("lon") val long: Double
) : DataModel()
