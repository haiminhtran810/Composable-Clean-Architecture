package com.home.data.model

import com.google.gson.annotations.SerializedName
import com.home.data.base.DataModel

data class Main(
    @SerializedName("temp") val temp: Double,
    @SerializedName("feels_like") val feelsLike: Double,
    @SerializedName("temp_min") val tempMin: Double,
    @SerializedName("temp_max") val tempMax: Double,
    @SerializedName("pressure") val pressure: Double,
    @SerializedName("humidity") val humidity: Int,
    @SerializedName("sea_level") val seaLevel: Double,
    @SerializedName("grnd_level") val grndLevel: Double
) : DataModel()
