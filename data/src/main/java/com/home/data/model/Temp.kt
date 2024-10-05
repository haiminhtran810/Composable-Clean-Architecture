package com.home.data.model

import com.google.gson.annotations.SerializedName
import com.home.data.base.DataModel

data class Temp(
    @SerializedName("day") val dt: Double,
    @SerializedName("min") val min: Double,
    @SerializedName("max") val max: Double,
    @SerializedName("night") val night: Double,
    @SerializedName("eve") val eve: Double,
    @SerializedName("morn") val morn: Double
) : DataModel()
