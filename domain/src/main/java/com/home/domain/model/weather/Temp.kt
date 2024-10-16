package com.home.domain.model.weather

import com.google.gson.annotations.SerializedName

data class Temp(
    @SerializedName("day") val dt: Double,
    @SerializedName("min") val min: Double,
    @SerializedName("max") val max: Double,
    @SerializedName("night") val night: Double,
    @SerializedName("eve") val eve: Double,
    @SerializedName("morn") val morn: Double
)
