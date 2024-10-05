package com.home.data.model

import com.google.gson.annotations.SerializedName
import com.home.data.base.DataModel

data class Sys(
    @SerializedName("type") val type: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("country") val country: String,
    @SerializedName("sunrise") val sunrise: Long,
    @SerializedName("sunset") val sunset: Long
) : DataModel()
