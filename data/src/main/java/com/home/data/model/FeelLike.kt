package com.home.data.model

import com.google.gson.annotations.SerializedName
import com.home.data.base.DataModel

data class FeelLike(
    @SerializedName("day") val day: Double,
    @SerializedName("night") val night: Double,
    @SerializedName("eve") val eve: Double,
    @SerializedName("morn") val morn: Double
) : DataModel()
